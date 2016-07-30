package foxesden.webviewcontroller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import foxesden.webviewcontroller.android.WebViewClientFactory;
import foxesden.webviewcontroller.rest.Request;
import foxesden.webviewcontroller.rest.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView webview = (WebView) findViewById(R.id.webView);
        webview.loadUrl("file:///android_asset/test-page.html");

        Interceptor interceptor = new Interceptor();
        interceptor.addHandler("/test", new RequestProcessor() {
            @Override
            public Response process(Request request) {
                return null;
            }
        });
        webview.setWebViewClient(WebViewClientFactory.create(interceptor));

    }
}
