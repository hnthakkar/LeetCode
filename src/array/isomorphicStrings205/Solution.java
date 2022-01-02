package array.isomorphicStrings205;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean isIsomorphic(String s, String t) {
        char[] sArray = s.toCharArray();
        int sLen = sArray.length;

        char[] tArray = t.toCharArray();
        int tLen = tArray.length;

        if (sLen != tLen) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < sLen; i++) {
            if (map.containsKey(sArray[i])) {
                if(map.get(sArray[i]) != tArray[i]) {
                    return false;
                }
            } else {
                if (map.containsValue(tArray[i])) {
                    return false;
                }

                map.put(sArray[i], tArray[i]);
            }
        }

        return true;
    }
}
