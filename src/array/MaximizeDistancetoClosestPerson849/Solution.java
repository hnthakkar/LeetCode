package array.MaximizeDistancetoClosestPerson849;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.maxDistToClosest(new int[]{0, 1});
    }

    public int maxDistToClosest(int[] seats) {
        int len = seats.length;
        int[] dp = new int[len];

        int distance = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            if (seats[i] == 1) {
                dp[i] = 0;
                distance = 0;
                continue;
            }

            dp[i] = distance == Integer.MAX_VALUE ? distance : ++distance;
        }

        int max = 0;
        distance = Integer.MAX_VALUE;
        for (int i = len - 1; i >= 0; i--) {
            if (seats[i] == 1) {
                distance = 0;
                continue;
            }

            dp[i] = Math.min(dp[i], distance == Integer.MAX_VALUE ? distance : ++distance);

            if (dp[i] > max) {
                max = dp[i];
            }
        }

        return max;
    }
}
