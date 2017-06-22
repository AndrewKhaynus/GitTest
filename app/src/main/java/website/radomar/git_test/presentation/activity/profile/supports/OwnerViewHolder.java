package website.radomar.git_test.presentation.activity.profile.supports;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import website.radomar.git_test.R;
import website.radomar.git_test.data.model.UserRepository;
import website.radomar.git_test.presentation.base.BaseViewHolder;

/**
 * Created by Radomar on 20.06.2017.
 */

public class OwnerViewHolder extends BaseViewHolder<UserRepository> {

    private TextView tvName;
    private TextView tvDescription;
    private TextView tvNumFork;
    private TextView tvLanguage;

    public OwnerViewHolder(View itemView) {
        super(itemView);
        findUi();
    }

    @Override
    protected void findUi() {
        tvName          = (TextView) itemView.findViewById(R.id.tvName_ORH);
        tvDescription   = (TextView) itemView.findViewById(R.id.tvDescription_ORH);
        tvNumFork       = (TextView) itemView.findViewById(R.id.tvNumberFork_ORH);
        tvLanguage      = (TextView) itemView.findViewById(R.id.tvLanguage_ORH);
    }

    @Override
    protected void contentUpdate(UserRepository dataItem) {
        tvName.setText(dataItem.name);
        tvDescription.setText((!TextUtils.isEmpty(dataItem.description))
                ? dataItem.description
                : itemView.getContext().getString(R.string.description_is_missing));
        tvLanguage.setText((!TextUtils.isEmpty(dataItem.language))
                ? dataItem.language
                : itemView.getContext().getString(R.string.no_language));
        tvNumFork.setText(itemView.getContext().getString(R.string.forks_count) + dataItem.forksCount);
    }
}
