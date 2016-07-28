package foxesden.webviewcontroller.android;

import android.webkit.WebViewClient;

import foxesden.webviewcontroller.Interceptor;

public class WebViewClientAdapter extends WebViewClient {

    protected Interceptor interceptor;
    
    public WebViewClientAdapter(Interceptor interceptor) {
        this.interceptor = interceptor;
    }

}
