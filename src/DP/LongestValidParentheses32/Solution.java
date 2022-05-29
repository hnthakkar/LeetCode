package DP.LongestValidParentheses32;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.longestValidParentheses("(()");
    }

    public int longestValidParentheses(String s) {
        char[] sArray = s.toCharArray();
        int len = sArray.length;

        Stack<Character> stack = new Stack<>();
        int curMax = 0;
        int globalMax = 0;

        int lastValidStart = 0;

        for (int i = 0; i < len; i++) {
            if (sArray[i] == '(') {
                stack.push('(');
            } else {
                if (stack.peek() != '(') {
                    // invalid
                    stack.clear();
                    lastValidStart = i;
                } else {
                    curMax = i - lastValidStart;
                    globalMax = Math.max(globalMax, curMax);
                }
            }
        }

        return globalMax;
    }
}
