package website.radomar.git_test.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import website.radomar.git_test.App;
import website.radomar.git_test.network.RestApiClient;

/**
 * Created by Radomar on 20.06.2017.
 */

@Module
public class AppModule {

    private App application;

    public AppModule(App application) {
        this.application = application;
    }

    @Provides @Singleton
    Context provideContext(){
        return application.getApplicationContext();
    }

    @Provides
    public RestApiClient provideRestClient(){ return RestApiClient.getInstance(); }
}
