package string.findDiff389;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.findTheDifference("abcd", "abcde");
    }

    public char findTheDifference(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Map<Character, Integer> sMap = new HashMap<>();

        for (char ch: sArray) {
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
        }

        for (char ch: tArray) {
            if (!sMap.containsKey(ch)) {
                return ch;
            }

            int count = sMap.get(ch);

            if (count == 1) {
                sMap.remove(ch);
            } else {
                sMap.put(ch, count - 1);
            }
        }

        return sMap.keySet().iterator().next();
    }

    /*
    public char findTheDifference(String s, String t) {
        char[] sArray = s.toCharArray();
        int sLen = sArray.length;

        int[] sMap = new int[26];

        for (int i = 0; i < sLen; i++) {
            sMap[sArray[i] - 'a'] += 1;
        }

        char[] tArray = t.toCharArray();
        char returnChar = '\u0000';

        for (int i = 0; i <= sLen; i++) {
            if (sMap[tArray[i] - 'a'] > 0) {
                sMap[tArray[i] - 'a'] -= 1;
            } else {
                returnChar = tArray[i];
                break;
            }
        }

        return returnChar;
    }

     */

}
