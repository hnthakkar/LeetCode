package array.searchInRotatedArray;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.search(new int[] {8,9,2,3,4}, 9);
    }

    public int search(int[] nums, int target) {
        int pivotIndex = getPivotElemIndex(nums);
        System.out.println("Pivot : " + pivotIndex);

        if (nums[pivotIndex] == target) {
            return pivotIndex;
        }

        if (nums[0] <= target && target <= nums[pivotIndex]) {
            return binarySearch(nums, target, 0, pivotIndex);
        } else {
            System.out.println("R");
            return binarySearch(nums, target, pivotIndex + 1, nums.length - 1);
        }
    }

    private int binarySearch(int[] nums, int target, int startIndex, int endIndex) {
        System.out.println("StartIndex :" + startIndex + " EndIndex : " + endIndex);
        while(startIndex <= endIndex) {
            int mid = startIndex + (endIndex - startIndex)/2;
            System.out.println("Mid :" + mid + " Value : " + nums[mid]);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                startIndex = mid + 1;
            } else {
                endIndex = mid - 1;
            }
        }

        return -1;
    }

    private int getPivotElemIndex(int[] nums) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        while (leftIndex <= rightIndex) {
            int mid = leftIndex + (rightIndex - leftIndex)/2;

            if ((mid + 1) <= rightIndex && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            if (nums[leftIndex] < nums[mid]) {
                leftIndex = mid + 1;
            } else {
                rightIndex = mid - 1;
            }
        }

        return leftIndex;
    }
}
