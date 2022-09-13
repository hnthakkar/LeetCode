package array.TheNumberofWeakCharactersintheGame1996;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int numberOfWeakCharacters(int[][] properties) {
        int len = properties.length;
        Arrays.sort(properties, new PComparator());

        int result = 0;
        int maxY = properties[len - 1][1];

        for (int i = len - 2; i >= 0; i--) {
            if (properties[i][1] < maxY) {
                result += 1;
            } else if (properties[i][1] > maxY) {
                maxY = properties[i][1];
            }
        }

        return result;
    }
}

class PComparator implements Comparator<int[]> {

    public int compare(int[] a, int[] b) {
        if (a[0] != b[0]) {
            return a[0] - b[0];
        }

        return b[1] - a[1];
    }
}