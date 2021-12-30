package backtracking.combinationSum3_216;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.combinationSum3(3, 7);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            cur.add(i);
            helper(result, cur, i, n, i + 1, k, n);
            cur.remove(cur.size() - 1);
        }

        return result;
    }


    private void helper(List<List<Integer>> result, List<Integer> cur, int sum, int target, int startAt, int k, int n) {
        if (sum == target && cur.size() == k) {
            result.add(new ArrayList<>(cur));
            return;
        }

        if (sum > target || cur.size() > k) {
            return;
        }

        for (int i = startAt; i <= 9; i++) {
            cur.add(i);
            helper(result, cur, sum + i, target, i + 1, k, n);
            cur.remove(cur.size() - 1);
        }
    }

}
