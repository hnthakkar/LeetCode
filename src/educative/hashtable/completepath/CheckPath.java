package educative.hashtable.completepath;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class CheckPath {

    public static String tracePath(Map<String,String> map) {

        StringBuilder result = new StringBuilder();
        String startLocation = null;
        Collection<String> values = map.values();
        for(String key: map.keySet()) {
            if (!values.contains(key)) {
                startLocation = key;
                break;
            }
        }

        while (startLocation != null && map.containsKey(startLocation)) {
            String destination = map.get(startLocation);
            result.append(startLocation + "->" + destination + ", ");
            startLocation = destination;
        }

        return result.toString();
    }
}
