package website.radomar.git_test.presentation.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by Radomar on 20.06.2017.
 */

public interface BasePresenter<V extends BaseView> {

    void onViewCreated(@Nullable Bundle savedInstanceState);
    void onDestroyView();
    void bindView(V view);
}
