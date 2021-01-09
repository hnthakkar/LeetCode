package binarysearch.kclosest;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution obj = new Solution();
        obj.findClosestElements(new int[] {0,0,0,1,3,5,6,7,8,8}, 2, 2);
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int closestIndex = findTarget(arr, x);
        return getClosestElements(arr, closestIndex, k, x);
    }

    private List<Integer> getClosestElements(int [] nums, int closestIndex, int elementCounts, int target) {
        List<Integer> ret = new ArrayList<>();
        int lastIndex = nums.length - 1;
        int lowerSideIndex = closestIndex;
        int highSideIndex = closestIndex + 1;

        while (elementCounts > 0) {
            int lowerDiff = lowerSideIndex >= 0 ? Math.abs(target - nums[lowerSideIndex]) : Integer.MAX_VALUE;
            int higherDiff = highSideIndex <= lastIndex ? Math.abs(target - nums[highSideIndex]) : Integer.MAX_VALUE;

            if (lowerDiff <= higherDiff) {
                lowerSideIndex--;
            } else {
                highSideIndex++;
            }
            elementCounts--;
        }

        for (int i = lowerSideIndex + 1; i <= highSideIndex - 1; i++) {
            ret.add(nums[i]);
        }

        return ret;
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

        if (Math.abs(nums[leftIndex] - target) <= Math.abs(nums[rightIndex] - target)) {
            return leftIndex;
        } else {
            return rightIndex;
        }
    }
}
