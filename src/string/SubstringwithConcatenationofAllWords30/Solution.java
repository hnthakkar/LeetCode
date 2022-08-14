package string.SubstringwithConcatenationofAllWords30;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.findSubstring("ababaab", new String[]{"ab", "ba", "ba"});
    }

    /*
    "wordgoodgoodgoodbestword"
["word","good","best","good"]

"ababaab"
["ab","ba","ba"]
     */
    public List<Integer> findSubstring(String s, String[] words) {
        int noOfWords = words.length;
        int wordSize = words[0].length();

        int sLen = s.length();
        int wSize = noOfWords * wordSize;

        if (sLen < wSize) {
            return Collections.emptyList();
        }

        int[] ref = new int[26];
        Map<String, Integer> freq = new HashMap<>();

        for (String word : words) {
            char[] wArray = word.toCharArray();

            for (char ch : wArray) {
                ref[ch - 'a'] += 1;
            }

            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        char[] sArray = s.toCharArray();
        int[] curHash = new int[26];

        List<Integer> result = new ArrayList<>();

        for (int wStart = 0; wStart <= (sLen - wSize); wStart++) {
            if (wStart == 0) {
                curHash = getInitialHash(sArray, curHash, wSize);
            } else {
                curHash[sArray[wStart - 1] - 'a'] -= 1;
                curHash[sArray[wStart - 1 + wSize] - 'a'] += 1;
            }

            if (compareHash(ref, curHash) && containAllWords(s.substring(wStart, wStart + wSize), wSize, freq, wordSize)) {
                result.add(wStart);
            }
        }

        return result;
    }

    private boolean containAllWords(String s, int sLen, Map<String, Integer> freq, int wLen) {
        int startIndex = 0;
        int endIndex = startIndex + wLen;

        Map<String, Integer> curRef = new HashMap<>();

        while (endIndex <= sLen) {
            String curWord = s.substring(startIndex, endIndex);

            if (freq.containsKey(curWord) && freq.get(curWord) > curRef.getOrDefault(curWord, 0)) {
                startIndex = endIndex;
                endIndex = startIndex + wLen;
                curRef.put(curWord, curRef.getOrDefault(curWord, 0) + 1);
            } else {
                return false;
            }
        }

        return true;
    }

    private int[] getInitialHash(char[] sArray, int[] curHash, int wSize) {
        for (int i = 0; i < wSize; i++) {
            curHash[sArray[i] - 'a'] += 1;
        }

        return curHash;
    }

    private boolean compareHash(int ref[], int compareTo[]) {
        for (int i = 0; i < 26; i++) {
            if (ref[i] != compareTo[i]) {
                return false;
            }
        }

        return true;
    }
}
