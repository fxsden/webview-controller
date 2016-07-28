package foxesden.webviewcontroller.rest;

import java.net.URI;

import foxesden.collection.FieldManager;

public class Request {
    private URI uri;
    private FieldManager fields;

    public URI getUri() {
        return uri;
    }

    public Request setUri(URI uri) {
        this.uri = uri;
        return this;
    }

    public FieldManager getFields() {
        return fields;
    }

    public Request setFields(FieldManager fields) {
        this.fields = fields;
        return this;
    }
}
