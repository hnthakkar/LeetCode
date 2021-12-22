package array.searchInRotatedSortedArray33;

public class Solution {

    public int search(int[] nums, int target) {
        int len = nums.length;

        int left = 0;
        int right = len - 1;

        while (left <= right) {
            if (nums[left] == target) {
                return left;
            }

            if (nums[right] == target) {
                return right;
            }

            if (left + 1 == right) {
                return -1;
            }

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target && target < nums[right]) {
                left = mid + 1;
            } else if (nums[left] < target && target < nums[mid]) {
                right = mid - 1;
            } else {
                left = left + 1;
                right = right - 1;
            }
        }

        return -1;
    }

}
