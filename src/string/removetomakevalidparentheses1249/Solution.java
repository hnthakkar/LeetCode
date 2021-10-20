package string.removetomakevalidparentheses1249;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minRemoveToMakeValid("())()(((");
    }

    public String minRemoveToMakeValid(String s) {
        char[] sArray = s.toCharArray();
        int len = sArray.length;

        int count = 0;
        List<Integer> ref = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            if (sArray[i] == '(') {
                ref.add(i);
                count++;
                continue;
            }

            if (sArray[i] == ')') {
                if (count > 0) {
                    count--;
                    ref.remove(ref.size() - 1);
                } else {
                    sArray[i] = '*';
                }
            }
        }

        for (int i = 0; i < count; i++) {
            sArray[ref.get(i)] = '*';
        }

        StringBuilder sb = new StringBuilder();

        for(char ch: sArray) {
            if (ch == '*') {
                continue;
            }

            sb.append(ch);
        }

        return sb.toString();
    }
}
