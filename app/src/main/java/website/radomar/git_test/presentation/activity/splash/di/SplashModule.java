package website.radomar.git_test.presentation.activity.splash.di;

import dagger.Module;
import dagger.Provides;
import website.radomar.git_test.di.ActivityScope;
import website.radomar.git_test.presentation.activity.splash.SplashContract;
import website.radomar.git_test.presentation.activity.splash.SplashPresenter;

/**
 * Created by Radomar on 20.06.2017.
 */

@Module
public class SplashModule {

    @Provides @ActivityScope
    public SplashContract.Presenter injectSplashPresenter() {
        return new SplashPresenter();
    }
}
