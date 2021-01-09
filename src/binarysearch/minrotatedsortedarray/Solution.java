package binarysearch.minrotatedsortedarray;

public class Solution {

    public static void main(String[] args) {
        Solution obj = new Solution();
        System.out.println(obj.findMin(new int[]{11,13,15,17}));
    }

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return findPivot(nums, 0, nums.length - 1);
    }

    private int findPivot(int[] nums, int startIndex, int endIndex) {
        if (endIndex == (startIndex + 1) && nums[startIndex] > nums[endIndex]) {
            return nums[endIndex];
        }

        int mid = startIndex + (endIndex - startIndex)/2;

        if (nums[startIndex] > nums[mid]) {
            return findPivot(nums, startIndex, mid);
        } else if (nums[mid] > nums[endIndex]) {
            return findPivot(nums, mid, endIndex);
        } else {
            // all sorted
            return nums[startIndex];
        }
    }
}
