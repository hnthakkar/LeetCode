package array.NondecreasingArray665;

public class Solution {

    public boolean checkPossibility(int[] nums) {
        int len = nums.length;
        int invalidSeqCount = 0;

        for (int i = 0; i < (len - 1); i++) {
            if (nums[i] <= nums[i + 1]) {
                continue;
            }

            invalidSeqCount++;

            boolean check = i == 0 || nums[i + 1] >= nums[i - 1];

            if (check) {
                nums[i] = nums[i + 1];
            } else {
                nums[i + 1] = nums[i];
            }

            if (invalidSeqCount > 1) {
                return false;
            }
        }

        return true;
    }

}
