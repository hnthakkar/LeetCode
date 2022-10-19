package slidingwindow.MinimumWindowSubstring76;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        // sol.minWindow("ADOBECODEBANC", "ABC");
        sol.minWindow("ab", "b");
    }

    public String minWindow(String s, String t) {
        char[] tArray = t.toCharArray();
        char[] sArray = s.toCharArray();

        int sLen = sArray.length;

        Map<Character, Integer> tFreqMap = new HashMap<>();

        for (char ch: tArray) {
            tFreqMap.put(ch, tFreqMap.getOrDefault(ch, 0) + 1);
        }

        int globalMin = Integer.MAX_VALUE;
        int minLeft = 0;
        int minRight = 0;
        int lIndex = 0;
        int rIndex = 0;

        Map<Character, Integer> sFreqMap = new HashMap<>();

        while (lIndex <= rIndex) {
            if (containsChars(sFreqMap, tFreqMap)) {
                if (rIndex - lIndex < globalMin) {
                    globalMin = rIndex - lIndex;
                    minLeft = lIndex;
                    minRight = rIndex;
                }

                sFreqMap.put(sArray[lIndex], sFreqMap.get(sArray[lIndex]) - 1);
                lIndex++;
            } else {
                if (rIndex == sLen) {
                    break;
                }
                sFreqMap.put(sArray[rIndex], sFreqMap.getOrDefault(sArray[rIndex], 0) + 1);
                rIndex++;
            }
        }

        return s.substring(minLeft, minRight);
    }

    private boolean containsChars(Map<Character, Integer> sFreqMap, Map<Character, Integer> tFreqMap) {
        for (char ch: tFreqMap.keySet()) {
            if (sFreqMap.getOrDefault(ch, 0) < tFreqMap.get(ch)) {
                return false;
            }
        }

        return true;
    }
}
