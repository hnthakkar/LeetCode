package matrix.rectangleArea;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();

        int[][] input = new int[][] {
                {1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1},
                {1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0},
                {1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1}
        };

        ArrayList<ArrayList<Integer>> inp = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < input[0].length; j++) {
                row.add(input[i][j]);
            }
            inp.add(row);
        }

        sol.maximalRectangle(inp);
    }

    public int maximalRectangle(ArrayList<ArrayList<Integer>> A) {
        int rows = A.size();
        int cols = A.get(0).size();

        int maxArea = 0;

        if (rows == 1) {
            List<Integer> row = A.get(0);
            for (int j = 1; j < cols; j++) {
                if (row.get(j) == 1) {
                    row.set(j, row.get(j - 1) + 1);

                    if (row.get(j) > maxArea) {
                        maxArea = row.get(j);
                    }
                }
            }
        } else {
            for (int i = 1; i < rows; i++) {
                List<Integer> prevRow = A.get(i - 1);
                List<Integer> row = A.get(i);
                for (int j = 0; j < cols; j++) {
                    if (row.get(j) == 1) {
                        row.set(j, prevRow.get(j) + 1);
                    }
                }
            }

            /*
            for (int i = 0; i < rows; i++) {
                List<Integer> row = A.get(i);
                for (int j = 0; j < cols; j++) {
                    System.out.print(row.get(j) + " ");
                }
                System.out.print("\n");
            }

             */

            for (int i = 1; i < rows; i++) {
                List<Integer> row = A.get(i);
                for (int j = 0; j < cols; j++) {
                    if (row.get(j) > 0) {
                        int height = row.get(j);
                        int left = j;
                        while (left >= 0 && row.get(left) >= height) {
                            left--;
                        }

                        left++;

                        int right = j;
                        while (right < rows && row.get(right) >= height) {
                            right++;
                        }

                        right--;

                        int area = height * (right - left + 1);

                        maxArea = Math.max(maxArea, area);
                    }
                }
            }
        }


        return maxArea;
    }
}
