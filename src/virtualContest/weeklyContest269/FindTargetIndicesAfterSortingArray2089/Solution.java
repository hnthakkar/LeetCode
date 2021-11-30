package virtualContest.weeklyContest269.FindTargetIndicesAfterSortingArray2089;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> result = new ArrayList<>();

        int smallerItemsCount = 0;
        int occurences = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < target) {
                smallerItemsCount++;
                continue;
            }

            if (nums[i] == target) {
                occurences++;
            }
        }

        while (occurences > 0) {
            result.add(smallerItemsCount++);
            occurences--;
        }

        return result;
    }

     /*
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
    */
}
