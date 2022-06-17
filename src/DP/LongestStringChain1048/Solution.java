package DP.LongestStringChain1048;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.longestStrChain(new String[]{"a","b","ba","bca","bda","bdca"});
    }

    public int longestStrChain(String[] words) {
        Map<String, Integer> ref = new HashMap<>();

        for (String word: words) {
            ref.put(word, -1);
        }

        int result = 0;

        for (String word: words) {
            int cur = helper(word, ref);
            result = Math.max(result, cur);
        }

        return result;
    }

    private int helper(String word, Map<String, Integer> ref) {
        if (ref.getOrDefault(word, 1) > 0) {
            return ref.get(word);
        }

        char[] wordArray = word.toCharArray();
        int len = wordArray.length;

        int max = 1;

        for (int i = 0; i < len; i++) {
            String tmp = word.substring(0, i) + word.substring(i + 1);
            if (ref.containsKey(tmp)) {
                int tmpResult = helper(tmp, ref);
                max = Math.max(max, tmpResult + 1);
            }
        }

        ref.put(word, max);

        return max;
    }
}
