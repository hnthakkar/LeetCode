package tree.NumberofNodesintheSubTreeWiththeSameLabel1519;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.countSubTrees(7, new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}}, "abaedcd");
    }

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        char[] labelChars = labels.toCharArray();
        Map<Character, Integer> charMap = new HashMap<>();

        Map<Integer, Set<Integer>> paths = new HashMap<>();
        for (int[] edge : edges) {
            addPath(edge[0], edge[1], paths);
            addPath(edge[1], edge[0], paths);
        }

        int[] result = new int[n];
        helper(0, paths, new HashSet<>(), labelChars, result);

        return result;
    }

    private void addPath(int p1, int p2, Map<Integer, Set<Integer>> paths) {
        Set<Integer> endPoints = null;
        if (paths.containsKey(p1)) {
            endPoints = paths.get(p1);
        } else {
            endPoints = new HashSet<>();
            paths.put(p1, endPoints);
        }

        endPoints.add(p2);
    }

    private Map<Character, Integer> helper(int curNode, Map<Integer, Set<Integer>> paths, Set<Integer> done, char[] labelChars, int[] result) {
        Set<Integer> neighbor = paths.get(curNode);
        done.add(curNode);

        Map<Character, Integer> childCounts = new HashMap<>();
        childCounts.put(labelChars[curNode], 1);

        for (int curNgh : neighbor) {
            if (!done.contains(curNgh)) {
                Map<Character, Integer> curChild = helper(curNgh, paths, done, labelChars, result);

                for (Character ch: curChild.keySet()) {
                    childCounts.put(ch, childCounts.getOrDefault(ch, 0) + curChild.get(ch));
                }
            }
        }

        result[curNode] = childCounts.get(labelChars[curNode]);

        return childCounts;
    }
}
