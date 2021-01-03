package binarysearch.isperfectsquare;

public class Solution {

    public static void main(String[] args) {
        Solution obj = new Solution();
        System.out.println(obj.isPerfectSquare(4));
    }

    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }

        int start = 0;
        int end = num/2;
        return isPerfectSquare(num, start, end);
    }

    private boolean isPerfectSquare(long num, long start, long end) {
        if (end - start < 0) {
            return false;
        }

        long mid = (start + end)/2;
        long tmp = mid * mid;
        if (tmp == num) {
            return true;
        } else if (tmp > num) {
            return isPerfectSquare(num, start, mid -1);
        } else {
            return isPerfectSquare(num, mid + 1, end);
        }
    }
}
