package array.KdiffPairsinanArray532;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.findPairs(new int[]{1, 2, 4, 4, 3, 3, 0, 9, 2, 3}, 3);
    }

    /*
    [1,2,4,4,3,3,0,9,2,3]
    3
     */

    public int findPairs(int[] nums, int k) {
        Set<Integer> unique = new HashSet<>();
        Set<String> done = new HashSet<>();

        int result = 0;

        for (int n : nums) {
            if (unique.contains(n - k) && !done.contains(n + "" + (n - k))) {
                done.add(n + "" + (n - k));
                result++;
            }

            if (unique.contains(n + k) && !done.contains((n + k) + "" + n)) {
                done.add((n + k) + "" + n);
                result++;
            }

            unique.add(n);
        }

        return result;
    }

}
