package array.hasduplicate;

import java.util.HashMap;
import java.util.Map;

public class DuplicateElement {

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num: nums) {
            if (freq.containsKey(num)) {
                return true;
            }
            freq.put(num, 1);
        }
        return false;
    }
}
