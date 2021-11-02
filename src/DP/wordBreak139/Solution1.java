package DP.wordBreak139;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution1 {

    public static void main(String[] str) {
        Solution1 sol = new Solution1();
        List<String> dict = new ArrayList<>();
        dict.add("leet");
        dict.add("code");
        sol.wordBreak("leetcode", dict);
    }

    public boolean wordBreak(String s, List<String> dict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[len] = true;

        String curWord;
        int curWordlen = 0;

        for (int i = len - 1; i >= 0; i--) {
            curWord = s.substring(i);

            for (String dictWord: dict) {
                if (curWord.startsWith(dictWord) && dp[i + dictWord.length()]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }
}


/*
https://www.youtube.com/watch?v=Sx9NNgInc3A
 */