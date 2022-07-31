package string.FindandReplacePattern890;

import java.util.*;

public class Solution {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        char[] ref = pattern.toCharArray();
        int pLen = ref.length;

        List<String> result = new ArrayList<>();

        for (String w: words) {
            if (matches(w, ref, pLen)) {
                result.add(w);
            }
        }

        return result;
    }

    private boolean matches(String w, char[] ref, int len) {
        char[] wArray = w.toCharArray();
        int wLen = wArray.length;

        if (wLen != len) {
            return false;
        }

        Map<Character, Character> mapping = new HashMap<>();

        for (int i = 0; i < wLen; i++) {
            char curChar = wArray[i];
            char refChar = ref[i];

            if (mapping.containsKey(curChar)) {
                if (mapping.get(curChar) != refChar) {
                    return false;
                }
            } else {
                if (mapping.containsValue(refChar)) {
                    return false;
                }

                mapping.put(curChar, refChar);
            }
        }

        return true;
    }

}
