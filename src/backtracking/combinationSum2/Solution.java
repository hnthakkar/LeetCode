package backtracking.combinationSum2;

import java.util.*;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        helper(result, cur, 0, target, candidates, 0);

        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> cur, int sum, int target, int[] candidates, int startAt) {
        if (sum == target) {
            result.add(new ArrayList<>(cur));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = startAt; i < candidates.length; i++) {
            if (i > startAt && candidates[i-1] == candidates[i]) {
                continue;
            }

            cur.add(candidates[i]);
            helper(result, cur, sum + candidates[i], target, candidates, i + 1);
            cur.remove(cur.size() - 1);
        }
    }

}
