package array.RichestCustomerWealth1672;

public class Solution {

    public int maximumWealth(int[][] accounts) {
        int rows = accounts.length;
        int cols = accounts[0].length;

        int rowMax = 0;

        for (int i = 0; i < rows; i++) {
            int curRowSum = 0;
            for (int j = 0; j < cols; j++) {
                curRowSum += accounts[i][j];
            }

            rowMax = Math.max(rowMax, curRowSum);
        }

        return rowMax;
    }

}
