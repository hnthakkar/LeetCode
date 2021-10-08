package string.longestpalin409;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int longestPalindrome(String s) {
        char[] sArray = s.toCharArray();
        int len = sArray.length;

        Map<Character, Integer> freqMap = new HashMap<>();

        for (char ch: sArray) {
            if (freqMap.containsKey(ch)) {
                freqMap.put(ch, freqMap.get(ch) + 1);
            } else {
                freqMap.put(ch, 1);
            }
        }

        int counter = 0;
        boolean hasOdd = false;

        for (int count: freqMap.values()) {
            if (count % 2 == 0) {
                counter += count;
            } else {
                if (count > 1) {
                    counter += (count - 1);
                }

                hasOdd = true;
            }
        }

        if (hasOdd) {
            counter += 1;
        }

        return counter;
    }

}
