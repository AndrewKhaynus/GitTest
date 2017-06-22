package website.radomar.git_test.presentation.activity.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import website.radomar.git_test.R;
import website.radomar.git_test.data.model.User;
import website.radomar.git_test.di.AppComponent;
import website.radomar.git_test.presentation.activity.profile.di.DaggerProfileComponent;
import website.radomar.git_test.presentation.base.BaseActivity;
import website.radomar.git_test.presentation.base.BaseRecyclerAdapter;

/**
 * Created by Radomar on 20.06.2017.
 */

public final class ProfileActivity extends BaseActivity<ProfileContract.Presenter>
        implements ProfileContract.View<ProfileContract.Presenter> {

    private ImageView ivAvatar;
    private TextView tvName;
    private TextView tvDescription;
    private TextView tvRepoCount;

    private ImageButton btnSearch;
    private ImageButton btnHistory;
    private EditText etSearch;

    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_profile;
    }

    @Override
    public void setupComponent(AppComponent appComponent) {
        DaggerProfileComponent.builder()
                .appComponent(appComponent)
                .build().inject(this);
    }

    @Override
    public void findUI() {
        ivAvatar        = (ImageView) findViewById(R.id.ivAvatarUser_FP);
        tvName          = (TextView) findViewById(R.id.tvName_FP);
        tvDescription   = (TextView) findViewById(R.id.tvDescription_FP);
        tvRepoCount     = (TextView) findViewById(R.id.tvRepoCount_FP);
        btnSearch       = (ImageButton) findViewById(R.id.btnSearch_RS);
        btnHistory       = (ImageButton) findViewById(R.id.btnHistory_RS);
        etSearch        = (EditText) findViewById(R.id.etSearch_RS);
        recyclerView    = (RecyclerView) findViewById(R.id.recyclerView_PA);
        progressBar     = (ProgressBar) findViewById(R.id.progressBar);
    }

    @Override
    public void setupUI() {
        btnSearch.setOnClickListener(view -> presenter.clickSearch(etSearch.getText().toString()));
        btnHistory.setVisibility(View.INVISIBLE);
    }

    @Override
    public void changeProgressState(boolean isVisible) {
        progressBar.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }

    @Override
    public void setProfile(User user) {
        presenter.getImageUtils().setCircleImageWithBorder(ivAvatar, user.avatarUrl);
        tvName.setText(user.login);
        tvDescription.setText(user.htmlUrl);
        tvRepoCount.setText("Repo count: " + user.publicRepos);
    }

    @Override
    public void setRecyclerAdapter(BaseRecyclerAdapter adapter) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
