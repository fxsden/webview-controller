package foxesden.webviewcontroller.android;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;

import foxesden.webviewcontroller.Interceptor;

public class WebViewClientSinceAPI21 extends WebViewClientAdapter {

    public WebViewClientSinceAPI21(Interceptor interceptor) {
        super(interceptor);
    }

    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
        return null;
    }
}
