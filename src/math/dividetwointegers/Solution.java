package math.dividetwointegers;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.divide(-2147483648, -1);
    }

    public int divide(int dividend, int divisor) {
        if (divisor == 1) {
            return  dividend;
        }

        if (divisor == -1) {
            if (dividend < 0) {
                return dividend * -1;
            }
            return dividend;
        }


        int answer = 0;

        boolean isDividendNegative = false;
        if (dividend < 0) {
            isDividendNegative = true;
            dividend *= -1;
        }

        boolean isDivisorNegative = false;
        if (divisor < 0) {
            isDivisorNegative = true;
            divisor *= -1;
        }

        while (dividend >= divisor) {
            answer++;
            dividend -= divisor;
        }

        if ((isDividendNegative && !isDivisorNegative) || (!isDividendNegative && isDivisorNegative)) {
            answer *= -1;
        }

        return answer;
    }
}
