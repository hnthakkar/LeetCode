package string.reversewordsinstring;

public class Solution {

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

}
