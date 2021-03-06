package website.radomar.git_test.presentation.activity.login;

import android.os.Build;
import android.provider.Settings;
import android.util.Base64;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import website.radomar.git_test.Constants;
import website.radomar.git_test.R;
import website.radomar.git_test.data.PreferenceController;
import website.radomar.git_test.domain.interactors.LoginInteractor;
import website.radomar.git_test.network.requests.LoginRequest;
import website.radomar.git_test.network.responses.LoginResponse;
import website.radomar.git_test.presentation.activity.profile.ProfileActivity;
import website.radomar.git_test.utils.ErrorHandler;
import website.radomar.git_test.utils.ValidationUtils;

/**
 * Created by Radomar on 20.06.2017.
 */

public final class LoginPresenter extends LoginContract.Presenter<LoginContract.View> {

    private LoginInteractor loginInteractor;
    private PreferenceController preferenceController;
    private ErrorHandler errorHandler;
    private ValidationUtils validationUtils;
    private String basic;

    @Inject
    public LoginPresenter(LoginInteractor loginInteractor,
                          PreferenceController preferenceController,
                          ErrorHandler errorHandler,
                          ValidationUtils validationUtils) {
        this.loginInteractor        = loginInteractor;
        this.preferenceController   = preferenceController;
        this.errorHandler           = errorHandler;
        this.validationUtils        = validationUtils;
    }

    @Override
    void clickLogin(String login, String password) {
        if (login.isEmpty()) {
            view.showLoginError(view.getStringValue(R.string.login_empty));
            return;
        }
        if (password.isEmpty()) {
            view.showPasswordError(view.getStringValue(R.string.password_empty));
            return;
        }
        if (!validationUtils.isValidLogin(login)) {
            view.showLoginError(view.getStringValue(R.string.login_not_valid));
            return;
        }
        if (!validationUtils.isValidPassword(password)) {
            view.showPasswordError(view.getStringValue(R.string.password_not_valid));
            return;
        }

        String credentials = login + ":" + password;
        basic = "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);

        view.changeProgressState(true);
        addSubscription(loginInteractor.getAuthorizations(basic)
                .timeout(Constants.Api.TIMEOUT, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::successAuth, this::errorAuth));
    }

    private void successAuth(List<LoginResponse> responses) {
        onCheckAlreadyExistUser(basic, responses);
        loginUser();
    }

    private void errorAuth(Throwable throwable) {
        if (errorHandler.isUserUnregister(throwable)) {
            loginUser();
        } else {
            errorHandler.onError(view, throwable);
        }
    }

    private void loginUser() {
        addSubscription(loginInteractor.loginUser(basic, createLoginRequest())
                .timeout(Constants.Api.TIMEOUT, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .map(loginResponse -> loginResponse.token)
                .subscribe(this::successLogin, this::error));
    }

    private void onCheckAlreadyExistUser(String basic, List<LoginResponse> loginResponses) {
        for (LoginResponse loginResponse : loginResponses) {
            String fingerprint = loginResponse.fingerprint;
            if (fingerprint != null && fingerprint.equals(getHashedDeviceId())){
                addSubscription(loginInteractor.deleteAuth(basic, loginResponse.id)
                        .timeout(Constants.Api.TIMEOUT, TimeUnit.SECONDS)
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe());
            }
        }
    }

    private void successLogin(String token) {
        view.changeProgressState(false);
        preferenceController.saveToken(token);
        view.startAloneActivity(ProfileActivity.class);
    }

    private void error(Throwable throwable) {
        view.changeProgressState(false);
        errorHandler.onError(view, throwable);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    private LoginRequest createLoginRequest() {
        LoginRequest loginRequest   = new LoginRequest();
        loginRequest.appKey         = view.getStringValue(R.string.client_id);
        loginRequest.appSecret      = view.getStringValue(R.string.client_secret_id);
        loginRequest.note           = getDeviceDescription();
        loginRequest.fingerprint    = getHashedDeviceId();
        loginRequest.scopes         = Collections.singletonList("public_repo");
        return loginRequest;
    }

    private String getDeviceDescription() {
        return view.getStringValue(R.string.app_name) + " " + Build.MANUFACTURER + " " + Build.MODEL;
    }

    private String getHashedDeviceId() {
        String androidId = Settings.Secure.getString(view.getResolver(),
                Settings.Secure.ANDROID_ID);
        if (androidId == null) {
            androidId = Build.FINGERPRINT;
        }

        try {
            MessageDigest digest    = MessageDigest.getInstance("SHA-1");
            byte[] result           = digest.digest(androidId.getBytes("UTF-8"));
            StringBuilder sb        = new StringBuilder();
            for (byte b : result) {
                sb.append(String.format(Locale.US, "%02X", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            // won't happen
            return androidId;
        }
    }
}
