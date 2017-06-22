package website.radomar.git_test.presentation.activity.splash.di;

import dagger.Component;
import website.radomar.git_test.di.ActivityScope;
import website.radomar.git_test.di.AppComponent;
import website.radomar.git_test.presentation.activity.splash.SplashActivity;

/**
 * Created by Radomar on 20.06.2017.
 */

@ActivityScope
@Component(dependencies = {AppComponent.class}, modules = {SplashModule.class})
public interface SplashComponent {
    void inject(SplashActivity activity);
}
