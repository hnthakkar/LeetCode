package string.CheckIfaStringContainsAllBinaryCodesofSizeK;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.hasAllCodes("00110110", 2);
    }

    public boolean hasAllCodes(String s, int k) {
        int expectedSize = (int)Math.pow(2, k);
        System.out.println("Expected Size : " + expectedSize);

        Set<String> found = new HashSet<>();

        int len = s.length();

        int lowerIndex = 0;
        int upperIndex = lowerIndex + k - 1;

        while (upperIndex < len) {
            System.out.println("Adding : " + s.substring(lowerIndex, upperIndex + 1));
            found.add(s.substring(lowerIndex++, upperIndex++ + 1));

            System.out.println("Expected Size : " + expectedSize + " Current Size : " + found.size());
            if (found.size() == expectedSize) {
                return true;
            }
        }

        return false;
    }
}
