package binarysearch.simple;

public class Solution {

    public static void main(String[] args) {
        Solution obj = new Solution();
        obj.search(new int[] {-1,0,3,5,9,12}, 9);
    }

    public int search(int[] nums, int target) {
        return checkInRange(nums, 0, nums.length - 1, target);
    }

    private int checkInRange(int[] nums, int startIndex, int endIndex, int target) {
        if (startIndex > endIndex) {
            return -1;
        }

        int mid = (startIndex + endIndex)/2;

        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return checkInRange(nums, startIndex, mid - 1, target);
        } else {
            return checkInRange(nums, mid + 1, endIndex, target);
        }
    }
}