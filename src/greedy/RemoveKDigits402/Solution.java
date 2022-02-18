package greedy.RemoveKDigits402;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        // sol.removeKdigits("1919191", 3);
        sol.removeKdigits("12345", 2);
    }

    public String removeKdigits(String num, int k) {
        char[] nArray = num.toCharArray();
        int len = nArray.length;

        if (len == k) {
            return "0";
        }

        Stack<Integer> stack = new Stack<>();
        List<Integer> tmp = new ArrayList<>();

        for (int i = len - 1; i >= 0; i--) {
            if (stack.size() < (len - k)) {
                stack.push(nArray[i] - '0');
                continue;
            }

            int ref = nArray[i] - '0';

            if (stack.peek() < ref) {
                continue;
            }

            while (!stack.isEmpty()) {
                if (stack.peek() >= ref) {
                    ref = stack.pop();
                    tmp.add(ref);
                } else {
                    break;
                }
            }

            for (int j = tmp.size() - 2; j >= 0; j--) {
                stack.push(tmp.get(j));
            }

            stack.push(nArray[i] - '0');

            tmp.clear();
        }

        StringBuilder sb = new StringBuilder();

        boolean checkLeadingZero = true;

        while (!stack.isEmpty()) {
            int top = stack.pop();

            if (!(top == 0 && checkLeadingZero)) {
                sb.append(top);
                checkLeadingZero = false;
            }
        }

        return sb.length() > 0 ? sb.toString(): "0";
    }
}
