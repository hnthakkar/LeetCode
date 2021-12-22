package array.maxProductSubArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        /*
        List<Integer> input = new ArrayList<>();
        input.add(-2);
        input.add(3);
        input.add(4);
        input.add(5);
        input.add(-1);


         */
        int[] inputs = new int[] {0, 9, -4, -7, 7, 8, 0, -8, -1, -9, 3, 5, 0, 8, -6, 0, 7, -4, 0, -4, -9, -5, -6, 2, 0, -1, 7, 3, 7, 2};

        //int[] inputs = new int[] {0, 0, -9, 6, 5, -3, 0, 4, 1, 2, 0, 0, 0, -6, -4, 0, -3, 1, 0, 7, 7, -3, 3, -7, 0, -1, -1, 8, -9, -2 };

        // int[] inputs = new int[] {7, 7, -3, 3, -7};
        List<Integer> input = new ArrayList<>();
        for (int n: inputs) {
            input.add(n);
        }
        sol.maxProduct(input);
    }

    public int maxProduct(final List<Integer> A) {
        int len = A.size();

        if (len == 0) {
            return 0;
        }

        if (len == 1) {
            return A.get(0);
        }

        int globalMax = 0;
        int localMax = Integer.MIN_VALUE;

        int positive = A.get(0) == 0 ? 1 : A.get(0);
        int negative = A.get(0) == 0 ? 1 : A.get(0);

        for (int i = 1; i < A.size(); i++) {
            if (A.get(i) == 0) {
                positive = 1;
                negative = 1;
                continue;
            }

            if (A.get(i-1) == 0 || A.get(i-1) * A.get(i) > 0) {
                positive = positive * A.get(i);
                negative = negative * A.get(i);
            } else {
                int tmp = positive;
                positive = Math.max(A.get(i), negative * A.get(i));
                negative *= A.get(i);
            }

            localMax = Math.max(positive, negative);
            globalMax = Math.max(globalMax, localMax);
        }

        return globalMax;
    }
}
