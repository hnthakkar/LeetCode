package DP.decodeways;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.numDecodings("8923420"); //"22202202" "22202222202" "222211108723241108923420356111110964591203415968543222111874"
    }

    public int numDecodings(String s) {
        char[] sArray = s.toCharArray();

        if (sArray[0] == '0') {
            return 0;
        }

        int len = sArray.length;

        int combinations = 1;
        int currentIndex = 0;

        while (currentIndex < len) {
            if (sArray[currentIndex] >= 51 && sArray[currentIndex] <= 57) {
                currentIndex++;
                continue;
            }

            // If its a zero validate
            if (sArray[currentIndex] == '0' && !(sArray[currentIndex - 1] == '1' || sArray[currentIndex - 1] == '2')) {
                return 0;
            }

            int counter = 1;
            currentIndex++;
            while (currentIndex < len) {
                if (sArray[currentIndex] == '1' || sArray[currentIndex] == '2') {
                    currentIndex++;
                    counter++;
                    continue;
                }
                break;
            }

            if (currentIndex < len) {
                if (sArray[currentIndex] == '0') {
                    if (!(sArray[currentIndex - 1] == '1' || sArray[currentIndex - 1] == '2')) {
                        return 0;
                    }
                    counter -= 1;
                } else if ((sArray[currentIndex - 1] == '1' && sArray[currentIndex] >= 51) || (sArray[currentIndex - 1] == '2' && sArray[currentIndex] <= 54)) {
                    counter++;
                }
            }

            combinations *= getPossibleCombination(counter);
            counter = 1;
            currentIndex++;
        }

        return combinations;
    }

    private int getPossibleCombination(int digits) {
        if (digits == 0 || digits == 1) {
            return 1;
        }

        if (digits == 2) {
            return 2;
        }

        int t1 = 1;
        int t2 = 2;
        int tmp = 0;
        while (digits - 2 > 0) {
            tmp = t1 + t2;
            t1 = t2;
            t2 = tmp;
            digits--;
        }

        return t2;
    }
}
