package array.threesumInterviewBit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();

        // input.add(-10);
        // input.add(-10);
        // input.add(-10);
        /*
        input.add(2147483647);
        input.add(-2147483648);
        input.add(-2147483648);
        input.add(0);
        input.add(1);
        */
        int[] inputs = new int[] { 2, 1, -9, -7, -8, 2, -8, 2, 3, -8 };

        ArrayList<Integer> input = new ArrayList<>();
        for (int n: inputs) {
            input.add(n);
        }

        // 2147483647, -2147483648, -2147483648, 0, 1
        sol.threeSumClosest(input, -1);
    }

    public int threeSumClosest(ArrayList<Integer> A, int target) {
        Collections.sort(A);
        int len = A.size();

        int closest = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int curStart = A.get(i);

            int left = i + 1;
            int right = len - 1;

            while (left < right) {
                long sum = curStart + A.get(left) + A.get(right);

                if (sum == target) {
                    return target;
                }

                long diff = target - sum;

                if (Math.abs(diff) < Math.abs((long)target - closest)) {
                    closest = (int) sum;
                }

                if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return closest;
    }

}
