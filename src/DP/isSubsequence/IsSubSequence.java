package DP.isSubsequence;

import java.util.*;

public class IsSubSequence {

    public static void main(String[] args) {
        IsSubSequence obj = new IsSubSequence();
        obj.isSubsequence("axc", "ahbgdc");
    }

    // If s is a subsequence of t
    public boolean isSubsequence(String s, String t) {
        char[] sArray = s.toCharArray();
        int sLen = sArray.length;
        char[] tArray = t.toCharArray();
        int tLen = tArray.length;

        if (sLen > tLen) {
            return false;
        }

        Map<Character, List<Integer>> counts = new HashMap<>();

        for (int i = 0; i < tLen; i++) {
            List<Integer> indexes;
            if (counts.containsKey(tArray[i])) {
                indexes = counts.get(tArray[i]);
            } else {
                indexes = new ArrayList<>();
            }
            indexes.add(i);
            counts.put(tArray[i], indexes);
        }

        int prevIndex = -1;
        for (int i = 0; i < sLen; i++) {
            if (counts.containsKey(sArray[i])) {
                List<Integer> indexes = counts.get(sArray[i]);
                Iterator<Integer> it = indexes.iterator();
                boolean found = false;
                while (it.hasNext()) {
                    int nextItem = it.next();
                    if (nextItem > prevIndex) {
                        prevIndex = nextItem;
                        found = true;
                        it.remove();
                        break;
                    }
                }

                if (!found) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }
}
