package array.maxprofit;

public class MaxProfit {

    public int maxProfit(int[] prices) {
        // 7,1,5,3,6,4
        int len = prices.length;
        int currentMax = 0;
        int maxSoFar = 0;
        int index = 0;

        for (int i = 1; i < len; i++) {
            currentMax = Math.max(0, prices[i] - prices[index]);
            if ( currentMax == 0) {
                index = i;
            }

            if (currentMax > maxSoFar) {
                maxSoFar = currentMax;
            }
        }

        return maxSoFar;
    }
}
