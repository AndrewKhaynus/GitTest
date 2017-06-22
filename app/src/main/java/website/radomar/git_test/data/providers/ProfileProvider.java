package website.radomar.git_test.data.providers;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Response;
import rx.Observable;
import website.radomar.git_test.data.model.User;
import website.radomar.git_test.data.model.UserRepository;
import website.radomar.git_test.domain.repository.ProfileRepository;
import website.radomar.git_test.network.RestApiClient;
import website.radomar.git_test.network.responses.SearchResponse;

/**
 * Created by Radomar on 20.06.2017.
 */

public class ProfileProvider implements ProfileRepository {

    private RestApiClient restApiClient;

    @Inject
    public ProfileProvider(RestApiClient restApiClient) {
        this.restApiClient = restApiClient;
    }

    @Override
    public Observable<User> getUser(String token) {
        return restApiClient.repo().getCurrentUser(token);
    }

    @Override
    public Observable<List<UserRepository>> getUserRepositories(String token) {
        return restApiClient.repo().getCurrentUserRepos(token);
    }
}
