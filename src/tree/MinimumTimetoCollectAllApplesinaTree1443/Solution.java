package tree.MinimumTimetoCollectAllApplesinaTree1443;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        boolean[] hasApplesArray = new boolean[]{false,true,false,false};

        List<Boolean> hasApples = new ArrayList<>();
        for (boolean bol: hasApplesArray) {
            hasApples.add(bol);
        }

        sol.minTime(4, new int[][]{{0,2},{0,3},{1,2}}, hasApples);
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Set<String> pathsNeeded = new HashSet<>();

        Map<Integer, Set<Integer>> paths = new HashMap<>();
        for (int[] edge: edges) {
            addPath(edge[0], edge[1], paths);
            addPath(edge[1], edge[0], paths);
        }

        helper(0, paths, pathsNeeded, hasApple, new HashSet<Integer>());

        return pathsNeeded.size() * 2;
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

    private boolean helper(int curNode, Map<Integer, Set<Integer>> edges, Set<String> pathsNeeded, List<Boolean> hasApple, Set<Integer> done) {
        if (!edges.containsKey(curNode)) {
            return hasApple.get(curNode);
        }

        Set<Integer> neighbor = edges.get(curNode);
        done.add(curNode);

        boolean pathIsUsed = false;

        for (int curNgh: neighbor) {
            if (!done.contains(curNgh) && helper(curNgh, edges, pathsNeeded, hasApple, done)) {
                pathIsUsed = true;
                pathsNeeded.add("" + curNode + "" + curNgh);
                done.add(curNode);
            }
        }

        return pathIsUsed || hasApple.get(curNode);
    }

}
