package goodpairs;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int numIdenticalPairs(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < len; i++) {
            if (freq.containsKey(nums[i])) {
                freq.put(nums[i], freq.get(nums[i]) + 1);
            } else {
                freq.put(nums[i], 1);
            }
        }

        int counter = 0;
        int tmp;
        for (Integer key: freq.keySet()) {
            tmp = freq.get(key);
            if (tmp > 1) {
                counter += tmp * (tmp - 1) / 2;
            }
        }

        return counter;
    }
}
