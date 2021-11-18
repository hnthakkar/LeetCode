package backtracking.permutation46;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.permute(new int[]{1,2,3});
    }

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;

        List<List<Integer>> result = new ArrayList<>();
        helper(nums, len, result, new ArrayList<Integer>(), new HashSet<Integer>());

        return result;
    }

    private void helper(int[] nums, int len, List<List<Integer>> result, List<Integer> cur, Set<Integer> doneItems) {
        if (doneItems.size() == len) {
            result.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (doneItems.contains(nums[i])) {
                continue;
            }

            cur.add(nums[i]);
            doneItems.add(nums[i]);

            helper(nums, len, result, cur, doneItems);

            cur.remove(cur.size() - 1);
            doneItems.remove(nums[i]);
        }
    }
}
