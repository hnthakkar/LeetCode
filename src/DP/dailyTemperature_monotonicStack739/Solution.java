package DP.dailyTemperature_monotonicStack739;

import java.util.Stack;

public class Solution {

    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;

        int[] result = new int[len];

        Stack<int[]> stack = new Stack<>();

        int next;
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek()[0] < temperatures[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                result[i] = stack.peek()[1] - i;
            }
            stack.push(new int[]{temperatures[i], i});
        }

        return result;
    }
}
