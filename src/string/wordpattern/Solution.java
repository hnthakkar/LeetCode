package string.wordpattern;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.wordPattern("abba", "dog dog dog dog");
    }

    public boolean wordPattern(String pattern, String s) {
        char[] pArray = pattern.toCharArray();
        String[] sArray = s.split(" ");

        Map<Character, String> mapping = new HashMap<>();

        if (pArray.length != sArray.length) {
            return false;
        }

        for (int i = 0; i < pArray.length; i++) {
            if (mapping.containsKey(pArray[i])) {
                if (!mapping.get(pArray[i]).equals(sArray[i])) {
                    return false;
                }
            } else {
                if (!mapping.containsValue(sArray[i])) {
                    mapping.put(pArray[i], sArray[i]);
                } else {
                    return false;
                }
            }
        }

        return true;
    }

}
