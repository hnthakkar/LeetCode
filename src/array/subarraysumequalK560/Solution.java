package array.subarraysumequalK560;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.subarraySum(new int[]{1, 1, 1}, 2);
        sol.subarraySum(new int[]{1, 2, 3}, 3);

        sol.subarraySum(new int[]{1, -1, 0}, 0);
    }

    public int subarraySum(int[] nums, int k) {
        int len = nums.length;

        int result = 0;

        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);

        int sum = 0;

        for (int i = 0; i < len; i++) {
            sum += nums[i];

            if (preSum.containsKey(sum - k)) {
                result += preSum.get(sum - k);
            }

            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }

        return result;
    }

    /*
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

     */

}
