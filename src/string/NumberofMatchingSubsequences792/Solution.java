package string.NumberofMatchingSubsequences792;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.numMatchingSubseq("dsahjpjauf", new String[]{"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"});
    }

    public int numMatchingSubseq(String s, String[] words) {
        int result = 0;

        Map<Character, List<Integer>> ref = new HashMap<>();
        char[] sArray = s.toCharArray();
        int sLen = sArray.length;

        for (int i = 0; i < sLen; i++) {
            if (ref.containsKey(sArray[i])) {
                ref.get(sArray[i]).add(i);
            } else {
                List<Integer> indexes = new ArrayList<>();
                indexes.add(i);

                ref.put(sArray[i], indexes);
            }
        }

        for (String word : words) {
            if (isSubsequence(word, ref)) {
                result++;
            }
        }

        return result;
    }

    private boolean isSubsequence(String word, Map<Character, List<Integer>> ref) {
        int refIndex = -1;
        char[] wArray = word.toCharArray();
        int wIndex = 0;
        int wLen = wArray.length;

        while (ref.containsKey(wArray[wIndex])) {
            List<Integer> indexes = ref.get(wArray[wIndex]);
            wIndex++;

            boolean foundNext = false;
            for (int cur : indexes) {
                if (cur > refIndex) {
                    refIndex = cur;
                    foundNext = true;
                    break;
                }
            }

            if (!foundNext) {
                return false;
            }

            if (wIndex == wLen) {
                return true;
            }
        }

        return false;
    }

    /*
    public int numMatchingSubseq(String s, String[] words) {
        int len = words.length;

        char[][] ref = new char[len][];
        int[] expected = new int[len];

        for (int i = 0; i < len; i++) {
            ref[i] = words[i].toCharArray();
            expected[i] = ref[i].length;
        }

        int[] indexes = new int[len];

        char[] sArray = s.toCharArray();
        int sLen = sArray.length;

        for (int i = 0; i < sLen; i++) {
            for (int j = 0; j < len; j++) {
                if (indexes[j] < expected[j] && sArray[i] == ref[j][indexes[j]]) {
                    indexes[j] += 1;
                }
            }
        }

        int result = 0;

        for (int i = 0; i < len; i++) {
            if (expected[i] == indexes[i]) {
                result++;
            }
        }

        return result;
    }

     */

}
