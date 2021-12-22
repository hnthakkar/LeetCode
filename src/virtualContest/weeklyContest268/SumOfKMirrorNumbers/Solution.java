package virtualContest.weeklyContest268.SumOfKMirrorNumbers;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.kMirror(3, 7);
    }

    public long kMirror(int k, int n) {
        int sum = 0;

        if (n == 0) {
            return 0;
        }

        int[] basek = new int[1000];
        int[] base10 = new int[1000];

        int counter = n;
        int decimal = 0;

        while (counter > 0) {
            basek[0] += 1;
            base10[0] += 1;
            decimal++;

            int cur = 0;

            while (basek[cur] > (k - 1)) {
                basek[cur] = 0;
                basek[++cur] += 1;
            }

            cur = 0;

            while (base10[cur] > 1) {
                base10[cur] = 0;
                base10[++cur] += 1;
            }

            if (checkIfPalindrome(basek) && checkIfPalindrome(base10)) {
                counter--;
                sum += decimal;
            }
        }

        return sum;
    }

    private boolean checkIfPalindrome(int[] result) {
        int left = 0;
        int right = result.length - 1;
        while (result[right] == 0) {
            right--;
        }

        while (left < right) {
            if (result[left] != result[right]) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
