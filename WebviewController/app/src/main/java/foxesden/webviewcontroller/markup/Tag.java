package foxesden.webviewcontroller.markup;

public class Tag extends AbstractTag {

    private String value = "";

    public Tag(String name) {
        super(name);
    }

    public Tag(String name, boolean closeable) {
        super(name, closeable);
    }

    public Tag setValue(String value) {
        this.value = value;
        return this;
    }

    @Override
    public String getValue() {
        return value;
    }

}
