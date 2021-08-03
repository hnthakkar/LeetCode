package array.powersetwithduplicates;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution obj = new Solution();
        obj.subsetsWithDup(new int[]{0,1,2});
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);

        int powerSetEntries = (int) Math.pow(2, len);
        Set<String> uniqueSet = new HashSet<>();

        List<List<Integer>> ret = new ArrayList<>();
        ret.add(new ArrayList<>());
        uniqueSet.add("");

        for (int i = 0; i < powerSetEntries; i++) {
            String uniqueCheck = "";
            List<Integer> toBeAdded = new ArrayList<>();
            boolean isNotBlank = false;
            for (int j = 0; j < len; j++) {
                if ((i > j) && ((i >> j) & 1) == 1) {
                    toBeAdded.add(nums[j]);
                    uniqueCheck +=  nums[j];
                    isNotBlank = true;
                }
            }

            if (isNotBlank && !uniqueSet.contains(uniqueCheck)) {
                ret.add(toBeAdded);
                uniqueSet.add(uniqueCheck);
            }
        }

        return ret;
    }

}
