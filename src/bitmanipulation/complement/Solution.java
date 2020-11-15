package bitmanipulation.complement;

public class Solution {

    public static void main(String[] args) {
        findComplement2(5);
    }

    public static int findComplement2(int num)
    {
        int i = 0;
        int j = 0;

        while (i < num)
        {
            i += Math.pow(2, j);
            j++;
        }

        return i - num;
    }

    public static int findComplement(int num) {
        int[] inputBinary = getBinaryRepresentation(num);
        int[] outputBinary = new int[inputBinary.length];

        for (int i = 0; i < inputBinary.length; i++) {
            outputBinary[i] = Math.abs(inputBinary[i] - 1);
        }

        return convertBinaryToNumber(outputBinary, inputBinary.length);
    }

    private static int[] getBinaryRepresentation(int num) {
        int size = getBinaryRepSize(num);
        int[] binary = new int[size];

        int index = 0;
        while(num > 0) {
            binary[index++] = num % 2;
            num /= 2;
        }

        return binary;
    }

    private static int getBinaryRepSize(int num) {
        int counter = 0;

        while (num > 0) {
            counter++;
            num /= 2;
        }

        return counter;
    }

    private static int convertBinaryToNumber(int[] binary, int size) {
        int number = 0;
        for (int i = 0; i < size; i++) {
            if (binary[i] == 1) {
                number += binary[i] * Math.pow(2, i);
            }
        }

        return number;
    }
}
