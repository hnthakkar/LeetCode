package backtracking.permutations2_47;

import java.util.*;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.permuteUnique(new int[]{2,2,1,1});
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> cur = new ArrayList<>();
        Set<Integer> indexSet = new HashSet<>();

        Arrays.sort(nums);

        helper(nums, result, cur, indexSet);

        List<List<Integer>> listResult = new ArrayList<>();
        listResult.addAll(result);

        return listResult;
    }

    private void helper(int[] nums, Set<List<Integer>> result, List<Integer> cur, Set<Integer> alreadyDoneIndexes) {
        if (cur.size() == nums.length) {
            result.add(new ArrayList(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (alreadyDoneIndexes.contains((Integer)i)) {
                continue;
            }

            cur.add(nums[i]);
            alreadyDoneIndexes.add(i);

            helper(nums, result, cur, alreadyDoneIndexes);

            cur.remove(cur.size() - 1);
            alreadyDoneIndexes.remove(i);
        }
    }
}
