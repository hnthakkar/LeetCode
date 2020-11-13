package searchinrotatedsortedarray;

import sun.security.ssl.HandshakeInStream;

public class SearchInRotatedSortedArray {

    public int getIndex(int[] nums, int target) {
        return modifiedBinarySearch(nums, 0, nums.length - 1, target);
    }

    private int modifiedBinarySearch(int[] nums, int low, int high, int target) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high)/2;
        if (nums[mid] == target) {
            return mid;
        }

        if (nums[low] < nums[mid -1] && nums[low] <= target && nums[mid - 1] >= target) {
            return simpleBinarySearch(nums, low, mid - 1, target);
        } else if (nums[mid + 1] < nums[high] && nums[mid + 1] <= target && nums[high] >= target) {
            return simpleBinarySearch(nums, mid + 1, high, target);
        } else if (nums[low] <= target && nums[mid - 1] >= target) {
            return modifiedBinarySearch(nums, low, mid - 1, target);
        } else {
            return modifiedBinarySearch(nums, mid + 1, high, target);
        }
    }

    private int simpleBinarySearch(int[] nums, int low, int high, int target) {
        if (high < low) {
            return -1;
        }

        int mid = (low + high)/2;
        if (nums[mid] == target) {
            return mid;
        }

        if (target > nums[mid]) {
            return simpleBinarySearch(nums, mid + 1, high, target);
        } else {
            return simpleBinarySearch(nums, low, mid - 1, target);
        }
    }

}
