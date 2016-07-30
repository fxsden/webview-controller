package foxesden.webviewcontroller.rest;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import foxesden.collection.FieldManager;

public class Request {
    private URI uri;
    private FieldManager fields;

    private void parseFields() {
        String[] fields = this.uri.getQuery().split("&");
        Map fieldMap =  new HashMap();
        for(String field : fields) {
            String[] parts = field.split("=");
            String[] keys = parts[0].replace("]","").split("\\[");
            String value = parts[1];
            int len = keys.length;
            if (len > 1) {
                Map map = fieldMap;
                for(int i=0; i < len - 1; i++) {
                    Map itemMap = (Map) map.get(keys[i]);
                    if (itemMap == null) {
                        itemMap = new HashMap();
                        map.put(keys[i], itemMap);
                    }
                    map = itemMap;
                }
                map.put(keys[len - 1], value);
            } else {
                fieldMap.put(keys[0], value);
            }
        }
        this.fields = new FieldManager(fieldMap);
    }

    public Request(String uri) {
        this.uri = URI.create(uri);
        parseFields();
    }

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
