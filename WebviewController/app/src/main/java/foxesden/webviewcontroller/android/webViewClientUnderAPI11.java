package foxesden.webviewcontroller.android;

import android.webkit.WebView;

import java.io.IOException;

import foxesden.webviewcontroller.Interceptor;
import foxesden.webviewcontroller.rest.Request;
import foxesden.webviewcontroller.rest.Response;

public class webViewClientUnderAPI11 extends WebViewClientAdapter {

    public webViewClientUnderAPI11(Interceptor interceptor) {
        super(interceptor);
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (interceptor.isInterceptionAllowed(new Request(url))) {
            Response response = interceptor.process(new Request(url));
            String[] mimeParts = getMimeParts(response);
            try {
                view.loadData(response.getDataAsBase64(), mimeParts[0], "base64");
                return true;
            } catch(IOException ex) {

            }
        }
        return false;
    }

}

