package string.reversewordsinstring;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.reverseWords("Let's take LeetCode contest");
    }

    public String reverseWords(String s) {
        char[] sArray = s.toCharArray();
        int sLen = sArray.length;

        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < sLen) {
            while (rightIndex < sLen && sArray[rightIndex] != ' ') {
                rightIndex++;
            }

            rightIndex--;

            reverse(sArray, leftIndex, rightIndex);

            rightIndex += 2;
            leftIndex = rightIndex;
        }

        return new String(sArray);
    }

    public void reverse(char[] s, int leftIndex, int rightIndex) {
        char tmp;
        while (leftIndex < rightIndex) {
            tmp = s[rightIndex];
            s[rightIndex] = s[leftIndex];
            s[leftIndex] = tmp;
            leftIndex++;
            rightIndex--;
        }
    }

    /*
    public String reverseWords(String s) {
        String[] sSplit = s.split(" ");
        int noOfWords = sSplit.length;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < noOfWords; i++) {
            char[] sSplitArray = sSplit[i].toCharArray();
            int lenOfCurrentWord = sSplitArray.length;
            for (int j = lenOfCurrentWord - 1; j >= 0; j--) {
                sb.append(sSplitArray[j]);
            }
            if (i + 1 != noOfWords) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

     */

}
