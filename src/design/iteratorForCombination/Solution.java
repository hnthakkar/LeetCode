package design.iteratorForCombination;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public static void main(String[] str) {

        CombinationIterator sol = new CombinationIterator("abcequx", 4);
        int count = 20;
        while (count >= 0) {
            sol.next();
            count--;
        }
        /*
        sol.hasNext();
        sol.next();
        sol.hasNext();
        sol.next();
        sol.hasNext();
        sol.next();
        sol.next();
        sol.next();
        sol.hasNext();
        sol.hasNext();
        sol.next();
        sol.hasNext();
        sol.hasNext();
        sol.next();
        sol.hasNext();
        sol.next();
        sol.hasNext();
        sol.hasNext();
        sol.hasNext();
        sol.next();
        sol.next();
        sol.hasNext();
        sol.next();
        sol.hasNext();
        sol.next();
        sol.next();

         */
    }
}

class CombinationIterator {

    Stack<Integer> stack;
    int curIndex = 0;

    List<String> result = new ArrayList<>();

    public CombinationIterator(String characters, int len) {
        char[] sArray = characters.toCharArray();
        int sLen = sArray.length;

        stack = new Stack<>();
        int nextCharIndex = 0;
        stack.push(nextCharIndex++);

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty() || nextCharIndex < sLen) {
            while (nextCharIndex < sLen && stack.size() < len) {
                stack.push(nextCharIndex++);
            }

            if (stack.isEmpty()) {
                break;
            }

            if (stack.size() < len) {
                nextCharIndex = stack.pop() + 1;
            } else {
                System.out.print("\n");
                for (int i = 0; i < len; i++) {
                    System.out.print(stack.get(i));
                    sb.append(sArray[stack.get(i)]);
                }

                result.add(sb.toString());
                sb.setLength(0);
                nextCharIndex = stack.pop() + 1;
            }
        }
    }

    public String next() {
        return result.get(curIndex++);
    }

    public boolean hasNext() {
        return curIndex < result.size();
    }
}