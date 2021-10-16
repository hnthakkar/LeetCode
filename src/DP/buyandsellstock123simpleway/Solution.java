package DP.buyandsellstock123simpleway;

public class Solution {

    public int maxProfit(int[] prices) {
        int len = prices.length;

        if (len == 1) {
            return 0;
        }

        int[] l2RMax = new int[len];
        int min = prices[0];
        l2RMax[0] = 0;

        for (int i = 1; i < len; i++) {
            min = Math.min(min, prices[i]);
            l2RMax[i] = Math.max(l2RMax[i], prices[i] - min);
        }

        int[] r2LMax = new int[len];
        int max = prices[len - 1];
        r2LMax[len - 1] = 0;

        for (int i = len - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            r2LMax[i] = Math.max(r2LMax[i + 1], max - prices[i]);
        }

        int maxProfit = 0;
        for (int i = 0; i < len; i++) {
            maxProfit = Math.max(maxProfit, l2RMax[i] + r2LMax[i]);
        }

        return maxProfit;
    }
}

/*
https://www.youtube.com/watch?v=e8K4c6OoK-Q
 */
