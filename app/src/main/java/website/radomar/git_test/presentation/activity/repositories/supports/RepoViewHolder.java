package website.radomar.git_test.presentation.activity.repositories.supports;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import website.radomar.git_test.R;
import website.radomar.git_test.data.model.Repository;
import website.radomar.git_test.presentation.base.BaseViewHolder;
import website.radomar.git_test.utils.ImageUtils;

/**
 * Created by Radomar on 20.06.2017.
 */

public class RepoViewHolder extends BaseViewHolder<Repository> {

    private ImageView ivAvatar;
    private TextView tvName;
    private TextView tvDescription;
    private TextView tvNumFork;
    private TextView tvLanguage;

    private ImageUtils imageUtils;

    public RepoViewHolder(View itemView, ImageUtils imageUtils) {
        super(itemView);
        this.imageUtils = imageUtils;
        findUi();
    }

    @Override
    protected void findUi() {
        ivAvatar        = (ImageView) itemView.findViewById(R.id.ivAvatar_RH);
        tvName          = (TextView) itemView.findViewById(R.id.tvName_RH);
        tvDescription   = (TextView) itemView.findViewById(R.id.tvDescription_RH);
        tvNumFork       = (TextView) itemView.findViewById(R.id.tvNumberFork_RH);
        tvLanguage      = (TextView) itemView.findViewById(R.id.tvLanguage_RH);
    }

    @Override
    protected void contentUpdate(Repository dataItem) {
        if (dataItem.owner != null) {
            imageUtils.setCircleImageWithBorder(ivAvatar, dataItem.owner.avatarUrl);
        }
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
