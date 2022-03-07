package string.CheckifOneStringSwapCanMakeStringsEqual1790;

public class Solution {

    public boolean areAlmostEqual(String s1, String s2) {
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();

        int s1Len = s1Array.length;
        int s2Len = s2Array.length;

        if (s1Len != s2Len) {
            return false;
        }

        char s1Ref = '\u0000', s2Ref = '\u0000';
        int diffCharCount = 0;

        for (int i = 0; i < s1Len; i++) {
            if (s1Array[i] != s2Array[i]) {
                if (diffCharCount < 2) {
                    if (diffCharCount == 1) {
                        if (s1Ref != s2Array[i] || s2Ref != s1Array[i]) {
                            return false;
                        }
                    } else {
                        s1Ref = s1Array[i];
                        s2Ref = s2Array[i];
                    }

                    diffCharCount++;
                } else {
                    return false;
                }
            }
        }

        return diffCharCount != 1;
    }

}
