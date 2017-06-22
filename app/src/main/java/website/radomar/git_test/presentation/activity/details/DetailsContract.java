package website.radomar.git_test.presentation.activity.details;

import website.radomar.git_test.data.model.Repository;
import website.radomar.git_test.presentation.base.BaseActivityContract;
import website.radomar.git_test.utils.ImageUtils;

/**
 * Created by Radomar on 20.06.2017.
 */

public interface DetailsContract {

    interface View<P extends Presenter> extends BaseActivityContract.View<P> {
        void setRepository(Repository repository);
    }

    abstract class Presenter<V extends View> extends BaseActivityContract.Presenter<V> {
        abstract void setRepository(Repository repository);
        abstract ImageUtils getImageUtils();
    }
}
