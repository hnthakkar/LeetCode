package string.longestcommonprefix;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.longestCommonPrefix(new String[]{"flower","flow","flight"});
    }

    public String longestCommonPrefix(String[] strs) {
        int lenOfStringArray = strs.length;

        int minLen = Integer.MAX_VALUE;
        int[] lens = new int[lenOfStringArray];
        for (int i = 0; i < lenOfStringArray; i++) {
            lens[i] = strs[i].length();
            if (lens[i] < minLen) {
                minLen = lens[i];
            }
        }

        int currentIndex = 0;
        boolean diffFound = false;
        while (currentIndex < minLen) {
            char currentChar = strs[0].charAt(currentIndex);
            for (int i = 1; i < lenOfStringArray; i++) {
                if (strs[i].charAt(currentIndex) == currentChar) {
                    continue;
                }
                diffFound = true;
                break;
            }

            if (diffFound) {
                break;
            }
            currentIndex++;
        }


        return strs[0].substring(0, currentIndex);
    }
}
