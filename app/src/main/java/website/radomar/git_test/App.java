package website.radomar.git_test;

import android.app.Application;

import com.facebook.stetho.Stetho;

import io.realm.Realm;
import website.radomar.git_test.di.AndroidModule;
import website.radomar.git_test.di.AppComponent;
import website.radomar.git_test.di.AppModule;
import website.radomar.git_test.di.DaggerAppComponent;

/**
 * Created by Radomar on 20.06.2017.
 */

public class App extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .androidModule(new AndroidModule())
                .appModule(new AppModule(this)).build();

        Stetho.initializeWithDefaults(this);
        Realm.init(this);
    }

    public AppComponent getAppComponent() {
        return this.appComponent;
    }
}
