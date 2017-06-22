package website.radomar.git_test.utils;

/**
 * Created by Radomar on 20.06.2017.
 */

public class ValidationUtils {

    public boolean isValidLogin(String login) {
        return login.length() >=3;
    }

    public boolean isValidPassword(String password) {
        return password.length() >= 3;
    }
}
