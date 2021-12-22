package virtualContest.weeklyContest269.four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target) {
                break;
            }

            if (nums[i] == target) {
                result.add(i);
            }
        }

        return result;
    }
}
