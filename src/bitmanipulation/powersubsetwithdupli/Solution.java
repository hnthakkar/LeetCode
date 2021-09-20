package bitmanipulation.powersubsetwithdupli;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.subsetsWithDup(new int[]{1,2,2});
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int noOfCombinations = (int) Math.pow(2, len);

        List<List<Integer>> result = new ArrayList<>();

        Set<String> uniqueCombi = new HashSet<>();

        for (int i = 0; i < noOfCombinations; i++) {
            List<Integer> curCombi = new ArrayList<>();
            String combi = "";
            for (int j = 0; j < len; j++) {
                if ((i >> j & 1) == 1) {
                    curCombi.add(nums[j]);
                    combi = combi + nums[j];
                }
            }

            if (!uniqueCombi.contains(combi)) {
                result.add(curCombi);
                uniqueCombi.add(combi);
            }

        }

        return result;
    }

}
