package slidingwindow.longestsubstringwithrepeat;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        char[] sArray = s.toCharArray();
        int len = sArray.length;

        int maxLength = 0;
        int counter = 0;
        int leftIndex = 0;
        int rightIndex = 0;

        Map<Character, Integer> unique = new HashMap<>();

        while (rightIndex < len) {
            if (!unique.containsKey(sArray[rightIndex])) {
                unique.put(sArray[rightIndex], rightIndex);
                rightIndex++;
                counter++;
                if (counter > maxLength) {
                    maxLength = counter;
                }
            } else {
                leftIndex = unique.get(sArray[rightIndex]) + 1;
                rightIndex = leftIndex;
                unique.clear();
                counter = 0;
            }
        }

        return maxLength;
    }
}
