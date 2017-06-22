package website.radomar.git_test.presentation.activity.repositories.di;

import dagger.Component;
import website.radomar.git_test.di.ActivityScope;
import website.radomar.git_test.di.AppComponent;
import website.radomar.git_test.presentation.activity.repositories.RepositoriesActivity;

/**
 * Created by Radomar on 20.06.2017.
 */

@ActivityScope
@Component(dependencies = {AppComponent.class}, modules = {RepositoriesModule.class})
public interface RepositoriesComponent {
    void inject(RepositoriesActivity repositoriesActivity);
}
