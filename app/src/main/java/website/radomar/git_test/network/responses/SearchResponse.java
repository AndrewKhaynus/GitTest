package website.radomar.git_test.network.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import website.radomar.git_test.data.model.RRepository;
import website.radomar.git_test.data.model.Repository;

/**
 * Created by Radomar on 20.06.2017.
 */

public class SearchResponse {

    @SerializedName("total_count")
    public int totalCount;
    @SerializedName("incomplete_results")
    public boolean incompleteResults;
    @SerializedName("items")
    public List<Repository> items;
}
