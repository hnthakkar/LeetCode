package backtracking.combinations77;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public List<List<Integer>> combine(int n, int k) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);

        int next = 2;

        List<List<Integer>> result = new ArrayList<>();

        while (!stack.isEmpty() || next <= n) {
            // push to stack
            while (next <= n && stack.size() < k) {
                stack.push(next++);
            }

            // no further combination of length k
            if (stack.isEmpty()) {
                break;
            }

            if (stack.size() == k) {
                // Found a new combination
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < k; i++) {
                    list.add(stack.get(i));
                }

                result.add(list);
            }

            // No more elements to push, pop the previous to start with a new combination
            next = stack.pop() + 1;

        }

        return result;
    }

}
