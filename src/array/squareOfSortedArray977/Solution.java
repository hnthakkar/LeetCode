package array.squareOfSortedArray977;

public class Solution {

    public int[] sortedSquares(int[] nums) {
        int len = nums.length;

        int left = 0;
        int right = len - 1;


        int[] result = new int[len];
        int resultIndex = len - 1;

        while (left <= right) {
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                result[resultIndex--] = nums[right] * nums[right];
                right--;
            } else {
                result[resultIndex--] = nums[left] * nums[left];
                left++;
            }
        }

        return result;
    }

}
