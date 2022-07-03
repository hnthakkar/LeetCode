package array.QueueReconstructionbyHeight406;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        // sol.reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
        sol.reconstructQueue(new int[][]{{2, 4}, {3, 4}, {9, 0}, {0, 6}, {7, 1}, {6, 0}, {7, 3}, {2, 5}, {1, 1}, {8, 0}});
    }

    public int[][] reconstructQueue(int[][] people) {
        int len = people.length;

        Arrays.sort(people, new PeopleHeightPosition());

        int[][] result = new int[len][2];

        for (int i = 0; i < len; i++) {
            result[i][0] = -1;
        }

        for (int i = 0; i < len; i++) {
            int[] cur = people[i];
            int counter = 0;

            for (int j = 0; j < len; j++) {
                if (j < cur[1]) {
                    if (result[j][0] == -1 || result[j][0] >= cur[0]) {
                        counter++;
                    }

                    continue;
                }

                if (result[j][0] != -1 || counter < cur[1]) {
                    if (result[j][0] == -1 || result[j][0] >= cur[0]) {
                        counter++;
                    }
                    continue;
                }

                result[j] = cur;
                break;
            }
        }

        return result;
    }
}

class PeopleHeightPosition implements Comparator<int[]> {

    @Override
    public int compare(int[] o1, int[] o2) {
        if (o1[0] == o2[0]) {
            return o1[1] - o2[1];
        }

        return o1[0] - o2[0];
    }
}