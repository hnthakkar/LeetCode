package virtualContest.weeklyContest264.two;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.nextBeautifulNumber(3000);
    }

    public int nextBeautifulNumber(int n) {
        int noOfDigits = 0;
        int tmp = n;

        int[] freq = new int[10];

        while (tmp > 0) {
            int cur = tmp % 10;
            freq[cur] += 1;
            noOfDigits++;

            tmp /= 10;
        }

        return 0;
    }

}
