package math.ConstructtheRectangle492;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.constructRectangle(122122);
    }

    public int[] constructRectangle(int area) {
        int[] result = new int[2];

        int len = area;
        int width = 1;

        int lastValidWidth = 1;
        int lastValidLen = area;

        while (width <= len) {
            width += 1;

            if (area % width != 0) {
                continue;
            }

            len = area/width;

            if (width <= len) {
                lastValidWidth = width;
                lastValidLen = len;
            }
        }

        result[0] = lastValidLen;
        result[1] = lastValidWidth;

        return result;
    }
}
