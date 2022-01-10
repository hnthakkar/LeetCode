package virtualContest.weeklyContest272.FindFirstPalindromicStringintheArray2108;

public class Solution {

    public String firstPalindrome(String[] words) {
        int len = words.length;

        for (int i = 0; i < len; i++) {
            if (checkIfPalin(words[i])) {
                return words[i];
            }
        }

        return "";
    }

    private boolean checkIfPalin(String str) {
        char[] sArray = str.toCharArray();

        int left = 0;
        int right = sArray.length - 1;

        while (left < right) {
            if (sArray[left] != sArray[right]) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
