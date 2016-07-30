package foxesden.webviewcontroller.android;

import android.webkit.WebResourceResponse;
import android.webkit.WebView;

import foxesden.webviewcontroller.Interceptor;
import foxesden.webviewcontroller.rest.Request;
import foxesden.webviewcontroller.rest.Response;

/**
 * Created by henrique-vianna on 28/07/2016.
 */
public class WebViewClientUnderAPI21 extends WebViewClientAdapter {

    public WebViewClientUnderAPI21(Interceptor interceptor) {
        super(interceptor);
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        return false;
    }

    @Override
    public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
        Request request = new Request(url);
        Response response = interceptor.process(request);

        return null;
    }
}

