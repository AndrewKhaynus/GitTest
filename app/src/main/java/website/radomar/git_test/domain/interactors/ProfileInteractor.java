package website.radomar.git_test.domain.interactors;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Response;
import rx.Observable;
import website.radomar.git_test.data.model.User;
import website.radomar.git_test.data.model.UserRepository;
import website.radomar.git_test.domain.repository.ProfileRepository;
import website.radomar.git_test.network.responses.SearchResponse;

/**
 * Created by Radomar on 20.06.2017.
 */

public class ProfileInteractor {

    private ProfileRepository profileRepository;

    @Inject
    public ProfileInteractor(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Observable<User> getUser(String token) {
        return profileRepository.getUser(token);
    }

    public Observable<List<UserRepository>> getUserRepositories(String token) {
        return profileRepository.getUserRepositories(token);
    }

//    public Observable<Response<SearchResponse>> getSearchResponse(String querry, String sort, int page) {
//        return profileRepository.getSearch(querry, sort, page);
//    }
}
