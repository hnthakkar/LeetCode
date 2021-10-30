package math.happyNumber;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.isHappy(2);
    }

    public boolean isHappy(int n) {
        Set<Integer> doneSet = new HashSet<>();

        while (!doneSet.contains(n)) {
            doneSet.add(n);
            int tmp = 0;
            while (n > 0) {
                tmp += ((n % 10) * (n % 10));
                n /= 10;
            }

            if (tmp == 1) {
                return true;
            }

            n = tmp;
        }

        return false;
    }
}
