package foxesden.webviewcontroller.android;

import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.InputStream;
import java.util.Map;

import foxesden.webviewcontroller.Interceptor;
import foxesden.webviewcontroller.rest.Request;
import foxesden.webviewcontroller.rest.Response;

public abstract class WebViewClientAdapter extends WebViewClient {

    protected Interceptor interceptor;

    public WebViewClientAdapter(Interceptor interceptor) {
        this.interceptor = interceptor;
    }

    protected String[] getMimeParts(Response response) {
        String[] mimeParts = {"application/octet-stream","utf-8"};
        if (response.getHeaders().getMap().containsKey("Content-type")) {
            String contentType = (String) response.getHeaders().getMap().get("Content-type");
            String[] parts = contentType.split(";");
            mimeParts[0] = parts[0];
            if (parts.length > 1) {
                return parts;
            }
        }
        return mimeParts;
    }

}
