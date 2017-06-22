package website.radomar.git_test.presentation.base;

import android.support.annotation.CheckResult;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;

/**
 * Created by Radomar on 20.06.2017.
 */

public interface BaseView<P> {

    void showToast(String message);
    @CheckResult
    String getStringValue(@StringRes int id);
    @LayoutRes
    int getLayoutRes();
}
