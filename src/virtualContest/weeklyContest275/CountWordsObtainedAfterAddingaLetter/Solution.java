package virtualContest.weeklyContest275.CountWordsObtainedAfterAddingaLetter;

import java.util.*;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.wordCount(new String[]{"ant", "act", "tack"}, new String[]{"tack", "act", "acti"});
        //sol.wordCount(new String[]{"w","yg","bzau","bkh","sgfkr","uw","fsqmg","moavp"}, new String[]{"zhkb","iahgl","gjpd","ajhl","s","n","lyg","eb"});
    }

    public int wordCount(String[] startWords, String[] targetWords) {
        Set<String> sSet = new HashSet<>();

        for (String s: startWords) {
            char[] sArray = s.toCharArray();
            Arrays.sort(sArray);
            sSet.add(new String(sArray));
        }

        int result = 0;

        for (String t: targetWords) {
            int tLen = t.length();
            for (int j = 0; j < tLen; j++) {
                String tmp = t.substring(0, j) + t.substring(j + 1);
                char[] tmpArray = tmp.toCharArray();
                Arrays.sort(tmpArray);

                if (sSet.contains(new String(tmpArray))) {
                    result++;
                    break;
                }
            }
        }

        return result;
    }

}
