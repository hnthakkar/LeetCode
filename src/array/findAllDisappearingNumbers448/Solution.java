package array.findAllDisappearingNumbers448;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;

        int[] freq = new int[len + 1];

        for (int num : nums) {
            freq[num] = 1;
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= len; i++) {
            if (freq[i] == 0) {
                result.add(i);
            }
        }

        return result;
    }

}
