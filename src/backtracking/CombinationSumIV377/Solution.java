package backtracking.CombinationSumIV377;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.combinationSum4(new int[]{1, 2, 3}, 4);
    }

    public int combinationSum4(int[] nums, int target) {
        int len = nums.length;

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            cur.add(nums[i]);
            helper(result, cur, nums[i], target, nums, len);
            cur.clear();
        }

        return result.size();
    }

    private void helper(List<List<Integer>> result, List<Integer> cur, int sum, int target, int[] nums, int len) {
        if (sum == target) {
            result.add(new ArrayList<>(cur));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = 0; i < len; i++) {
            cur.add(nums[i]);

            helper(result, cur, sum + nums[i], target, nums, len);

            cur.remove(cur.size() - 1);
        }
    }

}
