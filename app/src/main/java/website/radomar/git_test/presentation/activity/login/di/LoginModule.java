package website.radomar.git_test.presentation.activity.login.di;

import dagger.Module;
import dagger.Provides;
import website.radomar.git_test.data.PreferenceController;
import website.radomar.git_test.data.providers.LoginProvider;
import website.radomar.git_test.di.ActivityScope;
import website.radomar.git_test.domain.interactors.LoginInteractor;
import website.radomar.git_test.domain.repository.LoginRepository;
import website.radomar.git_test.network.RestApiClient;
import website.radomar.git_test.presentation.activity.login.LoginContract;
import website.radomar.git_test.presentation.activity.login.LoginPresenter;
import website.radomar.git_test.utils.ErrorHandler;
import website.radomar.git_test.utils.ValidationUtils;

/**
 * Created by Radomar on 20.06.2017.
 */

@Module
public class LoginModule {

    @Provides @ActivityScope
    public LoginContract.Presenter provideLoginPresenter(LoginInteractor interactor,
                                                         PreferenceController controller,
                                                         ErrorHandler errorHandler,
                                                         ValidationUtils validationUtils) {
        return new LoginPresenter(interactor, controller, errorHandler, validationUtils);
    }

    @Provides @ActivityScope
    public LoginInteractor provideLoginInteractor(LoginRepository loginRepository) {
        return new LoginInteractor(loginRepository);
    }

    @Provides @ActivityScope
    public LoginRepository provideLoginRepository(RestApiClient restApiClient) {
        return new LoginProvider(restApiClient);
    }

    @Provides @ActivityScope
    public ErrorHandler provideErrorHandler() {
        return new ErrorHandler();
    }

    @Provides @ActivityScope
    public ValidationUtils provideValidationUtils() {
        return new ValidationUtils();
    }
}
