package website.radomar.git_test.presentation.activity.details;

import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import website.radomar.git_test.data.model.Repository;
import website.radomar.git_test.utils.ImageUtils;

/**
 * Created by Radomar on 20.06.2017.
 */

public class DetailsPresenter extends DetailsContract.Presenter<DetailsContract.View> {

    private Repository repository;
    private ImageUtils imageUtils;

    @Inject
    public DetailsPresenter(ImageUtils imageUtils) {
        this.imageUtils = imageUtils;
    }

    @Override
    public void onViewCreated(@Nullable Bundle savedInstanceState) {
        super.onViewCreated(savedInstanceState);
        view.setRepository(repository);
    }

    @Override
    void setRepository(Repository repository) {
        this.repository = repository;
    }

    @Override
    ImageUtils getImageUtils() {
        return imageUtils;
    }
}
