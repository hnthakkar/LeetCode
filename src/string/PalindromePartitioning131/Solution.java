package string.PalindromePartitioning131;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        // sol.partition("aab");
        sol.partition("cbbbcc");
    }

    public List<List<String>> partition(String s) {
        char[] sArray = s.toCharArray();
        int len = sArray.length;

        List<List<String>> result = new ArrayList<>();
        List<String> cur = new ArrayList<>();

        int[][] dp = new int[len][len];

        helper(result, cur, sArray, len, 0, dp);

        return result;
    }

    private void helper(List<List<String>> result, List<String> cur, char[] sArray, int len, int startAt, int[][] dp) {
        if (startAt >= len) {
            result.add(new ArrayList<String>(cur));
            return;
        }

        for (int i = startAt; i < len; i++) {
            if (dp[startAt][i] == 0) {
                dp[startAt][i] = checkIfPalin(startAt, i, sArray) ? 1 : 2;
            }

            if (dp[startAt][i] == 1) {
                String curStr = new String(sArray, startAt, i - startAt + 1);
                cur.add(curStr);
                helper(result, cur, sArray, len, i + 1, dp);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean checkIfPalin(int left, int right, char[] sArray) {
        while (left < right) {
            if (sArray[left] != sArray[right]) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

}
