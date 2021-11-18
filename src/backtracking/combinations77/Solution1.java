package backtracking.combinations77;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    public static void main(String[] str) {
        Solution1 sol = new Solution1();
        sol.combine(4, 2);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        helper(n, result, 1, new ArrayList<Integer>(), k);
        return result;
    }

    private void helper(int n, List<List<Integer>> result, int startAt, List<Integer> cur, int remaining) {
        if (remaining == 0) {
            result.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i + startAt <= n; i++) {
            cur.add(startAt + i);
            helper(n, result, startAt + i + 1, cur, remaining - 1);
            cur.remove(cur.size() - 1);
        }
    }
}
