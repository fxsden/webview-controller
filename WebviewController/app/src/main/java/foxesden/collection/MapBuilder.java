package foxesden.collection;

import java.util.HashMap;
import java.util.Map;

public class MapBuilder {

    private Map<String, Object> map = new HashMap<>();

    public MapBuilder add(String key, Object value) {
        map.put(key, value);
        return this;
    }

    public Map getMap() {
        return map;
    }

}
