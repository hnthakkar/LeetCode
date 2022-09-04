package backtracking.NumbersWithSameConsecutiveDifferences967;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> done = new HashSet<>();

        for (int i = 1; i <= 9; i++) {
            helper(i, i, n, k, 1, result, done);
        }

        int len = result.size();
        int[] resultArr = new int[len];

        for (int i = 0;  i < len; i++) {
            resultArr[i] = result.get(i);
        }

        return resultArr;
    }

    private void helper(int lastDigit, int number, int n, int k, int digitsCount, List<Integer> result, Set<Integer> done) {
        if (digitsCount == n) {
            if (!done.contains(number)) {
                result.add(number);
                done.add(number);
            }

            return;
        }

        if (lastDigit - k >= 0) {
            helper(lastDigit - k, number * 10 + (lastDigit - k), n, k, digitsCount + 1, result, done);
        }

        if (lastDigit + k <= 9) {
            helper(lastDigit + k, number * 10 + (lastDigit + k), n, k, digitsCount + 1, result, done);
        }
    }

}
