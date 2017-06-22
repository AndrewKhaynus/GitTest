package website.radomar.git_test.network.requests;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Radomar on 20.06.2017.
 */

public final class LoginRequest {

    @SerializedName("app_key")
    public String appKey;
    @SerializedName("app_secret")
    public String appSecret;
    @SerializedName("note")
    public String note;
    @SerializedName("fingerprint")
    public String fingerprint;
    @SerializedName("scopes")
    public List<String> scopes;

}
