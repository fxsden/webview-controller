package foxesden.webviewcontroller.rest;

import java.io.InputStream;

import foxesden.collection.MapBuilder;

public class Response {

    private int statusCode;
    private String reasonPhrase;
    private MapBuilder headers = new MapBuilder();
    private InputStream data;

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
        return this;
    }

    public MapBuilder getHeaders() {
        return headers;
    }
}
