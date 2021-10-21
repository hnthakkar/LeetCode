package array.winnercirculargame1823;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.findTheWinner(6, 6);
    }

    public int findTheWinner(int n, int k) {
        k = k % (n + 1);
        Set<Integer> done = new HashSet<>();

        int counted = 0;
        int curNumber = k;
        while (counted < n-1) {
            if (curNumber == 0) {
                curNumber++;
            }

            done.add(curNumber);
            counted++;
            for (int i = 0; i < k; i++) {
                curNumber = (curNumber + 1) % (n + 1);
                if (curNumber == 0) {
                    curNumber++;
                }
                while (done.contains((curNumber) % (n + 1))) {
                    curNumber = (curNumber + 1) % (n + 1);
                    if (curNumber == 0) {
                        curNumber++;
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (done.contains(i)) {
                continue;
            }

            return i;
        }

        return -1;
    }
}
