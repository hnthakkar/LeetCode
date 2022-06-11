package DP.MinimumOperationstoReduceXtoZero1658;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int minOperations(int[] nums, int x) {
        int len = nums.length;
        Map<String, Integer> map = new HashMap<>();

        int result = helper(nums, 0, len - 1, x, 0, map);

        return result == Integer.MAX_VALUE? -1: result;
    }

    private int helper(int[] nums, int leftIndex, int rightIndex, int curSum, int counter, Map<String, Integer> map) {
        if (curSum == 0) {
            return counter;
        }

        if (curSum < 0 || leftIndex > rightIndex) {
            return Integer.MAX_VALUE;
        }

        String key = leftIndex + "*" + rightIndex + "*" + curSum;

        if (map.containsKey(key)) {
            return map.get(key);
        }

        int includeLeft = helper(nums, leftIndex + 1, rightIndex, curSum - nums[leftIndex], counter + 1, map);
        int includeRight = helper(nums, leftIndex, rightIndex - 1, curSum - nums[rightIndex], counter + 1, map);

        int min = Math.min(includeLeft, includeRight);
        map.put(key, min);

        return min;
    }
}
