package array.ContiguousArray525;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int findMaxLength(int[] nums) {
        int len = nums.length;

        Map<Integer, Integer> m = new HashMap<>();

        m.put(0, -1);

        int preSum = 0;
        int result = 0;

        for (int i = 0; i < len; i++) {
            preSum += nums[i] == 0 ? -1: 1;

            if (m.containsKey(preSum)) {
                int indexDiff = i - m.get(preSum);
                result = Math.max(result, indexDiff);
            } else {
                m.put(preSum, i);
            }
        }

        return result;
    }

}
