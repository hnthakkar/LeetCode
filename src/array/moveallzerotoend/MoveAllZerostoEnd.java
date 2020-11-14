package array.moveallzerotoend;

public class MoveAllZerostoEnd {

    public static void main(String[] args) {
        moveAllZerosToEnd(new int[]{0, 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9});
    }

    public static void moveAllZerosToEnd(int[] nums) {
        int noOfNonZeroNumbers = 0;
        int tmp;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                tmp = nums[noOfNonZeroNumbers];
                nums[noOfNonZeroNumbers] = nums[i];
                nums[i] = tmp;
                noOfNonZeroNumbers++;
            }
        }

        return;
    }
}
