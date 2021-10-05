package DP.dungeongame174;

public class Solution {

    public int calculateMinimumHP(int[][] dungeon) {
        int rows = dungeon.length;
        int cols = dungeon[0].length;

        for (int r = rows - 1; r >= 0; r--) {
            for (int c = cols - 1; c >= 0; c--) {
                if (r == rows - 1 && c == cols -1) {
                    dungeon[r][c] = Math.min(0, dungeon[r][c]);
                    continue;
                }

                int right = Integer.MIN_VALUE;
                if (c < cols - 1) {
                    right = dungeon[r][c+1];
                }

                int down = Integer.MIN_VALUE;
                if (r < rows - 1) {
                    down = dungeon[r+1][c];
                }

                dungeon[r][c] += Math.max(right, down);

                if (dungeon[r][c] > 0) {
                    dungeon[r][c] = 0;
                }
            }
        }

        return (dungeon[0][0] > 0 ? 0 : Math.abs(dungeon[0][0])) + 1;
    }

}
