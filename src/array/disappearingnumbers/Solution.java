package array.disappearingnumbers;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] arg) {
        findDisappearedNumbers(new int[] {4,3,2,7,8,2,3,1});
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> output = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }

        for (int j = 0; j < len; j++) {
            if (nums[j] > 0) {
                output.add(j + 1);
            }
        }

        return output;
    }
}
