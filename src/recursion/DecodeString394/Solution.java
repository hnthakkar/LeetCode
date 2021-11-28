package recursion.DecodeString394;

import java.util.Stack;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        // sol.decodeString("3[a]2[bc]");
        // sol.decodeString("3[a2[c]]");
        // sol.decodeString("abc3[cd]xyz");
        sol.decodeString("100[leetcode]");

        // sol.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef");
    }

    public String decodeString(String s) {
        char[] sArray = s.toCharArray();
        int len = sArray.length;

        String finalString = "";
        Stack<String> stack = new Stack<>();

        int startBracketCount = 0;
        for (int i = 0; i < len; i++) {
            if (sArray[i] == ']') {
                String result = "";
                String cur = stack.pop();
                while (!cur.equals('[' + "")) {
                    result = cur + result;
                    cur = stack.pop();
                }

                cur = stack.peek();
                String repStr = "";
                while (cur.charAt(0) >= '0' && cur.charAt(0) <= '9') {
                    stack.pop();
                    repStr = cur + repStr;
                    if (stack.isEmpty()) {
                        break;
                    }
                    cur = stack.peek();
                }

                int curRepetition = Integer.parseInt(repStr);

                String tmp = result;
                while (--curRepetition > 0) {
                    result = result + tmp;
                }

                startBracketCount--;

                if (startBracketCount == 0) {
                    while (!stack.isEmpty()) {
                        result = stack.pop() + result;
                    }

                    finalString = finalString + result;
                } else {
                    stack.push(result);
                }

                continue;
            }

            if (sArray[i] == '[') {
                startBracketCount++;
            }

            stack.push(sArray[i] + "");
        }

        String remaining = "";
        while (!stack.isEmpty()) {
            remaining = stack.pop() + remaining;
        }

        return finalString + remaining;
    }
    /*
    public String decodeString(String s) {
        char[] sArray = s.toCharArray();
        int len = sArray.length;

        return helper(sArray, 0, len);
    }

     */

    /*
    private String helper(char[] sArray, int startIndex, int len) {
        if (startIndex >= len) {
            return "";
        }

        int curRepetition = 0;
        while (sArray[startIndex] >= '0' && sArray[startIndex] <= '9') {
            curRepetition = curRepetition * 10 + (sArray[startIndex] - '0');
            startIndex++;
        }

        if (curRepetition == 0) {
            curRepetition = 1;
        }

        StringBuilder sb = new StringBuilder();

        while (startIndex < len && !(sArray[startIndex] >= '0' && sArray[startIndex] <= '9')) {
            if (sArray[startIndex] == '[') {
                startIndex++;
                continue;
            }

            if (sArray[startIndex] == ']') {
                break;
            }

            sb.append(sArray[startIndex]);
            startIndex++;
        }

        if (startIndex >= len || sArray[startIndex] == ']') {
            String str = sb.toString();
            while (--curRepetition > 0) {
                sb.append(str);
            }

            return sb.toString() + helper(sArray, ++startIndex, len);
        } else {
            sb.append(helper(sArray, startIndex, len));
            String str = sb.toString();
            while (--curRepetition > 0) {
                sb.append(str);
            }

            return sb.toString();
        }
    }

     */

}
