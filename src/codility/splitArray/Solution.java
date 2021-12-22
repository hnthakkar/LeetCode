package codility.splitArray;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.solution(new int[]{-1000, 1000});
    }

    public int solution(int[] A) {
        int len = A.length;

        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += A[i];
        }

        int min = Integer.MAX_VALUE;

        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < len - 1; i++) {
            leftSum += A[i];
            rightSum = sum - leftSum;
            min = Math.min(min, Math.abs(leftSum - rightSum));
        }

        return min;
    }

}
