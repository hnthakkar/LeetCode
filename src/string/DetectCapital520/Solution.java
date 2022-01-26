package string.DetectCapital520;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.detectCapitalUse("USA");
    }

    public boolean detectCapitalUse(String word) {
        char[] wArray = word.toCharArray();
        int len = wArray.length;

        boolean result = true;
        int lastCapsIndex = -1;
        int lastSmallIndex = -1;

        for (int i = 0; i < len; i++) {
            if ('A' <= wArray[i] && wArray[i] <= 'Z') {
                if (lastSmallIndex >= 0) {
                    result = false;
                    break;
                }

                lastCapsIndex = i;
            } else {

                if (lastCapsIndex > 0) {
                    result = false;
                    break;
                }

                lastSmallIndex = i;
            }
        }

        return result;
    }
}
