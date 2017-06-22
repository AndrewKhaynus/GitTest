package website.radomar.git_test.domain.repository;

import java.util.List;

import okhttp3.ResponseBody;
import rx.Observable;
import website.radomar.git_test.network.requests.LoginRequest;
import website.radomar.git_test.network.responses.LoginResponse;

/**
 * Created by Radomar on 20.06.2017.
 */

public interface LoginRepository {
    Observable<List<LoginResponse>> getAuthorizations(String credentials);
    Observable<ResponseBody> deleteAuth(String basic, String id);
    Observable<LoginResponse> loginUser(String basic, LoginRequest loginRequest);
}
