package website.radomar.git_test.domain.interactors;

import javax.inject.Inject;

import retrofit2.Response;
import rx.Observable;
import website.radomar.git_test.domain.repository.RepositoriesRepository;
import website.radomar.git_test.network.responses.SearchResponse;

/**
 * Created by Radomar on 20.06.2017.
 */

public class RepositoriesInteractor {

    private RepositoriesRepository repositoriesRepository;

    @Inject
    public RepositoriesInteractor(RepositoriesRepository repositoriesRepository) {
        this.repositoriesRepository = repositoriesRepository;
    }

    public Observable<Response<SearchResponse>> getSearchRepo(String query, String sort, int page, int perPage) {
        return repositoriesRepository.getSearchRepo(query, sort, page, perPage);
    }
}
