package website.radomar.git_test.presentation.activity.profile.di;

import dagger.Module;
import dagger.Provides;
import website.radomar.git_test.data.PreferenceController;
import website.radomar.git_test.data.providers.ProfileProvider;
import website.radomar.git_test.di.ActivityScope;
import website.radomar.git_test.domain.interactors.ProfileInteractor;
import website.radomar.git_test.domain.repository.ProfileRepository;
import website.radomar.git_test.network.RestApiClient;
import website.radomar.git_test.presentation.activity.profile.ProfileContract;
import website.radomar.git_test.presentation.activity.profile.ProfilePresenter;
import website.radomar.git_test.utils.ErrorHandler;
import website.radomar.git_test.utils.ImageUtils;

/**
 * Created by Radomar on 20.06.2017.
 */

@Module
public class ProfileModule {

    @Provides @ActivityScope
    public ProfileContract.Presenter provideProfilePresenter(ProfileInteractor profileInteractor,
                                                             PreferenceController preferenceController,
                                                             ErrorHandler errorHandler,
                                                             ImageUtils imageUtils) {
        return new ProfilePresenter(profileInteractor, preferenceController, errorHandler, imageUtils);
    }

    @Provides @ActivityScope
    public ProfileInteractor provideProfileInteractor(ProfileRepository profileRepository) {
        return new ProfileInteractor(profileRepository);
    }

    @Provides @ActivityScope
    public ProfileRepository provideProfileRepository(RestApiClient restApiClient) {
        return new ProfileProvider(restApiClient);
    }

    @Provides @ActivityScope
    public ErrorHandler provideErrorHandler() {
        return new ErrorHandler();
    }

    @Provides @ActivityScope
    public ImageUtils provideImageUtils() {
        return new ImageUtils();
    }
}
