package bitmanipulation.bitcounting;

public class BitCounting {

    public static void main(String[] args) {
        int[] result = countBits(0);
        return;
    }

    public static int[] countBits(int num) {
        if (num == 0) {
            int[] ret = new int[1];
            ret[0] = 0;
            return ret;
        }

        int bitsNeeded = 0;
        int tmp = num;
        while (tmp > 0) {
            tmp /= 2;
            bitsNeeded++;
        }

        int[] binary = new int[bitsNeeded + 1];
        int[] result = new int[num + 1];

        for (int i = 0; i <= num; i++) {
            result[i] = countOnes(binary, bitsNeeded);
            addOne(binary, bitsNeeded);
        }

        return result;
    }

    private static void addOne(int[] nums, int size) {
        int firstZero = 0;
        while(nums[firstZero] == 1) {
            firstZero++;
        }

        nums[firstZero--] = 1;

        while(firstZero >= 0) {
            nums[firstZero--] = 0;
        }
    }

    private static int countOnes(int[] nums, int size) {
        int counter = 0;
        for (int i = 0; i < size; i++ ) {
            if(nums[i] == 1) {
                counter++;
            }
        }

        return counter;
    }
}
