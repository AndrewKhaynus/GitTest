package website.radomar.git_test.presentation.activity.repositories.supports;

import android.support.annotation.NonNull;

import com.hannesdorfmann.adapterdelegates3.AdapterDelegatesManager;

import website.radomar.git_test.data.model.Repository;
import website.radomar.git_test.presentation.base.BaseRecyclerAdapter;
import website.radomar.git_test.utils.ImageUtils;

/**
 * Created by Radomar on 20.06.2017.
 */

public class RepoRecyclerAdapter extends BaseRecyclerAdapter<Repository> {

    private ImageUtils imageUtils;

    public RepoRecyclerAdapter(ImageUtils imageUtils) {
        super(false);
        this.imageUtils = imageUtils;
        fillDelegatesManger(true);
    }

    @Override
    protected void initDelegatesManager(@NonNull AdapterDelegatesManager<Repository> delegatesManager) {
        delegatesManager.addDelegate(new RepoAdapterDelegate(imageUtils));
    }
}
