package foxesden.webviewcontroller.android;

import android.os.Build;

import foxesden.webviewcontroller.Interceptor;


public class WebViewClientFactory {

    public static WebViewClientAdapter create(Interceptor interceptor) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            return new WebViewClientUnderAPI21(interceptor);
        } else {
            return new WebViewClientSinceAPI21(interceptor);
        }
    }
}
