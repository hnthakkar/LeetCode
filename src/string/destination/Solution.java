package string.destination;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public String destCity(List<List<String>> paths) {
        Set<String> startFromSet = new HashSet<>();
        Set<String> endToSet = new HashSet<>();

        for (List<String> path: paths) {
            startFromSet.add(path.get(0));
            endToSet.add(path.get(1));
        }

        for (String endTo: endToSet) {
            if(!startFromSet.contains(endTo)) {
                return endTo;
            }
        }

        return null;
    }

}
