package rotatearray;

public class RotateArrayReverse {

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverseArray(nums, 0, nums.length - 1);
        reverseArray(nums, 0, k-1);
        reverseArray(nums, k, nums.length - 1);
    }

    private void reverseArray(int[] num, int startIndex, int endIndex) {
        int tmp;
        while (startIndex < endIndex) {
            tmp = num[endIndex];
            num[endIndex] = num[startIndex];
            num[startIndex] = tmp;
            startIndex++;
            endIndex--;
        }
    }
}
