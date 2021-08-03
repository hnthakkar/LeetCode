package array.twoSum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        TwoSum obj = new TwoSum();
        obj.twoSum(new int[]{3, 2, 4}, 6);
    }

    public int[] twoSum(int[] nums, int target) {
        int[] ret = null;
        int len = nums.length;
        Map<Integer, Integer> indiciesMap = new HashMap<>();

        for (int i = 0; i < len; i++) {
            indiciesMap.put(nums[i], i);
        }

        for (int i = 0; i < len; i++) {
            if (indiciesMap.containsKey(target - nums[i]) && i != indiciesMap.get(target - nums[i])) {
                ret = new int[] {i, indiciesMap.get(target - nums[i])};
                break;
            }
        }

        return ret;
    }

}
