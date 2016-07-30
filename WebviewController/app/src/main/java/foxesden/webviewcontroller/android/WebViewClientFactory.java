package foxesden.webviewcontroller.android;

import foxesden.webviewcontroller.Interceptor;


public class WebViewClientFactory {

    public static WebViewClientAdapter create(Interceptor interceptor) {
        //Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB
        return new WebViewClientUnderAPI11(interceptor);
    }
}
