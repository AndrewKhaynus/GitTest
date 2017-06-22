package website.radomar.git_test.presentation.activity.repositories.supports;

import android.support.annotation.NonNull;
import android.view.View;

import website.radomar.git_test.R;
import website.radomar.git_test.data.model.Repository;
import website.radomar.git_test.presentation.base.BaseAdapterDelegate;
import website.radomar.git_test.utils.ImageUtils;

/**
 * Created by Radomar on 20.06.2017.
 */

public class RepoAdapterDelegate extends BaseAdapterDelegate<Repository, RepoViewHolder> {

    private ImageUtils imageUtils;

    public RepoAdapterDelegate(ImageUtils imageUtils) {
        this.imageUtils = imageUtils;
    }

    @Override
    protected int getHolderLayoutRes() {
        return R.layout.holder_repo;
    }

    @Override
    protected RepoViewHolder getHolder(@NonNull View inflatedView) {
        return new RepoViewHolder(inflatedView, imageUtils);
    }
}