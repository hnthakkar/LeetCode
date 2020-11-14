package array.rotatearray;

public class RotateArray {

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        for (int i = 0; i < k; i++) {
            rotateOnce(nums, len);
        }
    }

    private void rotateOnce(int[] nums, int len) {
        int tmp = nums[len - 1];
        int index = len - 2;

        while (index >= 0) {
            nums[index + 1] = nums[index];
            index--;
        }
        // pass by reference
        nums[0] = tmp;
    }
}
