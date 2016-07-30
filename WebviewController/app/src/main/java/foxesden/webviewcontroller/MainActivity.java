package foxesden.webviewcontroller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.ByteArrayInputStream;

import foxesden.markup.Tag;
import foxesden.markup.TagComposite;
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
                TagComposite html = new TagComposite("html");
                html.addChild((new TagComposite("head")).addChild((new Tag("title")).setValue("Test")))
                    .addChild((new TagComposite("body")).addChild(new Tag("h1").setValue("TEST OK")));
                Response response = new Response();
                response.setStatusCode(200)
                        .setReasonPhrase("OK")
                        .setData(new ByteArrayInputStream(html.getValue().getBytes()))
                        .getHeaders().add("Content-type","text/html");
                return response;
            }
        });
        webview.setWebViewClient(WebViewClientFactory.create(interceptor));

    }
}
