package website.radomar.git_test.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import website.radomar.git_test.data.DataProvider;
import website.radomar.git_test.data.PreferenceController;
import website.radomar.git_test.data.RealmDataProvider;
import website.radomar.git_test.data.SharedPreferenceManager;

/**
 * Created by Radomar on 20.06.2017.
 */

@Module
public class AndroidModule {

    @Provides @Singleton
    public PreferenceController providePreferenceController(Context appContext) {
        return new SharedPreferenceManager(appContext);
    }

    @Provides @Singleton
    public DataProvider provideDataProvider() {
        return new RealmDataProvider();
    }
}
