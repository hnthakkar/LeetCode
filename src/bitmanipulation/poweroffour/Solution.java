package bitmanipulation.poweroffour;

public class Solution {

    public boolean isPowerOfFour(int num) {

        return (num > 0)
                && ((num & (num - 1)) == 0)  // Only one bit is set
                && ((num & 0x55555555) == num); // since power of four is needed, set bit shud be at odd position
        /*
        int test = 1;
        while (n >= test) {
            if ((n & test) == n) {
                return true;
            }
            test = test << 2;
        }

        return false;
        */
    }

    /*
    private int[] getBinaryRepresentation(int num) {
        int binaryLength = getLengthOfBinary(num);
        int[] binary = new int[binaryLength];

        for (int i = 0; i) {

        }
    }

    private int getLengthOfBinary(int n) {
        int counter = 0;

        while (n > 0) {
            n /= 2;
            counter++;
        }

        return counter;
    } */
}
