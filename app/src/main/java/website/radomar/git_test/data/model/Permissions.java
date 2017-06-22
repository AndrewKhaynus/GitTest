package website.radomar.git_test.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Radomar on 20.06.2017.
 */

public class Permissions implements Model {

    @SerializedName("admin")
    public boolean admin;
    @SerializedName("push")
    public boolean push;
    @SerializedName("pull")
    public boolean pull;
}
