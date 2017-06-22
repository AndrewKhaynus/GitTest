package website.radomar.git_test.data.providers;

import java.util.List;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import rx.Observable;
import website.radomar.git_test.domain.repository.LoginRepository;
import website.radomar.git_test.network.RestApiClient;
import website.radomar.git_test.network.requests.LoginRequest;
import website.radomar.git_test.network.responses.LoginResponse;

/**
 * Created by Radomar on 20.06.2017.
 */

public class LoginProvider implements LoginRepository {

    private RestApiClient restApiClient;

    @Inject
    public LoginProvider(RestApiClient restApiClient) {
        this.restApiClient = restApiClient;
    }

    @Override
    public Observable<List<LoginResponse>> getAuthorizations(String credentials) {
        return restApiClient.auth().getAuthorizations(credentials);
    }

    @Override
    public Observable<ResponseBody> deleteAuth(String basic, String id) {
        return restApiClient.auth().delete(basic, id);
    }

    @Override
    public Observable<LoginResponse> loginUser(String basic, LoginRequest loginRequest) {
        return restApiClient.auth().loginUser(basic, loginRequest);
    }
}
