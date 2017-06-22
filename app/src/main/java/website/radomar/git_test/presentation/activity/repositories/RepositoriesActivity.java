package website.radomar.git_test.presentation.activity.repositories;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import website.radomar.git_test.Constants;
import website.radomar.git_test.R;
import website.radomar.git_test.di.AppComponent;
import website.radomar.git_test.presentation.activity.browser.BrowserActivity;
import website.radomar.git_test.presentation.activity.repositories.di.DaggerRepositoriesComponent;
import website.radomar.git_test.presentation.activity.repositories.supports.ItemTouchListener;
import website.radomar.git_test.presentation.base.BaseActivity;
import website.radomar.git_test.presentation.base.BaseRecyclerAdapter;

/**
 * Created by Radomar on 20.06.2017.
 */

public final class RepositoriesActivity extends BaseActivity<RepositoriesContract.Presenter>
        implements RepositoriesContract.View<RepositoriesContract.Presenter> {

    private ImageButton btnBack;
    private ImageButton btnSearch;
    private ImageButton btnHistory;
    private EditText etSearch;

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private String query;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_repositories;
    }

    @Override
    public void setupComponent(AppComponent appComponent) {
        DaggerRepositoriesComponent.builder()
                .appComponent(appComponent)
                .build().inject(this);
    }

    @Override
    public void findUI() {
        btnBack         = (ImageButton) findViewById(R.id.btnBack_RS);
        btnBack         .setVisibility(View.VISIBLE);
        btnSearch       = (ImageButton) findViewById(R.id.btnSearch_RS);
        btnHistory       = (ImageButton) findViewById(R.id.btnHistory_RS);
        etSearch        = (EditText) findViewById(R.id.etSearch_RS);
        recyclerView    = (RecyclerView) findViewById(R.id.recyclerView_RA);
        progressBar     = (ProgressBar) findViewById(R.id.progressBar);
    }

    @Override
    public void setupUI() {
        etSearch.setText(query);
        btnHistory.setVisibility(View.VISIBLE);
        btnSearch.setVisibility(View.VISIBLE);
        btnBack.setOnClickListener(view -> presenter.clickBack());
        btnSearch.setOnClickListener(view -> presenter.clickSearch(etSearch.getText().toString()));
        btnHistory.setOnClickListener(v -> presenter.clickHistory());
        recyclerView.addOnItemTouchListener(new ItemTouchListener(this, (view, position) ->
                presenter.clickItem(position)
        ));
    }

    @Override
    public void changeProgressState(boolean isVisible) {
        progressBar.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }

    @Override
    public void setRecyclerAdapter(BaseRecyclerAdapter adapter) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void readBundle(Bundle bundle) {
        query = bundle.getString(Constants.Activity.SEARCH_KEY);
        presenter.setSearch(query);
    }

    @Override
    public void getBack() {
        onBackPressed();
    }

    @Override
    public void openUrl(String url) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Github");

        WebView wv = new WebView(this);
        wv.loadUrl(url);
        wv.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);

                return true;
            }
        });

        alert.setView(wv);
        alert.show();
    }
}
