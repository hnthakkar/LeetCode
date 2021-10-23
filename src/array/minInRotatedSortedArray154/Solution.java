package array.minInRotatedSortedArray154;

public class Solution {
    public int findMin(int[] nums) {
        int startIndex = 0;
        int endIndex = nums.length - 1;

        return helper(startIndex, endIndex, nums);
    }

    private int helper(int startIndex, int endIndex, int[] nums) {
        if (startIndex == endIndex) {
            return nums[startIndex];
        }

        if (startIndex + 1 == endIndex) {
            return Math.min(nums[startIndex], nums[endIndex]);
        }

        int mid = startIndex + (endIndex - startIndex)/2;

        if (nums[startIndex] == nums[mid] && nums[mid] == nums[endIndex]) {
            return Math.min(helper(startIndex, mid - 1, nums), helper(mid + 1, endIndex, nums));
        }

        if (nums[startIndex] < nums[mid] && nums[mid] <= nums[endIndex]) {
            // already sorted
            return nums[startIndex];
        }

        if (nums[startIndex] > nums[mid]) {
            return helper(startIndex, mid, nums);
        } else {
            return helper(mid, endIndex,nums);
        }
    }

}
