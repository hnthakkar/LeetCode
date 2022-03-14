package array.movezero283;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.moveZeroes(new int[]{4,2,4,0,0,3,0,5,1,0});
    }

    public void moveZeroes(int[] nums) {
        int len = nums.length;
        List<Integer> ref = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                ref.add(nums[i]);
                nums[i] = 0;
            }
        }

        for (int i = 0; i < ref.size(); i++) {
            nums[i] = ref.get(i);
        }
    }

    /*
    public void moveZeroes(int[] nums) {
        int len = nums.length;

        if (len <= 1) {
            return;
        }

        int nonZeroNumberCount = 0;

        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                if (nonZeroNumberCount != i) {
                    nums[nonZeroNumberCount] = nums[i];
                    nums[i] = 0;
                }
                nonZeroNumberCount++;
            }
        }
    }

     */

    /*
    public void moveZeroes(int[] nums) {
        int len = nums.length;

        int lastZeroIndex = 0;

        for (int i = 1; i < len; i++) {
            while (lastZeroIndex < i && nums[lastZeroIndex] != 0) {
                lastZeroIndex++;
            }

            if (nums[lastZeroIndex] == 0) {
                if (nums[i] != 0) {
                    nums[lastZeroIndex] = nums[i];
                    nums[i] = 0;
                }
            }
        }
    }

     */
}
