package array.RemoveAllAdjacentDuplicatesinStringII;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.removeDuplicates("deeedbbcccbdaa", 3));
        // System.out.println(sol.removeDuplicates("abcd", 2));
    }

    public String removeDuplicates(String s, int k) {
        char[] sArray = s.toCharArray();
        int len = sArray.length;

        Stack<Character> stack = new Stack<>();
        Stack<Integer> counter = new Stack<>();

        int curIndex = 0;

        while (curIndex < len) {
            if (!stack.isEmpty()) {
                if (sArray[curIndex] == stack.peek()) {
                    int count = counter.pop() + 1;

                    if (count == k) {
                        stack.pop();
                    } else {
                        counter.push(count);
                    }
                } else {
                    stack.push(sArray[curIndex]);
                    counter.push(1);
                }
            } else {
                stack.push(sArray[curIndex]);
                counter.push(1);
            }

            curIndex++;
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            char ch = stack.pop();
            int rep = counter.pop();

            while (rep > 0) {
                sb.append(ch);
                rep--;
            }
        }

        return sb.reverse().toString();
    }
}

