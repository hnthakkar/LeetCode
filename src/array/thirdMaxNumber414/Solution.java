package array.thirdMaxNumber414;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int thirdMax(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int lastMax = nums[len - 1];
        Set<Integer> unique = new HashSet<>();

        for (int i = len - 1; i >= 0; i--) {
            unique.add(nums[i]);
            lastMax = nums[i];
            if (unique.size() == 3) {
                break;
            }
        }

        return unique.size() == 3 ? lastMax : nums[len - 1];
    }
}
