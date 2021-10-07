package matrix.spiral2matrix59;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.generateMatrix(3);
    }

    public int[][] generateMatrix(int n) {
        int upperBoundary = 0;
        int lowerBoundary = n - 1;
        int leftBoundary = 0;
        int rightBoundary = n - 1;

        int[][] result = new int[n][n];

        int counter = 1;
        int limit = (int) Math.pow(n, 2);

        int x = 0, y = 0;

        while(counter <= limit) {
            // go right
            while (y <= rightBoundary) {
                result[x][y] = counter;
                counter++;
                y++;
            }

            upperBoundary++;
            y -= 1;
            x += 1;

            // go down
            while (x <= lowerBoundary) {
                result[x][y] = counter;
                counter++;
                x++;
            }

            rightBoundary--;
            x -= 1;
            y -= 1;

            // go left
            while (y >= leftBoundary) {
                result[x][y] = counter;
                counter++;
                y--;
            }

            lowerBoundary--;
            y++;
            x--;

            // go up
            while (x >= upperBoundary) {
                result[x][y] = counter;
                counter++;
                x--;
            }

            leftBoundary++;
            x++;
            y++;
        }

        return result;
    }
}
