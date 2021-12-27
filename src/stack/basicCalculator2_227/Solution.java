package stack.basicCalculator2_227;

import java.util.Stack;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.calculate("3+2*2");
    }

    public int calculate(String s) {
        char[] sArray = s.toCharArray();
        int len = sArray.length;

        int result = 0;

        Stack<Integer> stack = new Stack<>();

        int[] firstNumInfo = getNextDigit(sArray, 0, len);
        stack.push(firstNumInfo[0]);

        for (int i = firstNumInfo[1] + 1; i < len; i++) {
            if (sArray[i] == ' ') {
                continue;
            }

            char sign = sArray[i++];

            int[] info = getNextDigit(sArray, i, len);
            int num2 = info[0];
            i = info[1];

            switch(sign) {
                case '+':
                    stack.push(num2);
                    break;

                case '-':
                    stack.push(-num2);
                    break;

                case '*':
                    stack.push(stack.pop() * num2);
                    break;

                case '/':
                    stack.push(stack.pop() / num2);
                    break;
            }
        }

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    private int[] getNextDigit(char[] sArray, int startAt, int len) {
        int digit = 0;

        while (startAt < len && sArray[startAt] == ' ') {
            startAt++;
        }

        if (startAt < len &&  sArray[startAt] >= '0' && sArray[startAt] <= '9') {
            digit = sArray[startAt] - '0';

            while ((startAt + 1) < len && sArray[startAt + 1] >= '0' && sArray[startAt + 1] <= '9') {
                digit = digit * 10 + (sArray[startAt + 1] - '0');
                startAt++;
            }
        }

        return new int[] {digit, startAt};
    }
}
