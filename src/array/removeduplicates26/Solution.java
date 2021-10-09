package array.removeduplicates26;

public class Solution {

    public int removeDuplicates(int[] nums) {
        int len = nums.length;

        if (len == 0 || len == 1) {
            return len;
        }

        int curIndex = 0;
        int newLen = 0;
        int nextUniqueIndex = 1;

        while (nextUniqueIndex < len) {
            while (nextUniqueIndex < len && nums[nextUniqueIndex] == nums[curIndex]) {
                nextUniqueIndex++;
            }

            if (nextUniqueIndex == len) {
                break;
            }

            nums[curIndex + 1] = nums[nextUniqueIndex];
            curIndex++;
            newLen++;
            nextUniqueIndex++;
        }

        return newLen + 1;
    }

}
