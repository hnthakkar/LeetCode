package binarysearch.SumofSquareNumbers633;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.judgeSquareSum(2147483600);
    }

    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int) Math.sqrt(c);

        while (left <= right) {
            int ref = left * left + right * right;

            if (ref > c) {
                right--;
            } else if (ref < c) {
                left++;
            } else {
                return true;
            }
        }

        return false;
    }
}
