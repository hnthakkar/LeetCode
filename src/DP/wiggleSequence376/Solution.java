package DP.wiggleSequence376;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.wiggleMaxLength(new int[]{1,7,4,9,2,5});
    }

    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;

        if (len == 1) {
            return 1;
        }

        if (len == 2) {
            if (nums[0] == nums[1]) {
                return 1;
            }

            return len;
        }

        int[] up = new int[len];
        int[] down = new int[len];

        up[0] = 1;
        down[0] = 1;

        for (int i = 1; i < len; i++) {
            if (nums[i] < nums[i - 1]) {
                up[i] = up[i - 1];
                down[i] = up[i - 1] + 1;
            } else if (nums[i] > nums[i - 1]) {
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
            } else {
                up[i] = up[i -1];
                down[i] = down[i - 1];
            }
        }

        return Math.max(up[len - 1], down[len - 1]);
    }
}

/*
[1,7,4,9,2,5]
[1,17,5,10,13,15,10,5,16,8]
[1,2,3,4,5,6,7,8,9]
 */