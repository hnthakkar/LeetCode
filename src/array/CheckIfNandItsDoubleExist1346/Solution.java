package array.CheckIfNandItsDoubleExist1346;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.checkIfExist(new int[] {0, 1});
    }

    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for (int a : arr) {
            if (set.contains(2 * a) || (a % 2 == 0 && set.contains(a/2))) {
                return true;
            }

            set.add(a);
        }

        return false;
    }
}
