package website.radomar.git_test.presentation.activity.repositories;

import website.radomar.git_test.presentation.base.BaseActivityContract;
import website.radomar.git_test.presentation.base.BaseRecyclerAdapter;

/**
 * Created by Radomar on 20.06.2017.
 */

public interface RepositoriesContract {

    interface View<P extends Presenter> extends BaseActivityContract.View<P> {
        void changeProgressState(boolean isVisible);
        void setRecyclerAdapter(BaseRecyclerAdapter adapter);
        void getBack();
        void openUrl(String url);
    }

    abstract class Presenter<V extends View> extends BaseActivityContract.Presenter<V> {
        abstract void setSearch(String query);
        abstract void clickSearch(String text);
        abstract void clickBack();
        abstract void clickItem(int position);
        abstract void clickHistory();
    }
}
