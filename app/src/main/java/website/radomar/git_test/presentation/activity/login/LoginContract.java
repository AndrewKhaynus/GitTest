package website.radomar.git_test.presentation.activity.login;

import android.content.ContentResolver;

import website.radomar.git_test.presentation.base.BaseActivity;
import website.radomar.git_test.presentation.base.BaseActivityContract;

/**
 * Created by Radomar on 20.06.2017.
 */

public interface LoginContract {

    interface View<P extends Presenter> extends BaseActivityContract.View<P> {
        void changeProgressState(boolean isVisible);
        ContentResolver getResolver();
        <T extends BaseActivity> void startAloneActivity(Class<T> tClass);
        void showLoginError(String errorMessage);
        void showPasswordError(String errorMessage);
    }

    abstract class Presenter<V extends View> extends BaseActivityContract.Presenter<V> {
        abstract void clickLogin(String login, String password);
    }
}
