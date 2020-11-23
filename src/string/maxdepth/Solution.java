package string.maxdepth;

public class Solution {

    public int maxDepth(String s) {
        char[] array = s.toCharArray();

        int maxDepth = 0;
        int currentDepth = 0;
        for (char ch: array) {
            if (ch == '(') {
                currentDepth++;
            } else if (ch == ')') {
                currentDepth--;
            }

            if (currentDepth > maxDepth) {
                maxDepth = currentDepth;
            }
        }

        return maxDepth;
    }
}
