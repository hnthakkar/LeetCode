package binarysearch.guess;

public class Solution {

    private static final int picked = 1702766719;
    private static final int n = 2126753390;

    public static void main(String[] args) {
        Solution obj = new Solution();
        obj.guessNumber(n);
    }

    private int guess(int guessedNumber) {
        if (guessedNumber == picked) {
            return 0;
        } else if (guessedNumber < picked) {
            return -1;
        } else {
            return 1;
        }
    }

    public int guessNumber(int n) {
        if ( n == 1) {
            return 1;
        }

        int low = 1;
        int high = n;
        int ret = 0;

        while (low <= high) {
            int mid = low/2 + high/2 + 1;
            int guess = guess(mid);
            if (guess == 0) {
                ret = mid;
                break;
            } else if (guess == -1) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ret;
    }
}
