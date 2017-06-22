package website.radomar.git_test.domain.repository;

import retrofit2.Response;
import rx.Observable;
import website.radomar.git_test.network.responses.SearchResponse;

/**
 * Created by Radomar on 20.06.2017.
 */

public interface RepositoriesRepository {
    Observable<Response<SearchResponse>> getSearchRepo(String query, String sort, int page, int perPage);
}
