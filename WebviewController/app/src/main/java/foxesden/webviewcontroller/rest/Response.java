package foxesden.webviewcontroller.rest;

import android.util.Base64;
import android.util.Base64OutputStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import foxesden.collection.MapBuilder;

public class Response {

    private int statusCode;
    private String reasonPhrase;
    private MapBuilder headers = new MapBuilder();
    private InputStream data;
    private String b64Cache;

    public int getStatusCode() {
        return statusCode;
    }

    public Response setStatusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }

    public Response setReasonPhrase(String reasonPhrase) {
        this.reasonPhrase = reasonPhrase;
        return this;
    }

    public InputStream getData() {
        return data;
    }

    public Response setData(InputStream data) {
        this.data = data;
        b64Cache = null;
        return this;
    }

    public MapBuilder getHeaders() {
        return headers;
    }

    public String getDataAsBase64() throws IOException {
        if (b64Cache == null) {
            byte[] buffer = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Base64OutputStream base64OutputStream = new Base64OutputStream(byteArrayOutputStream, Base64.DEFAULT);
            int b;
            while(data.read(buffer) > -1) {
                base64OutputStream.write(buffer);
            }
            b64Cache = new String(byteArrayOutputStream.toByteArray());
        }
        return b64Cache;
    }
}
