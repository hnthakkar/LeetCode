package string.repeatedDNASeq;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.findRepeatedDnaSequences("AAAAAAAAAAA");
    }

    public List<String> findRepeatedDnaSequences(String s) {
        char[] sArray = s.toCharArray();
        int len = sArray.length;

        Map<String, Integer> repetitionCount = new HashMap<>();

        List<String> result = new ArrayList<>();

        for (int i = 0; i <= len - 10; i++) {
            String newElem = new String(sArray, i, 10);

            if (repetitionCount.containsKey(newElem)) {
                if (repetitionCount.get(newElem) == 0) {
                    result.add(newElem);
                    repetitionCount.put(newElem, 1);
                }
            } else {
                repetitionCount.put(newElem, 0);
            }
        }

        return result;
    }

}
