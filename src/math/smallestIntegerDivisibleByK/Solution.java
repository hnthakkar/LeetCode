package math.smallestIntegerDivisibleByK;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.smallestRepunitDivByK(23);
    }

    public int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }

        int r = 0;

        for (int i = 1; i <= k; i++) {
            r = (r * 10 + 1) % k;
            if (r % k == 0) {
                return i;
            }
        }

        return -1;
    }
}
