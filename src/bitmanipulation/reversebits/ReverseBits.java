package bitmanipulation.reversebits;

public class ReverseBits {

    public static void main(String[] args) {
        ReverseBits sol = new ReverseBits();
        sol.reverseBits(0b11111111111111111111111111111101);
        // reverseBits(0b11111111111111111111111111111101);
    }

    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1) | (n & 1);
            n = n >> 1;
        }
        return res;
    }

    /*

    public static int reverseBits(int n) {
        String numberAsString = String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0');

        char[] numberCharArray = numberAsString.toCharArray();

        int leftIndex = 0;
        int rightIndex = numberCharArray.length - 1;
        char tmp;
        while (leftIndex < rightIndex) {
            tmp = numberCharArray[rightIndex];
            numberCharArray[rightIndex] = numberCharArray[leftIndex];
            numberCharArray[leftIndex] = tmp;
            leftIndex++;
            rightIndex--;
        }

        StringBuffer reverseString = new StringBuffer();
        for (char ch: numberCharArray) {
            reverseString.append(ch);
        }

        return (int) Long.parseLong(reverseString.toString(), 2);
        //return Integer.parseInt(reverseString.toString(), 2);
    }

    public static int reverseBitsUsingShift(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n >>>= 1;
            if (i < 31)
                result <<= 1;
        }
        return result;
    }

     */
}
