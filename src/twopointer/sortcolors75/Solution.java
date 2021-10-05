package twopointer.sortcolors75;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.sortColors(new int[] {0,1});
    }

    public void sortColors(int[] nums) {
        int len = nums.length;
        int fromIndex = 0;

        // sort zero
        int lastIndexPlusOne = sortNumber(nums, 0, 0, len);

        // sort one
        if (lastIndexPlusOne != -1) {
            sortNumber(nums, lastIndexPlusOne + 1, 1, len);
        } else {
            sortNumber(nums, 0, 1, len);
        }

    }

    private int sortNumber(int[] nums, int startIndex, int number, int len) {
        int lastReplacedIndex = -1;
        while (startIndex < len - 1 && nums[startIndex] == number) {
            lastReplacedIndex = startIndex++;
        }

        int endIndex = startIndex + 1;


        while (endIndex < len) {
            if (nums[startIndex] == number) {
                startIndex++;
                continue;
            }

            while (endIndex < len && nums[endIndex] != number) {
                endIndex++;
            }

            if (endIndex >= len) {
                break;
            }

            int tmp = nums[startIndex];
            nums[startIndex] = nums[endIndex];
            nums[endIndex] = tmp;
            lastReplacedIndex = startIndex;
            startIndex++;
        }

        return lastReplacedIndex;
    }
}
