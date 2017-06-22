package website.radomar.git_test.presentation.activity.repositories.di;

import dagger.Module;
import dagger.Provides;
import website.radomar.git_test.data.DataProvider;
import website.radomar.git_test.data.providers.RepositoriesProvider;
import website.radomar.git_test.di.ActivityScope;
import website.radomar.git_test.domain.interactors.RepositoriesInteractor;
import website.radomar.git_test.domain.repository.RepositoriesRepository;
import website.radomar.git_test.network.RestApiClient;
import website.radomar.git_test.presentation.activity.repositories.RepositoriesContract;
import website.radomar.git_test.presentation.activity.repositories.RepositoriesPresenter;
import website.radomar.git_test.utils.ErrorHandler;
import website.radomar.git_test.utils.ImageUtils;

/**
 * Created by Radomar on 20.06.2017.
 */

@Module
public class RepositoriesModule {

    @Provides @ActivityScope
    public RepositoriesContract.Presenter provideProfilePresenter(RepositoriesInteractor repositoriesInteractor,
                                                                  ErrorHandler errorHandler,
                                                                  ImageUtils imageUtils,
                                                                  DataProvider dataProvider) {
        return new RepositoriesPresenter(repositoriesInteractor, errorHandler, imageUtils, dataProvider);
    }

    @Provides @ActivityScope
    public RepositoriesInteractor provideRepoInteractor(RepositoriesRepository repoRepository) {
        return new RepositoriesInteractor(repoRepository);
    }

    @Provides @ActivityScope
    public RepositoriesRepository provideRepoRepository(RestApiClient restApiClient) {
        return new RepositoriesProvider(restApiClient);
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
