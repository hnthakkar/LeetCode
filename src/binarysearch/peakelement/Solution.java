package binarysearch.peakelement;

public class Solution {

    public static void main(String[] args) {
        Solution obj = new Solution();
        obj.findPeakElement(new int[] {1,2,3,1});
    }

    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        return findPeakElement(nums, 0, nums.length - 1);
    }

    private int findPeakElement(int[] nums, int startIndex, int endIndex) {
        if (startIndex < endIndex && nums[startIndex] > nums[startIndex + 1]) {
            return startIndex;
        }

        if (endIndex > startIndex && nums[endIndex] > nums[endIndex - 1]) {
            return endIndex;
        }

        int mid = startIndex + (endIndex - startIndex) / 2;

        if ((mid - 1) >= startIndex && nums[mid - 1] < nums[mid]
                && (mid + 1) <= endIndex && nums[mid + 1] < nums[mid]) {
            return mid;
        } else if ((mid - 1) >= startIndex && nums[mid - 1] > nums[mid]) {
            return findPeakElement(nums, startIndex, mid);
        } else {
            return findPeakElement(nums, mid, endIndex);
        }
    }

}
