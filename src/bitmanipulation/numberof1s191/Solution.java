package bitmanipulation.numberof1s191;

public class Solution {

    public int hammingWeight(int n) {
        String numberAsString = String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0');

        char[] numberCharArray = numberAsString.toCharArray();
        int len = numberCharArray.length;

        int counter = 0;

        for (char ch: numberCharArray) {
            if (ch == '1') {
                counter++;
            }
        }

        return counter;
    }

}
