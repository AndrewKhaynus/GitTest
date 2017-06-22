package website.radomar.git_test.domain.interactors;

import java.util.List;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import rx.Observable;
import website.radomar.git_test.domain.repository.LoginRepository;
import website.radomar.git_test.network.requests.LoginRequest;
import website.radomar.git_test.network.responses.LoginResponse;

/**
 * Created by Radomar on 20.06.2017.
 */

public class LoginInteractor  {

    private LoginRepository loginRepository;

    @Inject
    public LoginInteractor(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public Observable<List<LoginResponse>> getAuthorizations(String credentials) {
        return loginRepository.getAuthorizations(credentials);
    }

    public Observable<ResponseBody> deleteAuth(String basic, String id) {
        return loginRepository.deleteAuth(basic, id);
    }

    public Observable<LoginResponse> loginUser(String basic, LoginRequest loginRequest) {
        return loginRepository.loginUser(basic, loginRequest);
    }
}
