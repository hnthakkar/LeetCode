package backtracking.maxlenconcstringuniq1239;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<String> input = new ArrayList<>();
        input.add("un");
        input.add("iquu");
        input.add("ue");
        sol.maxLength(input);
    }

    public int maxLength(List<String> arr) {
        int len = arr.size();

        List<Set<String>> freqMaps = new ArrayList<>();

        for (String input: arr) {
            freqMaps.add(getFreqMap(input));
        }

        int combinations = (int) Math.pow(2, len);
        int globalMaxLen = 0;

        for (int i = 0; i < combinations; i++) {
            Set<String> curCombSet = new HashSet<>();
            int independentSum = 0;
            for (int j = 0; j < len; j++) {
                if ((i >> j & 1) == 1)  {
                    if (freqMaps.get(j) == null) {
                        independentSum = 0;
                        break;
                    }

                    independentSum += freqMaps.get(j).size();
                    curCombSet.addAll(freqMaps.get(j));
                }
            }

            if (independentSum == curCombSet.size()) {
                globalMaxLen = Math.max(globalMaxLen, curCombSet.size());
            }
        }

        return globalMaxLen;
    }

    private Set<String> getFreqMap(String s) {
        char[] sArray = s.toCharArray();
        Set<String> uniqueChars = new HashSet<>();

        for (char ch: sArray) {
            if (uniqueChars.contains(ch + "")) {
                return null;
            }
            uniqueChars.add(ch + "");
        }

        return uniqueChars;
    }

}
