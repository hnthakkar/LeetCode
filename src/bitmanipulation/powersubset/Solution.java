package bitmanipulation.powersubset;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        int noOfCombinations = (int) Math.pow(2, len);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < noOfCombinations; i++) {
            List<Integer> curCombi = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                if ((i >> j & 1) == 1) {
                    curCombi.add(nums[j]);
                }
            }

            result.add(curCombi);
        }

        return result;
    }

}
