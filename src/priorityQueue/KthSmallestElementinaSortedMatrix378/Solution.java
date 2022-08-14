package priorityQueue.KthSmallestElementinaSortedMatrix378;

import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.kthSmallest(new int[][]{
                {4, 9, 9, 11, 12, 15, 17, 22, 23},
                {8, 10, 11, 14, 14, 17, 20, 23, 26},
                {9, 13, 16, 21, 23, 26, 30, 35, 36},
                {9, 14, 18, 21, 26, 29, 32, 35, 39},
                {12, 18, 19, 23, 27, 33, 34, 37, 39},
                {15, 20, 24, 26, 32, 34, 36, 39, 42},
                {16, 24, 28, 28, 33, 37, 37, 43, 44},
                {18, 28, 28, 29, 35, 42, 44, 49, 52},
                {23, 32, 34, 34, 39, 46, 51, 51, 56},
        }, 30);
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length; // n * n

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        int d = 0;

        while (d < n) {
            insertIntoQueue(matrix, pq, d, n);
            if (pq.size() > k) {
                break;
            }

            d++;
        }

        int peek = pq.peek();

        for (int r = d + 1; r < n; r++) {
            for (int c = d + 1; c < n; c++) {
                if (peek > matrix[r][c]) {
                    pq.add(matrix[r][c]);
                } else {
                    break;
                }
            }
        }

        while (pq.size() > k) {
            pq.poll();
        }

        return pq.poll();
    }

    private void insertIntoQueue(int[][] matrix, PriorityQueue<Integer> pq, int d, int n) {
        pq.add(matrix[d][d]);

        int curRow = d + 1;
        int curCol = d + 1;

        while (curCol < n) {
            pq.add(matrix[d][curCol++]);
        }

        while (curRow < n) {
            pq.add(matrix[curRow++][d]);
        }
    }

}
