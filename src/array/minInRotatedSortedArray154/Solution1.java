package array.minInRotatedSortedArray154;

public class Solution1 {

    public static void main(String[] args) {
        Solution1 sol = new Solution1();
        sol.findMin(new int[]{3,3,1,3});
    }

    public int findMin(int[] nums) {
        int startIndex = 0;
        int endIndex = nums.length - 1;

        int mid = 0;

        while (startIndex <= endIndex) {
            mid = startIndex + (endIndex - startIndex)/2;

            if (startIndex == mid || startIndex + 1 == endIndex) {
                mid = nums[startIndex] < nums[endIndex] ? startIndex : endIndex;
                break;
            }

            if (nums[mid] < nums[endIndex]) {
                endIndex = mid;
            } else if (nums[mid] > nums[endIndex]) {
                startIndex = mid + 1;
            } else {
                endIndex--;
            }
        }

        return nums[mid];
    }
}
