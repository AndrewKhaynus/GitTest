package website.radomar.git_test.presentation.activity.profile.supports;

import android.support.annotation.NonNull;
import android.view.View;

import website.radomar.git_test.R;
import website.radomar.git_test.data.model.UserRepository;
import website.radomar.git_test.presentation.base.BaseAdapterDelegate;

/**
 * Created by Radomar on 20.06.2017.
 */

public class OwnerAdapterDelegate extends BaseAdapterDelegate<UserRepository, OwnerViewHolder> {

    @Override
    protected int getHolderLayoutRes() {
        return R.layout.holder_owner_repo;
    }

    @Override
    protected OwnerViewHolder getHolder(@NonNull View inflatedView) {
        return new OwnerViewHolder(inflatedView);
    }
}
