package DP.MinimumOperationstoReduceXtoZero1658;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {

    public static void main(String[] args) {
        Solution1 sol = new Solution1();
        sol.minOperations(new int[]{1, 1, 4, 2, 3}, 5);
    }

    public int minOperations(int[] nums, int k) {
        int len = nums.length;

        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, -1);
        preSum.put(nums[0], 0);

        for (int i = 1; i < len; i++) {
            nums[i] += nums[i - 1];
            preSum.put(nums[i], i);
        }

        int ref = nums[nums.length - 1] - k;
        int result = 0;
        int sum = 0;

        for (int i = 0; i < len; i++) {
            if (preSum.containsKey(nums[i] - ref)) {
                result = Math.max(result, i - (preSum.get(nums[i] - ref) + 1) + 1);
            }
        }

        return len - result;
    }

}
