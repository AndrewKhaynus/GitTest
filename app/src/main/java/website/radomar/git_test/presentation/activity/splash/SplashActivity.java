package website.radomar.git_test.presentation.activity.splash;

import website.radomar.git_test.di.AppComponent;
import website.radomar.git_test.presentation.base.BaseActivity;
import website.radomar.git_test.presentation.activity.splash.di.DaggerSplashComponent;

/**
 * Created by Radomar on 20.06.2017.
 */

public final class SplashActivity extends BaseActivity<SplashContract.Presenter>
        implements SplashContract.View<SplashContract.Presenter> {

    @Override
    public void findUI() {

    }

    @Override
    public void setupUI() {

    }

    @Override
    public void setupComponent(AppComponent appComponent) {
        DaggerSplashComponent.builder()
                .appComponent(appComponent)
                .build().inject(this);
    }

    @Override
    public int getLayoutRes() {
        return 0;
    }

    @Override
    public void closeActivity() {
        finish();
    }
}
