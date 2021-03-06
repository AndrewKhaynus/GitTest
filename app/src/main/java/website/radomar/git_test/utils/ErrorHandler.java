package website.radomar.git_test.utils;

import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import retrofit2.adapter.rxjava.HttpException;
import website.radomar.git_test.R;
import website.radomar.git_test.presentation.base.BaseActivityContract;

/**
 * Created by Radomar on 20.06.2017.
 */

public class ErrorHandler {

    public void onError(BaseActivityContract.View view, Throwable throwable) {
        if(throwable instanceof TimeoutException && throwable instanceof UnknownHostException) {
            view.showErrorMessage(view.getStringValue(R.string.error_no_internet));
        }
        if (throwable instanceof HttpException) {
            switch (((HttpException) throwable).code()) {
                case 401:
                    view.showErrorMessage(((HttpException) throwable).message());
                    break;
                case 422:
                    view.showErrorMessage(((HttpException) throwable).message());
                    break;
                default:
                    view.showErrorMessage(view.getStringValue(R.string.error_unknown));
                    break;
            }
        }
    }

    public boolean isUserUnregister(Throwable throwable) {
        if (throwable instanceof HttpException) {
            return ((HttpException) throwable).code() == 401;
        }
        return false;
    }
}
