package virtualContest.weeklyContest263.CheckifNumbersAreAscendinginaSentence2042;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles");
    }

    public boolean areNumbersAscending(String s) {
        String[] sArray = s.split(" ");

        int last = -1;

        for (String cur: sArray) {
            int n = isNumber(cur);
            if (n > -1) {
                if (n <= last) {
                    return false;
                }

                last = n;
            }
        }

        return true;
    }

    private int isNumber(String s) {
        char[] sArray = s.toCharArray();
        int result = 0;

        for (char ch : sArray) {
            if (ch < '0' || ch > '9') {
                return -1;
            }

            result = result * 10 + (ch - '0');
        }

        return result;
    }
}
