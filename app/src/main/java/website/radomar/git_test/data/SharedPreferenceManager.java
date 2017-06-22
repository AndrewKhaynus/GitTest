package website.radomar.git_test.data;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

import website.radomar.git_test.Constants;

/**
 * Created by Radomar on 20.06.2017.
 */

public final class SharedPreferenceManager implements PreferenceController {
    private SharedPreferences preferences;
    private static final String SHARED_PREF = "shared_pref";

    @Inject
    public SharedPreferenceManager(Context context) {
        preferences = context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE);
    }

    @Override
    public void saveToken(String token) {
        final SharedPreferences.Editor editor = preferences.edit();
        editor.putString(Constants.Preference.TOKEN, token);
        editor.apply();
    }

    @Override
    public String getToken() {
        return preferences.getString(Constants.Preference.TOKEN, "");
    }
}
