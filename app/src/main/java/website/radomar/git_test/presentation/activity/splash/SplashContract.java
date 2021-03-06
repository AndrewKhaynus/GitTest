package website.radomar.git_test.presentation.activity.splash;

import website.radomar.git_test.presentation.base.BaseActivityContract;

/**
 * Created by Radomar on 20.06.2017.
 */

public interface SplashContract {

    interface View<P extends Presenter> extends BaseActivityContract.View<P> {
        void closeActivity();
    }

    abstract class Presenter<V extends View> extends BaseActivityContract.Presenter<V> {
        protected abstract void startWithPostDelayed();
    }
}
