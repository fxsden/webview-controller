package foxesden.markup;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractTag {

    protected String name;
    protected boolean closeable;
    protected Map<String, String> attributes = new HashMap<>();

    public AbstractTag(String name, boolean closeable) {
        this.name = name;
        this.closeable = closeable;
    }

    public AbstractTag(String name) {
        this(name, true);
    }

    public abstract String getValue();

    public AbstractTag addAttribute(String name, String value) {
        attributes.put(name, value);
        return this;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        for (Map.Entry<String, String> attribute:attributes.entrySet()) {
            buffer.append(attribute.getKey() + "=\"" + attribute.getValue() + "\"");
        }
        String stringBuffer = buffer.toString();
        return "<" + name + (stringBuffer.equals("") ? "" : " " + stringBuffer) + ">" + (closeable ? getValue() + "</" + name + ">":"");
    }

}
