package string.implementstrstr28;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.strStr("hello", "ll");
    }

    public int strStr(String haystack, String needle) {
        if ("".equals(needle) || needle == null) {
            return 0;
        }

        if ("".equals(haystack) || haystack == null) {
            return -1;
        }

        char[] hArray = haystack.toCharArray();
        int hLen = hArray.length;

        char[] nArray = needle.toCharArray();
        int nLen = nArray.length;

        int index = -1;

        boolean found = false;

        for (int i = 0; i < hLen; i++) {
            if (hArray[i] == nArray[0]) {
                for (int j = 0; j < nLen; j++) {
                    if ((i + j) < hLen && hArray[i + j] == nArray[j]) {
                        if (j == nLen - 1) {
                            found = true;
                        }
                        continue;
                    }
                    break;
                }

                if (found) {
                    index = i;
                    break;
                }
            }
        }

        return index;
    }
}
