package virtualContest.weeklyContest279.SmallestValueoftheRearrangedNumber2165;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        // sol.smallestNumber(310);
        // sol.smallestNumber(-7605);

        // sol.smallestNumber(-1005);
        // sol.smallestNumber(1005);
        sol.smallestNumber(0);
    }

    public long smallestNumber(long num) {
        if (num == 0) {
            return 0;
        }

        boolean isNegative = num < 0 ? true: false;

        if (isNegative) {
            num = -num;
        }

        List<Long> digits = new ArrayList<>();

        long tmp = num;
        while (tmp > 0) {
            digits.add(tmp%10);
            tmp /= 10;
        }

        if (isNegative) {
            Collections.sort(digits, (n1, n2)-> n2.compareTo(n1));
        } else {
            Collections.sort(digits);
            int checkIndex = 0;
            while (digits.get(checkIndex) == 0) {
                checkIndex++;
            }

            if (checkIndex < digits.size()) {
                long t = digits.get(checkIndex);
                digits.set(checkIndex, 0l);
                digits.set(0, t);
            }
        }

        long result = 0;

        for (long r: digits) {
            result = result* 10 + r;
        }

        return isNegative? -result: result;
    }

}
