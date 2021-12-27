package backtracking.combinationSum39;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        // sol.combinationSum(new int[]{2, 3, 6, 7}, 7);
        sol.combinationSum(new int[]{2, 3, 5}, 8);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            cur.add(candidates[i]);
            helper(result, cur, i, candidates[i], target, candidates, len);
            cur.remove(cur.size() - 1);
        }

        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> cur, int startIndex, int sum, int target, int[] candidates, int len) {
        if (sum == target) {
            result.add(new ArrayList<>(cur));
            return;
        }

        if (sum > target || startIndex >= len) {
            return;
        }

        cur.add(candidates[startIndex]);
        helper(result, cur, startIndex, sum + candidates[startIndex], target, candidates, len);
        cur.remove(cur.size() - 1);
        helper(result, cur, startIndex + 1, sum, target, candidates, len);
    }
}
