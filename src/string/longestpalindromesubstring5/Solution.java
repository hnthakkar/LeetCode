package string.longestpalindromesubstring5;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.longestPalindrome("cbbd");
    }

    public String longestPalindrome(String s) {
        char[] sArray = s.toCharArray();
        int len = sArray.length;

        int max = 0;
        int globalMaxStart = 0;
        int globalMaxEnd = 0;

        for (int i = 0; i < len; i++) {
            int odd = checkForPalinWithMid(sArray, i, i, len);
            int even = checkForPalinWithMid(sArray, i, i + 1, len);

            int localMax;
            int localStart;
            int localEnd;

            if (odd > even) {
                localMax = odd;
                localStart = i - (localMax - 1)/2;
                localEnd = i + (localMax - 1)/2;
            } else {
                localMax = even;
                localStart = i - (localMax/2 - 1);
                localEnd = i + localMax/2;
            }

            if (localMax > max) {
                max = localMax;
                globalMaxStart = localStart;
                globalMaxEnd = localEnd;
            }
        }

        return s.substring(globalMaxStart, globalMaxEnd + 1);
    }

    private int checkForPalinWithMid(char[] sArray, int leftIndex, int rightIndex, int len) {
        int counter = 0;

        while (leftIndex >= 0 && rightIndex < len && sArray[leftIndex] == sArray[rightIndex]) {
            if (leftIndex == rightIndex) {
                counter++;
            } else {
                counter += 2;
            }
            leftIndex--;
            rightIndex++;
        }

        return counter;
    }
}
