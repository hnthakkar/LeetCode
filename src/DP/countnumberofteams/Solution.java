package DP.countnumberofteams;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.numTeams(new int[]{2,5,3,4,1});
    }

    public int numTeams(int[] rating) {
        int len = rating.length;

        int[] lessToLeft = new int[len];
        int[] moreToLeft = new int[len];

        for (int i = 0; i < len; i++) {
            int lessCount = 0;
            int moreCount = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (rating[i] > rating[j]) {
                    lessCount++;
                } else {
                    moreCount++;
                }
            }

            lessToLeft[i] = lessCount;
            moreToLeft[i] = moreCount;
        }

        int[] lessToRight = new int[len];
        int[] moreToRight = new int[len];

        for (int i = len - 1; i >= 0; i--) {
            int lessCount = 0;
            int moreCount = 0;
            for (int j = i + 1; j < len; j++) {
                if (rating[i] > rating[j]) {
                    lessCount++;
                } else {
                    moreCount++;
                }
            }

            lessToRight[i] = lessCount;
            moreToRight[i] = moreCount;
        }

        int combinations = 0;
        for (int i = 1; i < len - 1; i++) {
            combinations += ((lessToLeft[i] * moreToRight[i]) + (lessToRight[i] * moreToLeft[i]));
        }

        return combinations;
    }
}
