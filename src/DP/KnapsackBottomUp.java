package DP;

public class KnapsackBottomUp {

    public static void main(String[] args) {
        KnapsackBottomUp ks = new KnapsackBottomUp();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }

    private int solveKnapsack(int[] profits, int[] weights, int capacity) {
        if (capacity <= 0 || profits.length == 0 || profits.length != weights.length) {
            return 0;
        }
        int[][] dp = new int[weights.length][capacity + 1];

        // if capacity is zero, than profit is zero
        for (int i = 0; i < weights.length; i++) {
            dp[i][0] = 0;
        }

        // if only one weight is available than only that can be used
        if (weights[0] <= capacity) {
            for (int i = 1; i <= capacity; i++) {
                dp[0][i] = profits[0];
            }
        }

        for (int r = 1; r < weights.length; r++) {
            for (int c = 1; c <= capacity; c++) {
                int profitWhenIncluded = 0, profitWhenNotIncluded = 0;
                // include the current item if capacity is there
                if (c >= weights[r]) {
                    profitWhenIncluded = profits[r] + dp[r-1][c - weights[r]];
                }

                profitWhenNotIncluded = dp[r-1][c];

                dp[r][c] = Math.max(profitWhenIncluded, profitWhenNotIncluded);
            }
        }

        return dp[weights.length - 1][capacity];
    }

}
