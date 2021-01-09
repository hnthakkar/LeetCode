package binarysearch.searchrotatedarray;

public class Solution {

    public static void main(String[] args) {
        Solution obj = new Solution();
        System.out.println(obj.searchInRotatedArray(new int[]{3,1}, 1));
    }

    public int searchInRotatedArray(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int pivot = findPivot(nums, 0, nums.length - 1, target);
        if (pivot == -1) {
            return simpleBinarySearch(nums, 0, nums.length -1, target);
        } else if (targetWithinRange(nums, 0, pivot, target)) {
            return simpleBinarySearch(nums, 0, pivot, target);
        } else {
            return simpleBinarySearch(nums, pivot, nums.length - 1, target);
        }
    }

    private int findPivot(int[] nums, int startIndex, int endIndex, int target) {
        if (endIndex == (startIndex + 1) && nums[startIndex] > nums[endIndex]) {
            return startIndex;
        }

        int mid = startIndex + (endIndex - startIndex)/2;

        if (nums[startIndex] > nums[mid]) {
            return findPivot(nums, startIndex, mid, target);
        } else if (nums[mid] > nums[endIndex]) {
            return findPivot(nums, mid, endIndex, target);
        } else {
            // all sorted
            return -1;
        }

    }

    private boolean targetWithinRange(int[] nums, int startIndex, int endIndex, int target) {
        if (startIndex < endIndex && nums[startIndex] <= target && nums[endIndex] >= target) {
            return true;
        }
        return false;
    }

    private int simpleBinarySearch(int[] nums, int startIndex, int endIndex, int target) {
        if (startIndex > endIndex) {
            return -1;
        }

        if (nums[startIndex] == target) {
            return startIndex;
        }

        if (nums[endIndex] == target) {
            return endIndex;
        }

        int mid = startIndex + (endIndex - startIndex)/2;

        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return simpleBinarySearch(nums, startIndex, mid - 1, target);
        } else {
            return simpleBinarySearch(nums, mid + 1, endIndex, target);
        }
    }
}
