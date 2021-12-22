package binarysearch.kthSmallestInMultiplicationTable;

import java.util.Arrays;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        // sol.findKthNumber(3, 1, 2);

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 13; j++) {
                System.out.print((i+1) * (j+1) + "\t");
            }
            System.out.print("\n");
        }
        sol.findKthNumber(11, 13, 57);
    }

    public int findKthNumber(int rows, int cols, int k) {
        int left = 1;
        int right = rows * cols;

        int mid = left + (right - left)/2;
        int[] count = new int[2];

        while (left <= right) {
            count = noOfElementsLessThanTarget(rows, cols, mid);
            if (count[0] == k) {
                break;
            }

            if (count[0] < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

            mid = left + (right - left)/2;
        }

        return count[1];
    }


    private int[] noOfElementsLessThanTarget (int rows, int cols, int target) {
        // count row wise
        int curRow = 0;
        int curCol = 0;

        int count = 0;
        int largest = 0;
        for (int r = 0; r < rows; r++) {
            if ((r + 1) * cols < target) {
                count += cols;
                continue;
            }

            for (int c = 0; c < cols; c++) {
                if ((r + 1) * (c + 1) >= target) {
                    break;
                }

                largest = Math.max(largest, (r + 1) * (c + 1));
                count++;
            }
        }

        return new int[] {count, largest};
    }
}
