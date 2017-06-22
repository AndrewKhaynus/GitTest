package website.radomar.git_test.network;

import java.util.List;

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import website.radomar.git_test.data.model.User;
import website.radomar.git_test.data.model.UserRepository;
import website.radomar.git_test.network.responses.SearchResponse;

/**
 * Created by Radomar on 20.06.2017.
 */

public interface ApiRepository {

    @GET(Config.GET_USER)
    Observable<User> getCurrentUser(@Query(Config.ACCESS_TOKEN) String token);

    @GET(Config.GET_USER_REPO)
    Observable<List<UserRepository>> getCurrentUserRepos(@Query(Config.ACCESS_TOKEN) String token);

    @GET(Config.GET_REPO)
    Observable<Response<SearchResponse>> search(@Query(Config.SERACH) String searchQuery, @Query("sort") String sort, @Query("page") int page, @Query("per_page") int perPage);
}
