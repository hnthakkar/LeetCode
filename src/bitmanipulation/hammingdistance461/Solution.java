package bitmanipulation.hammingdistance461;

public class Solution {

    /*
    public int hammingDistance(int x, int y) {
        String number1AsString = String.format("%32s", Integer.toBinaryString(x)).replace(' ', '0');

        char[] number1CharArray = number1AsString.toCharArray();
        int len1 = number1CharArray.length;

        String number2AsString = String.format("%32s", Integer.toBinaryString(y)).replace(' ', '0');

        char[] number2CharArray = number2AsString.toCharArray();
        int len2 = number2CharArray.length;

        int counter = 0;
        int num1Index = 0;
        int num2Index = 0;
        while (num1Index < len1 && num2Index < len2) {
            if (number1CharArray[num1Index] != number2CharArray[num2Index]) {
                counter++;
            }
            num1Index++;
            num2Index++;
        }

        while (num1Index < len1) {
            counter++;
            num1Index++;
        }

        while (num2Index < len2) {
            counter++;
            num2Index++;
        }

        return counter;
    }

     */

    public int hammingDistance(int x, int y) {
        int counter = 0;

        for (int i = 0; i < 32; i++) {
            if (((x & 1) == 1 && (y & 1) == 0) || ((x & 1) == 0 && (y & 1) == 1)) {
                counter++;
            }

            x >>= 1;
            y >>= 1;
        }

        return counter;
    }

}
