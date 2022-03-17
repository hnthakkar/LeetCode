package virtualContest.weeklyContest280.two;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.minimumOperations(new int[]{35, 67, 46, 81, 34, 66, 52, 70, 19, 71, 23, 34, 2, 30, 98, 55, 69, 40, 3, 95, 12, 64, 56, 32, 45, 71, 82, 72, 53, 90, 43, 30, 71, 42, 26, 10, 93, 24, 30, 42, 70, 15, 69, 13, 53, 85, 12, 17, 21, 41, 5, 26, 32, 53, 95, 28, 97, 87, 87, 50, 15, 32, 72, 29, 29, 80, 41, 96, 47, 39, 31, 82, 61, 42, 12, 5, 9, 53, 92, 57, 11, 82, 82, 4, 66, 99, 15, 81, 72, 99, 47});
    }

    public int minimumOperations(int[] nums) {
        int len = nums.length;

        int oddMax = nums[1];
        int oddSecMax = nums[1];
        int evenMax = nums[0];
        int evenSecMax = nums[0];

        Map<Integer, Integer> odd = new HashMap<>();
        Map<Integer, Integer> even = new HashMap<>();

        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                int curFreq = even.getOrDefault(nums[i], 0) + 1;
                even.put(nums[i], curFreq);

                if (curFreq > even.get(evenSecMax)) {
                    if (curFreq > even.get(evenMax)) {
                        int tmp = evenMax;
                        evenMax = nums[i];
                        evenSecMax = tmp;
                    } else {
                        evenSecMax = nums[i];
                    }
                }
            } else {
                int curFreq = odd.getOrDefault(nums[i], 0) + 1;
                odd.put(nums[i], curFreq);

                if (curFreq > odd.get(oddSecMax)) {
                    if (curFreq > odd.get(oddMax)) {
                        int tmp = oddMax;
                        oddMax = nums[i];
                        oddSecMax = tmp;
                    } else {
                        oddSecMax = nums[i];
                    }
                }
            }
        }

        if (oddMax == evenSecMax && evenMax == oddSecMax) {
            return len/2;
        }

        int result = Integer.MAX_VALUE;

        if (oddMax != evenSecMax) {
            result = Math.min(result, counter(nums, oddMax, evenSecMax));
        }

        if (evenMax != oddSecMax) {
            result = Math.min(result, counter(nums, oddSecMax, evenMax));
        }

        return result;

    }

    private int counter(int[] nums, int oddVal, int evenVal) {
        int counter = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                if (nums[i] != evenVal) {
                    counter++;
                }
            } else {
                if (nums[i] != oddVal) {
                    counter++;
                }
            }
        }

        return counter;
    }
}
