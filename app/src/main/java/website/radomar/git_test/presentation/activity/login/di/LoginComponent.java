package website.radomar.git_test.presentation.activity.login.di;

import dagger.Component;
import website.radomar.git_test.di.ActivityScope;
import website.radomar.git_test.di.AppComponent;
import website.radomar.git_test.presentation.activity.login.LoginActivity;

/**
 * Created by Radomar on 20.06.2017.
 */


@ActivityScope
@Component(dependencies = {AppComponent.class}, modules = {LoginModule.class})
public interface LoginComponent {
    void inject(LoginActivity loginActivity);
}
