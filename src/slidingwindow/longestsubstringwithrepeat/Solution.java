package slidingwindow.longestsubstringwithrepeat;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.lengthOfLongestSubstring("pwwkew");
    }

    public int lengthOfLongestSubstring(String s) {
        char[] sArray = s.toCharArray();
        int len = sArray.length;

        if (len == 0) {
            return 0;
        }

        int maxLength = 0;
        Set<Character> unique = new HashSet<>();

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (unique.contains(sArray[j])) {
                    unique.clear();
                    break;
                }

                unique.add(sArray[j]);
                maxLength = Math.max(maxLength, i == 0? j - i + 1: j - i + 1);
            }
        }

        return maxLength;
    }

    /*
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

     */
}
