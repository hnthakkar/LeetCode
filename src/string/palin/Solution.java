package string.palin;

public class Solution {
    public boolean isPalindrome(int x) {
        char[] xArray = ("" + x).toCharArray();
        int len = xArray.length;

        int leftIndex = 0;
        int rightIndex = len - 1;

        while (leftIndex <= rightIndex) {
            if (xArray[leftIndex] == xArray[rightIndex]) {
                leftIndex++;
                rightIndex--;
                continue;
            }

            return false;
        }

        return true;
    }
}
