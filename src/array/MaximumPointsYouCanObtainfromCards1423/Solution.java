package array.MaximumPointsYouCanObtainfromCards1423;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        // sol.maxScore(new int[]{1,2,3,4,5,6,1}, 3);
        // sol.maxScore(new int[]{2, 2, 2}, 2);
        sol.maxScore(new int[]{96, 90, 41, 82, 39, 74, 64, 50, 30}, 8);

        /*
        [96,90,41,82,39,74,64,50,30]
        */
    }

    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;

        for (int i = 1; i < len; i++) {
            cardPoints[i] += cardPoints[i - 1];
        }

        int windowSize = len - k;

        if (windowSize == 0) {
            return cardPoints[len - 1];
        }

        int result = cardPoints[windowSize - 1];

        for (int i = 0; (i + windowSize) < len; i++) {
            int cur = cardPoints[i + windowSize] - cardPoints[i];
            result = Math.min(result, cur);
        }

        return cardPoints[len - 1] - result;
    }
}
