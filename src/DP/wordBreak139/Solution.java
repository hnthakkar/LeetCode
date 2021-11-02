package DP.wordBreak139;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        List<String> dict = new ArrayList<>();
        dict.add("leet");
        dict.add("code");
        sol.wordBreak("leetcode", dict);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        char[] sArray = s.toCharArray();
        int sLen = sArray.length;

        Map<String, String> dictWordMap = new HashMap<>();

        for (String word: wordDict) {
            char[] charWord = word.toCharArray();
            int len = charWord.length;
            int hashCode = 0;
            for (char ch: charWord) {
                hashCode += (ch - 'a');
            }

            dictWordMap.put("" + charWord[0] + charWord[len - 1] + len  + hashCode, word);
        }

        return helper(sArray, 0, dictWordMap, sLen);
    }

    private boolean helper(char[] sArray, int startIndex, Map<String, String> dictWordMap, int len) {
        if (startIndex >= len) {
            return true;
        }

        char startChar = sArray[startIndex];
        char endChar = sArray[startIndex];
        int curLen = 0;
        int hashCode = 0;

        for (int i = startIndex; i < len; i++) {
            endChar = sArray[i];
            curLen++;
            hashCode += (sArray[i] - 'a');
            String key = "" + startChar + endChar + curLen + hashCode;

            if (dictWordMap.containsKey(key) && checkMatch(sArray, startIndex, i, dictWordMap.get(key)) && helper(sArray, i + 1, dictWordMap, len)) {
                return true;
            }
        }

        return false;
    }

    private boolean checkMatch(char[] sArray, int startIndex, int endIndex, String dictWord) {
        char[] dArray = dictWord.toCharArray();

        for (int i = startIndex; i <= endIndex; i++) {
            if (sArray[i] != dArray[i - startIndex]) {
                return false;
            }
        }

        return true;
    }
}
