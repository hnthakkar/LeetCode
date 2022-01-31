package virtualContest.weeklyContest277.FindAllLonelyNumbersintheArray2150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public List<Integer> findLonely(int[] nums) {
        int len = nums.length;

        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < len; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry: freq.entrySet()) {
            if (entry.getValue() == 1) {
                if (!freq.containsKey(entry.getKey() - 1) && !freq.containsKey(entry.getKey() + 1)) {
                    result.add(entry.getKey());
                }
            }
        }

        return result;
    }

}
