package website.radomar.git_test.presentation.activity.repositories;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import retrofit2.Response;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import website.radomar.git_test.Constants;
import website.radomar.git_test.data.DataProvider;
import website.radomar.git_test.data.model.RRepository;
import website.radomar.git_test.data.model.Repository;
import website.radomar.git_test.domain.interactors.RepositoriesInteractor;
import website.radomar.git_test.network.responses.SearchResponse;
import website.radomar.git_test.presentation.activity.details.DetailsActivity;
import website.radomar.git_test.presentation.activity.repositories.supports.RepoRecyclerAdapter;
import website.radomar.git_test.presentation.base.BaseRecyclerAdapter;
import website.radomar.git_test.utils.ErrorHandler;
import website.radomar.git_test.utils.ImageUtils;

/**
 * Created by Radomar on 20.06.2017.
 */

public final class RepositoriesPresenter extends RepositoriesContract.Presenter<RepositoriesContract.View> {

    private String query;

    private RepositoriesInteractor repositoriesInteractor;
    private ErrorHandler errorHandler;
    private ImageUtils imageUtils;
    private BaseRecyclerAdapter<Repository> recyclerAdapter;
    private DataProvider dataProvider;

    @Inject
    public RepositoriesPresenter(RepositoriesInteractor repositoriesInteractor,
                                 ErrorHandler errorHandler,
                                 ImageUtils imageUtils,
                                 DataProvider dataProvider) {
        this.repositoriesInteractor = repositoriesInteractor;
        this.errorHandler = errorHandler;
        this.imageUtils = imageUtils;
        this.dataProvider = dataProvider;
    }

    @Override
    public void onViewCreated(@Nullable Bundle savedInstanceState) {
        super.onViewCreated(savedInstanceState);
        initDataStorage();
        recyclerAdapter = new RepoRecyclerAdapter(imageUtils);
        view.setRecyclerAdapter(recyclerAdapter);
        sendSearchRequest(query);
    }

    private void sendSearchRequest(String text) {
        view.changeProgressState(true);
        recyclerAdapter.clear();
        compositeSubscription.clear();
        addSubscription(repositoriesInteractor.getSearchRepo(text, "stars", 1, 15)
                .timeout(Constants.Api.TIMEOUT, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::successSearchFirst, this::error));

        addSubscription(repositoriesInteractor.getSearchRepo(text, "stars", 2, 15)
                .timeout(Constants.Api.TIMEOUT, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::successSearchSecond, this::error));

    }

    private void successSearchFirst(Response<SearchResponse> response) {
        view.changeProgressState(false);
        List<Repository> repositories = response.body().items;
        recyclerAdapter.addToStart(repositories);

        saveToDB(repositories);
    }

    private void successSearchSecond(Response<SearchResponse> response) {
        view.changeProgressState(false);
        List<Repository> repositories = response.body().items;
        recyclerAdapter.addToEnd(repositories);

        saveToDB(repositories);
    }

    private void saveToDB(List<Repository> repositories) {
        if (repositories.size() > 0) {
            List<RRepository> rRepositoryList = new ArrayList<>();
            for (Repository repository: repositories) {
                rRepositoryList.add(repository.getRRepository());
            }
            dataProvider.saveRepositories(rRepositoryList);
        }
    }

    private void error(Throwable throwable) {
        view.changeProgressState(false);
        errorHandler.onError(view, throwable);
    }

    @Override
    void clickSearch(String text) {
        if (!TextUtils.isEmpty(text)) {
            sendSearchRequest(text);
        }
    }

    @Override
    void clickBack() {
        view.getBack();
    }

    @Override
    void clickItem(int position) {
        view.openUrl(recyclerAdapter.getItem(position).cloneUrl);
    }

    @Override
    void clickHistory() {
        compositeSubscription.clear();
        List<RRepository> repositoriesFromDB = dataProvider.getLastRepositories();
        if (repositoriesFromDB.size() > 0) {
            List<Repository> repositories = new ArrayList<>();
            for (RRepository rRepository : repositoriesFromDB) {
                repositories.add(rRepository.getRepository());
            }
            recyclerAdapter.addAll(repositories);
        }
    }

    @Override
    void setSearch(String query) {
        this.query = query;
    }

    private void initDataStorage() {
        dataProvider.open();
    }

    private void deinitDataStorage() {
        if (dataProvider != null) {
            dataProvider.close();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        deinitDataStorage();
    }

    private Bundle prepareRepoBundle(Repository repository) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constants.Activity.REPO_KEY, repository);
        return bundle;
    }
}
