package array.minInRotatedSortedArray153;

public class Solution {

    public int findMin(int[] nums) {
        int len = nums.length;

        int left = 0;
        int right = len - 1;

        while (left < right) {
            if (left + 1 == right) {
                return Math.min(nums[left], nums[right]);
            }

            int mid = left + (right - left)/2;

            if (nums[left] < nums[mid] && nums[mid] < nums[right]) {
                break;
            }

            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return nums[left];
    }

}
