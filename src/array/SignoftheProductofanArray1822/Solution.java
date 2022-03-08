package array.SignoftheProductofanArray1822;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.arraySign(new int[]{41, 65, 14, 80, 20, 10, 55, 58, 24, 56, 28, 86, 96, 10, 3, 84, 4, 41, 13, 32, 42, 43, 83, 78, 82, 70, 15, -41});
    }

    public int arraySign(int[] nums) {
        int negativeCount = 0;

        for (int n : nums) {
            if (n == 0) {
                return 0;
            }

            if (n < 0) {
                negativeCount++;
            }
        }

        return negativeCount % 2 == 0 ? 1 : -1;
    }

}
