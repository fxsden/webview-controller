package foxesden.markup;

import java.util.ArrayList;
import java.util.List;

public class TagComposite extends AbstractTag {

    public List<AbstractTag> children = new ArrayList<>();

    public TagComposite(String name) {
        super(name);
    }

    public TagComposite addChild(AbstractTag tag) {
        children.add(tag);
        return this;
    }

    @Override
    public String getValue() {
        StringBuffer buffer = new StringBuffer();
        for(AbstractTag tag:children) {
            buffer.append(tag.toString());
        }
        return buffer.toString();
    }
}
