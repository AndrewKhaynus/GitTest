package website.radomar.git_test.data;

import android.os.Handler;
import android.os.Looper;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import website.radomar.git_test.data.model.RRepository;

/**
 * Created by Andrew on 16.05.2017.
 */

public class RealmDataProvider implements DataProvider {

    private static final String BASENAME = "com.radomar.gittest.data.RealmDataProvider";

    private Realm mInstance;
    private final Handler mHandler;

    public RealmDataProvider() {
        super();

        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        mHandler = new Handler();
        mHandler.getLooper();
    }

    @Override
    public void open() {
        mInstance = Realm.getInstance(
                new RealmConfiguration.Builder()
                        .name(BASENAME)
                        .deleteRealmIfMigrationNeeded()
                        .build());
    }

    @Override
    public void close() {
        if (mInstance != null && !mInstance.isClosed()) {
            mInstance.close();
        }
    }

    @Override
    public void clear() {
        if (mInstance != null && !mInstance.isClosed()) {
            mInstance.deleteAll();
        }
    }

    @Override
    public void saveRepositories(List<RRepository> repositories) {
        mInstance.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                for (RRepository rRepository: repositories) {
                    mInstance.insertOrUpdate(rRepository);
                }
            }
        });
    }

    @Override
    public List<RRepository> getLastRepositories() {

        RealmResults<RRepository> realmResults = mInstance
                .where(RRepository.class)
                .findAll();

        return realmResults;
    }
}
