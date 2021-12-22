package bitmanipulation.divideTwoIntegers29;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.divide(-2147483648, -1);
    }

    public int divide(int divident, int divisor) {
        if (divident == 0) {
            return 0;
        }

        if (divisor == 1) {
            return divident;
        }

        if (divident == Integer.MAX_VALUE && divisor == -1) {
            return -Integer.MAX_VALUE;
        }

        if (divident == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean isPositive = ((long)divident * divisor) > 0;

        divident = Math.abs(divident);
        divisor = Math.abs(divisor);

        int result = 0;

        while (divident - divisor >= 0) {
            int tmp = divisor;
            int counter = 1;
            while (divident - (tmp << 1) >= 0) {
                tmp <<= 1;
                counter <<= 1;
            }

            result += counter;
            divident -= tmp;
        }

        return isPositive ? result : -result;
    }
}
