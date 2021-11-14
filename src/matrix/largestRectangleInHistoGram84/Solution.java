package matrix.largestRectangleInHistoGram84;

import java.util.Stack;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.largestRectangleArea(new int[]{2,1,5,6,2,3});
    }

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;

        int[] leftBound = new int[len];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                leftBound[i] = 0;
            } else {
                leftBound[i] = stack.peek() + 1;
            }
            stack.push(i);
        }

        stack.clear();
        int[] rightBound = new int[len];

        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                rightBound[i] = len - 1;
            } else {
                rightBound[i] = stack.peek() - 1;
            }
            stack.push(i);
        }

        int max = 0;

        for (int i = 0; i < len; i++) {
            max = Math.max(max, heights[i] * (rightBound[i] - leftBound[i] + 1));
        }

        return max;
    }
}
