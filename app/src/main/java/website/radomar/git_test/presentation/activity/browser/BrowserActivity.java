package website.radomar.git_test.presentation.activity.browser;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialog;
import android.webkit.WebView;

import website.radomar.git_test.R;

public class BrowserActivity extends Dialog {

    public static final String URL = "url";

    private WebView webView;

    public BrowserActivity(@NonNull Context context) {
        super(context);
    }



//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_brower);
//
//        String url = getIntent().getStringExtra(URL);
//
//        webView = (WebView) findViewById(R.id.wvBrowser_AB);
//        webView.getSettings().setJavaScriptEnabled(true);
//        webView.loadUrl(url);
//    }
}
