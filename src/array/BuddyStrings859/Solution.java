package array.BuddyStrings859;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.buddyStrings("ab", "ba");
    }

    public boolean buddyStrings(String s, String goal) {
        char[] sArray = s.toCharArray();
        int sLen = sArray.length;

        char[] gArray = goal.toCharArray();
        int gLen = gArray.length;

        if (sLen != gLen) {
            return false;
        }

        Map<Character, Integer> ref = new HashMap<>();

        for (int i = 0; i < sLen; i++) {
            ref.put(sArray[i], i);
        }

        int diffFound = -1;

        for (int i = 0; i < gLen; i++) {
            if (sArray[i] == gArray[i] || diffFound == i) {
                continue;
            }

            if (diffFound != -1) {
                return false;
            }

            diffFound = ref.get(gArray[i]);

            if (!ref.containsKey(gArray[i]) || sArray[i] != gArray[diffFound]) {
                return false;
            }
        }

        return true;
    }
}
