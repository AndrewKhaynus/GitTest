package website.radomar.git_test.presentation.activity.details.di;

import dagger.Module;
import dagger.Provides;
import website.radomar.git_test.di.ActivityScope;
import website.radomar.git_test.presentation.activity.details.DetailsContract;
import website.radomar.git_test.presentation.activity.details.DetailsPresenter;
import website.radomar.git_test.utils.ImageUtils;

/**
 * Created by Radomar on 20.06.2017.
 */

@Module
public class DetailsModule {

    @Provides @ActivityScope
    public DetailsContract.Presenter provideDetailsPresenter(ImageUtils imageUtils) {
        return new DetailsPresenter(imageUtils);
    }

    @Provides @ActivityScope
    public ImageUtils provideImageUtils() {
        return new ImageUtils();
    }
}
