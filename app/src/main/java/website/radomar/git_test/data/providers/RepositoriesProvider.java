package website.radomar.git_test.data.providers;

import javax.inject.Inject;

import retrofit2.Response;
import rx.Observable;
import website.radomar.git_test.domain.repository.RepositoriesRepository;
import website.radomar.git_test.network.RestApiClient;
import website.radomar.git_test.network.responses.SearchResponse;

/**
 * Created by Radomar on 20.06.2017.
 */

public class RepositoriesProvider implements RepositoriesRepository {

    private RestApiClient restApiClient;

    @Inject
    public RepositoriesProvider(RestApiClient restApiClient) {
        this.restApiClient = restApiClient;
    }

    @Override
    public Observable<Response<SearchResponse>> getSearchRepo(String query, String sort, int page, int perPage) {
        return restApiClient.repo().search(query, sort, page, perPage);
    }
}
