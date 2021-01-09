package binarysearch.findrange;

public class Solution {

    public static void main(String[] args) {
        Solution obj = new Solution();
        obj.searchRange(new int[]{0,0,1,2,2}, 2);
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }

        int targetIndex = findTarget(nums, target);
        if (targetIndex == -1) {
            return new int[] {-1, -1};
        }

        return getRange(nums, targetIndex);
    }

    private int[] getRange(int[] nums, int foundAt) {
        int target = nums[foundAt];
        int leftIndex = foundAt;
        int lastIndex = nums.length - 1;
        while (leftIndex >= 0 && nums[leftIndex] == target) {
            leftIndex--;
        }

        int rightIndex = foundAt;
        while (rightIndex <= lastIndex && nums[rightIndex] == target) {
            rightIndex++;
        }

        return new int[] {++leftIndex, --rightIndex};
    }

    private int findTarget(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        while (leftIndex + 1 < rightIndex) {
            int mid = leftIndex + (rightIndex -leftIndex)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                leftIndex = mid;
            } else {
                rightIndex = mid;
            }
        }

        if (nums[leftIndex] == target) {
            return leftIndex;
        }

        if (nums[rightIndex] == target) {
            return rightIndex;
        }

        return -1;
    }
}
