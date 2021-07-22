package dailychallenge.partitionarray;

public class Solution {

    public int partitionDisjoint(int[] nums) {
        int len  = nums.length;

        int[] largestToLeft = new int[len];
        largestToLeft[0] = -1;
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            largestToLeft[i] = max;
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        int[] smallToRightIncludingSelf = new int[len];
        smallToRightIncludingSelf[len - 1] = nums[len -1];
        int min = smallToRightIncludingSelf[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] < min) {
                min = nums[i];
            }
            smallToRightIncludingSelf[i] = min;
        }

        int resultIndex = 0;

        for (int i = 1; i < len; i++) {
            if (nums[i] >= largestToLeft[i] && largestToLeft[i] <= smallToRightIncludingSelf[i]) {
                resultIndex = i;
                break;
            }
        }

        return resultIndex;
    }

}
