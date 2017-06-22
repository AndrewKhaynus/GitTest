package website.radomar.git_test.domain.repository;

import java.util.List;

import retrofit2.Response;
import rx.Observable;
import website.radomar.git_test.data.model.User;
import website.radomar.git_test.data.model.UserRepository;
import website.radomar.git_test.network.responses.SearchResponse;

/**
 * Created by Radomar on 20.06.2017.
 */

public interface ProfileRepository {
    Observable<User> getUser(String token);
    Observable<List<UserRepository>> getUserRepositories(String token);
}
