package website.radomar.git_test.data;


import java.util.List;

import website.radomar.git_test.data.model.RRepository;
import website.radomar.git_test.data.model.Repository;

/**
 * Created by Andrew on 16.05.2017.
 */

public interface DataProvider {

    void open();

    void close();

    void clear();

    void saveRepositories(List<RRepository> repositories);

    List<RRepository> getLastRepositories();
}
