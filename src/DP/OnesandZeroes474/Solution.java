package DP.OnesandZeroes474;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findMaxForm(new String[]{"10","0","1"}, 1, 1));
    }

    /*
    ["10","0001","111001","1","0"]
    4
    3
     */

    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;

        Map<String, Integer> zeroMap = new HashMap<>();
        Map<String, Integer> oneMap = new HashMap<>();

        for (String s: strs) {
            populateMap(s, zeroMap, oneMap);
        }

        return helper(strs, m, n, 0, zeroMap, oneMap, len, 0);
    }

    private void populateMap(String s, Map<String, Integer> zeroMap, Map<String, Integer> oneMap) {
        char[] sArray = s.toCharArray();

        int zeroCount = 0;
        int oneCount = 0;

        for (char ch: sArray) {
            if (ch == '0') {
                zeroCount++;
            } else {
                oneCount++;
            }
        }

        zeroMap.put(s, zeroCount);
        oneMap.put(s, oneCount);
    }

    private int helper(String[] strs, int m, int n, int curIndex, Map<String, Integer> zeroMap, Map<String, Integer> oneMap, int len, int counter) {
        if (curIndex >= len || m < 0 || n < 0) {
            return counter;
        }

        int without = helper(strs, m, n, curIndex + 1, zeroMap, oneMap, len, counter);

        String curString = strs[curIndex];
        int zeroCount = zeroMap.get(curString);
        int oneCount = oneMap.get(curString);
        int with = Integer.MIN_VALUE;

        if (m - zeroCount >= 0 && n - oneCount >= 0) {
            with = helper(strs, m - zeroCount, n - oneCount, curIndex + 1, zeroMap, oneMap, len, counter + 1);
        }

        return Math.max(without, with);
    }
}
