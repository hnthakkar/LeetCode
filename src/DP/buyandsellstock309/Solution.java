package DP.buyandsellstock309;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maxProfit(new int[]{1,2,3,0,2});
    }

    public int maxProfit(int[] prices) {
        int len = prices.length;

        if (len == 1) {
            return 0;
        }

        int t_buy = prices[0];

        int profit = 0;
        int curIndex = 0;

        boolean buyStocks = true;

        while (curIndex < len) {
            if (buyStocks) {
                if (t_buy < prices[curIndex]) {
                    // nothing
                } else {
                    t_buy = prices[curIndex];
                    buyStocks = false;
                }

                curIndex++;
            } else {

                if (profit > prices[curIndex] - t_buy) {
                    // nothing
                } else {
                    profit = prices[curIndex] - t_buy;
                    buyStocks = true;
                    // cool down
                    curIndex += 2;
                    continue;
                }
                curIndex++;
            }
        }

        return profit;
    }
}
