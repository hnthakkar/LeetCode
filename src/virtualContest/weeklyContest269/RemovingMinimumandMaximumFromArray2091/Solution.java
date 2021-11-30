package virtualContest.weeklyContest269.RemovingMinimumandMaximumFromArray2091;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        // sol.minimumDeletions(new int[]{-1,-53,93,-42,37,94,97,82,46,42,-99,56,-76,-66,-67,-13,10,66,85,-28});
        sol.minimumDeletions(new int[]{72956,-44432,78333,31358,-96449,-24776});
    }

    public int minimumDeletions(int[] nums) {
        int len = nums.length;

        int minNumber = nums[0];
        int maxNumber = nums[0];

        for (int n: nums) {
            minNumber = Math.min(minNumber, n);
            maxNumber = Math.max(maxNumber, n);
        }

        int alreadyDeletedFromFront = 0;
        int alreadyDeletedFromEnd = 0;

        for (int i = 0; i < len; i++) {
            if (nums[i] == minNumber || nums[i] == maxNumber) {
                if (i + 1 - alreadyDeletedFromFront < len - i - alreadyDeletedFromEnd) {
                    alreadyDeletedFromFront = i + 1;
                } else {
                    alreadyDeletedFromEnd = len - i;
                    break;
                }
            }
        }

        int leftToRightCount = alreadyDeletedFromFront + alreadyDeletedFromEnd;

        alreadyDeletedFromFront = 0;
        alreadyDeletedFromEnd = 0;

        for (int i = len - 1; i >= 0; i--) {
            if (nums[i] == minNumber || nums[i] == maxNumber) {
                if (i + 1 - alreadyDeletedFromFront < len - i - alreadyDeletedFromEnd) {
                    alreadyDeletedFromFront = i + 1;
                    break;
                } else {
                    alreadyDeletedFromEnd = len - i;
                }
            }
        }

        int rightToLeftCount = alreadyDeletedFromFront + alreadyDeletedFromEnd;

        return Math.min(leftToRightCount, rightToLeftCount);
    }
}
