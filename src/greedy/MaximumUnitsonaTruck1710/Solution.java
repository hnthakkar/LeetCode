package greedy.MaximumUnitsonaTruck1710;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maximumUnits(new int[][]{{5, 10},{2, 5}, {4, 7}, {3, 9}}, 10);
    }

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int len = boxTypes.length;

        Arrays.sort(boxTypes, new TwoDComparator());

        int result = 0;

        for (int i = 0; i < len; i++) {
            int[] curType = boxTypes[i];

            if (curType[0] <= truckSize) {
                result += (curType[0] * curType[1]);
                truckSize -= curType[0];
            } else {
                result += (truckSize * curType[1]);
                truckSize = 0;
                break;
            }

            System.out.println("***" + result);

            if (truckSize <= 0) {
                break;
            }
        }

        return result;
    }

}

class TwoDComparator implements Comparator<int[]> {

    @Override
    public int compare(int[] o1, int[] o2) {
        if (o1[1] == o2[1]) {
            return o2[0] - o1[0];
        }

        return o2[1] - o1[1];
    }

}