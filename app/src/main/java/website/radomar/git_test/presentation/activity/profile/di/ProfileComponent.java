package website.radomar.git_test.presentation.activity.profile.di;

import dagger.Component;
import website.radomar.git_test.di.ActivityScope;
import website.radomar.git_test.di.AppComponent;
import website.radomar.git_test.presentation.activity.profile.ProfileActivity;

/**
 * Created by Radomar on 20.06.2017.
 */

@ActivityScope
@Component(dependencies = {AppComponent.class}, modules = {ProfileModule.class})
public interface ProfileComponent {
    void inject(ProfileActivity profileActivity);
}
