package codility.nest;

import java.util.Stack;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.solution("(()(())())");
        sol.solution("())");
    }

    public int solution(String S) {
        char[] sArray = S.toCharArray();
        int len = sArray.length;

        if (len == 0) {
            return 1;
        }

        if (sArray[0] == ')') {
            return 0;
        }

        Stack<Character> stack = new Stack<>();
        stack.push(sArray[0]);

        for (int i = 1; i < len; i++) {
            if (sArray[i] == '(') {
                stack.push(sArray[i]);
                continue;
            }

            if (stack.isEmpty()) {
                return 0;
            }

            char top = stack.pop();
            if (top == ')') {
                return 0;
            }
        }

        if (!stack.isEmpty()) {
            return 0;
        }

        return 1;
    }

}
