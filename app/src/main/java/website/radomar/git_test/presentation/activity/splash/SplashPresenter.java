package website.radomar.git_test.presentation.activity.splash;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import website.radomar.git_test.presentation.activity.login.LoginActivity;

/**
 * Created by Radomar on 20.06.2017.
 */

public final class SplashPresenter extends SplashContract.Presenter<SplashContract.View>  {

    private Handler handler;
    private static final long SPLASH_DELAY = 3000;

    @Override
    public void onViewCreated(@Nullable Bundle savedInstanceState) {
        super.onViewCreated(savedInstanceState);

        startWithPostDelayed();
    }

    @Override
    protected void startWithPostDelayed() {
        handler = new Handler();
        handler.postDelayed(() -> {
            view.startActivity(LoginActivity.class, null);
            view.closeActivity();
        }, SPLASH_DELAY);
    }
}
