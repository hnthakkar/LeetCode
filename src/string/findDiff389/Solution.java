package string.findDiff389;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.findTheDifference("abcd", "abcde");
    }

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

}
