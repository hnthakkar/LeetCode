package matrix.ChampagneTower799;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        /*
        sol.champagneTower(100000009, 33, 17);
        sol.champagneTower(1, 1, 1);
        sol.champagneTower(2, 1, 1);
        sol.champagneTower(4, 2, 2);
        sol.champagneTower(4, 2, 1);
        sol.champagneTower(4, 2, 0);

         */
        sol.champagneTower(25, 6, 1);
    }

    public double champagneTower(int poured, int query_row, int query_glass) {
        int curR = 0;
        int curC = 0;

        int counter = 1;
        boolean prevRowFilled = false;
        while ((poured - counter) > 0) {
            poured -= counter;
            counter++;

            if (curR >= query_row) {
                return 1;
            }
            prevRowFilled = true;
            curR++;
        }

        if (query_row - curR > 1 || !prevRowFilled) {
            return 0;
        }

        double eachGlass = (double)poured/ (double) (counter + (counter - 2));

        if (query_glass == 0 || query_glass == counter - 1) {
            return eachGlass;
        }

        return 2 * eachGlass;
    }
}
