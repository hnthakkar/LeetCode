package greedy.RemoveKDigits402;

import java.util.Stack;

public class Solution1 {

    public static void main(String[] str) {
        Solution1 sol = new Solution1();
        sol.removeKdigits("12345", 2);
    }

    public String removeKdigits(String num, int k) {
        char[] nArray = num.toCharArray();
        int len = nArray.length;

        Stack<Integer> stack = new Stack<>();
        stack.push(nArray[0] - '0');

        for (int i = 1; i < len; i++) {
            int ref = nArray[i] - '0';

            while (stack.peek() > ref && k > 0) {
                stack.pop();
                k--;
            }
            if (!(stack.isEmpty() && ref == 0)) {
                stack.push(ref);
            }
        }

        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.length() == 0? "0": sb.reverse().toString();
    }
}
