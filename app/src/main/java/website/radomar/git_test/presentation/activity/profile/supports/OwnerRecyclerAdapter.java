package website.radomar.git_test.presentation.activity.profile.supports;

import android.support.annotation.NonNull;

import com.hannesdorfmann.adapterdelegates3.AdapterDelegatesManager;

import website.radomar.git_test.data.model.UserRepository;
import website.radomar.git_test.presentation.base.BaseRecyclerAdapter;

/**
 * Created by Radomar on 20.06.2017.
 */

public class OwnerRecyclerAdapter extends BaseRecyclerAdapter<UserRepository> {

    @Override
    protected void initDelegatesManager(@NonNull AdapterDelegatesManager<UserRepository> delegatesManager) {
        delegatesManager.addDelegate(new OwnerAdapterDelegate());
    }
}
