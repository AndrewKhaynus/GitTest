package website.radomar.git_test.di;

import javax.inject.Singleton;

import dagger.Component;
import website.radomar.git_test.App;
import website.radomar.git_test.data.DataProvider;
import website.radomar.git_test.data.PreferenceController;
import website.radomar.git_test.network.RestApiClient;

/**
 * Created by Radomar on 20.06.2017.
 */

@Singleton
@Component(modules = {AppModule.class, AndroidModule.class})
public interface AppComponent {

    void inject(App app);

    RestApiClient getRestClient();

    PreferenceController getPreferenceController();

    DataProvider getDataProvider();
}
