package foxesden.collection;

import java.util.Map;

public class FieldManager {
    private Object value;

    public FieldManager(Object value) {
        this.value = value;
    }

    public FieldManager getField(String field) {
        return new FieldManager(((Map) value).get(field));
    }

    public String asString() {
        return (String) value;
    }

    public int asInt() {
        return Integer.valueOf(this.asString());
    }

    public long asLong() {
        return Long.valueOf(this.asString());
    }

    public double asDouble() {
        return Double.valueOf(this.asString());
    }

    public boolean asBoolean() {
        return Boolean.valueOf(this.asString());
    }

}
