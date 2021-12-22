package string.minimumDeletionForUniqueFreq1647;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.minDeletions("aaabbbcc");
    }

    public int minDeletions(String s) {
        char[] sArray = s.toCharArray();
        int len = sArray.length;

        Map<Character, Integer> freq = new HashMap<>();

        for (int i = 0; i < len; i++) {
            if (freq.containsKey(sArray[i])) {
                freq.put(sArray[i], freq.get(sArray[i]) + 1);
            } else {
                freq.put(sArray[i], 1);
            }
        }

        int result = 0;
        Set<Integer> unique = new HashSet<>();

        for (Integer count: freq.values()) {
            while (unique.contains(count)) {
                if (count == 0) {
                    break;
                }

                result++;
                count--;
            }

            unique.add(count);
        }

        return result;
    }
}
