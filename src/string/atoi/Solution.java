package string.atoi;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.myAtoi("-91283472332");
    }

    public int myAtoi(String s) {
        char[] sArray = s.toCharArray();
        int len = sArray.length;

        int number = 0;

        boolean isNegative = false;
        int currentIndex = 0;

        while (sArray[currentIndex] == ' ') {
            currentIndex++;
        }

        if(sArray[currentIndex] == '-') {
            isNegative = true;
            currentIndex++;
        } else if (sArray[currentIndex] == '+') {
            currentIndex++;
        }

        boolean maxOut = false;
        if (sArray[currentIndex] >= 48 && sArray[currentIndex] <= 57) {
            while (currentIndex < len && sArray[currentIndex] >= 48 && sArray[currentIndex] <= 57) {
                if (((long)number * 10 + (sArray[currentIndex] - '0')) > Integer.MAX_VALUE) {
                    maxOut = true;
                    break;
                } else {
                    number = number * 10 + (sArray[currentIndex] - '0');
                }
                currentIndex++;
            }
        }

        if (isNegative) {
            number *= -1;
        }

        if (maxOut) {
            if (isNegative) {
                number = Integer.MIN_VALUE;
            } else {
                number = Integer.MAX_VALUE;
            }
        }

        return number;
    }
}
