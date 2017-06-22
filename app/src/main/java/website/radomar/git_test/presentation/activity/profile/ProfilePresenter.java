package website.radomar.git_test.presentation.activity.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import website.radomar.git_test.Constants;
import website.radomar.git_test.data.PreferenceController;
import website.radomar.git_test.data.model.User;
import website.radomar.git_test.data.model.UserRepository;
import website.radomar.git_test.domain.interactors.ProfileInteractor;
import website.radomar.git_test.presentation.activity.profile.supports.OwnerRecyclerAdapter;
import website.radomar.git_test.presentation.activity.repositories.RepositoriesActivity;
import website.radomar.git_test.presentation.base.BaseRecyclerAdapter;
import website.radomar.git_test.utils.ErrorHandler;
import website.radomar.git_test.utils.ImageUtils;

/**
 * Created by Radomar on 20.06.2017.
 */

public final class ProfilePresenter extends ProfileContract.Presenter<ProfileContract.View> {

    private ProfileInteractor profileInteractor;
    private PreferenceController preferenceController;
    private ErrorHandler errorHandler;
    private ImageUtils imageUtils;

    private BaseRecyclerAdapter recyclerAdapter;

    @Inject
    public ProfilePresenter(ProfileInteractor profileInteractor,
                            PreferenceController preferenceController,
                            ErrorHandler errorHandler,
                            ImageUtils imageUtils) {
        this.profileInteractor = profileInteractor;
        this.preferenceController = preferenceController;
        this.errorHandler = errorHandler;
        this.imageUtils = imageUtils;
    }

    @Override
    public void onViewCreated(@Nullable Bundle savedInstanceState) {
        super.onViewCreated(savedInstanceState);
        recyclerAdapter = new OwnerRecyclerAdapter();
        view.setRecyclerAdapter(recyclerAdapter);
        sendProfileRequest();
    }

    private void sendProfileRequest() {
        view.changeProgressState(true);
        addSubscription(profileInteractor.getUser(preferenceController.getToken())
                .timeout(Constants.Api.TIMEOUT, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::successProfile, this::error));
    }

    private void error(Throwable throwable) {
        view.changeProgressState(false);
        errorHandler.onError(view, throwable);
    }

    private void successProfile(User user) {
        view.setProfile(user);
        addSubscription(profileInteractor.getUserRepositories(preferenceController.getToken())
                .timeout(Constants.Api.TIMEOUT, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::successRepositories, this::error));
    }

    private void successRepositories(List<UserRepository> repositories) {
        view.changeProgressState(false);
        recyclerAdapter.addAll(repositories);
    }

    @Override
    void clickSearch(String query) {
        if (!TextUtils.isEmpty(query)) {
            view.startActivity(RepositoriesActivity.class, prepareSearchBundle(query));
        }
    }

    private Bundle prepareSearchBundle(String search) {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.Activity.SEARCH_KEY, search);
        return bundle;
    }

    @Override
    ImageUtils getImageUtils() {
        return imageUtils;
    }
}
