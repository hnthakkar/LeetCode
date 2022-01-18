package greedy.CanPlaceFlowers605;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        // sol.canPlaceFlowers(new int[]{0, 0, 1, 0, 1, 1}, 1);
        // sol.canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 1}, 2);
        // sol.canPlaceFlowers(new int[]{0, 0, 1, 0, 0}, 2);
        sol.canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 0, 1}, 2);
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int result = 0;

        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }


            if ((i > 0 && flowerbed[i - 1] == 1) || ((i < len - 1) && flowerbed[i + 1] == 1)) {
                continue;
            }

            result++;
            flowerbed[i] = 1;
        }

        return result >= n;
    }


    /*
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int result = 0;

        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }

            if (i > 0 && flowerbed[i - 1] == 1) {
                continue;
            }

            if (i < (len - 1) && flowerbed[i + 1] == 1) {
                continue;
            }

            flowerbed[i] = 1;
            result++;
        }

        return result >= n;
    }

     */

}
