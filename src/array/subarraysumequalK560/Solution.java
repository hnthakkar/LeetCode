package array.subarraysumequalK560;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int subarraySum(int[] nums, int k) {
        int len = nums.length;

        Map<Integer, Integer> preSumMap = new HashMap<>();
        preSumMap.put(nums[0], 1);

        int counter = 0;

        if (nums[0] == k) {
            counter++;
        }

        for (int i = 1; i < len; i++) {
            nums[i] += nums[i - 1];

            if (nums[i] == k) {
                counter++;
            }

            if (preSumMap.containsKey(nums[i] - k)) {
                counter += preSumMap.get(nums[i] - k);
            }

            if (preSumMap.containsKey(nums[i])) {
                preSumMap.put(nums[i], preSumMap.get(nums[i]) + 1);
            } else {
                preSumMap.put(nums[i], 1);
            }

        }

        return counter;
    }

}
