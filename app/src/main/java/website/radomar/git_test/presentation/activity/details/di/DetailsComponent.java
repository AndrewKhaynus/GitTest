package website.radomar.git_test.presentation.activity.details.di;

import dagger.Component;
import website.radomar.git_test.di.ActivityScope;
import website.radomar.git_test.di.AppComponent;
import website.radomar.git_test.presentation.activity.details.DetailsActivity;

/**
 * Created by Radomar on 20.06.2017.
 */

@ActivityScope
@Component(dependencies = {AppComponent.class}, modules = {DetailsModule.class})
public interface DetailsComponent {
    void inject(DetailsActivity detailsActivity);
}
