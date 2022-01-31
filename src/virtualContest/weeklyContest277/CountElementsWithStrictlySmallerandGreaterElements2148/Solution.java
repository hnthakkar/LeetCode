package virtualContest.weeklyContest277.CountElementsWithStrictlySmallerandGreaterElements2148;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.countElements(new int[]{11, 7, 2, 15});
    }

    public int countElements(int[] nums) {
        int len = nums.length;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        Map<Integer, Integer> freq = new HashMap<>();

        for (int n : nums) {
            max = Math.max(max, n);
            min = Math.min(min, n);

            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        return len - freq.get(max) - freq.get(min);
    }
}
