package virtualContest.weeklyContest280.one;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.countOperations(2, 3);
    }

    public int countOperations(int num1, int num2) {
        if (num1 == num2) {
            return 1;
        }

        if (num2 > num1) {
            num2 = num2 - num1;
        } else {
            num1 = num1 - num2;
        }

        return 1 + countOperations(num1, num2);
    }
}
