package website.radomar.git_test.presentation.activity.profile;

import website.radomar.git_test.data.model.User;
import website.radomar.git_test.presentation.base.BaseActivityContract;
import website.radomar.git_test.presentation.base.BaseRecyclerAdapter;
import website.radomar.git_test.utils.ImageUtils;

/**
 * Created by Radomar on 20.06.2017.
 */

public interface ProfileContract {

    interface View<P extends Presenter> extends BaseActivityContract.View<P> {
        void changeProgressState(boolean isVisible);
        void setProfile(User user);
        void setRecyclerAdapter(BaseRecyclerAdapter adapter);
    }

    abstract class Presenter<V extends View> extends BaseActivityContract.Presenter<V> {
        abstract void clickSearch(String text);
        abstract ImageUtils getImageUtils();
    }
}
