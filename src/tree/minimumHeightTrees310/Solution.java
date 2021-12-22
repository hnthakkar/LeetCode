package tree.minimumHeightTrees310;

import java.util.*;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        //sol.findMinHeightTrees(3, new int[][]{{0,1},{0,2}});
        // sol.findMinHeightTrees(1, new int[][]{});
        // sol.findMinHeightTrees(3, new int[][]{{0,1},{0,2}});
        // sol.findMinHeightTrees(2, new int[][]{{0,1}});

        sol.findMinHeightTrees(6, new int[][]{{3,0},{3,1},{3,2},{3,4},{4,5}});
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            List<Integer> ret = new ArrayList<>();
            ret.add(0);
            return ret;
        }

        int[][] mat = new int[n][n];
        int[] degree = new int[n];

        int noOfEdges = edges.length;

        for (int i = 0; i < noOfEdges; i++) {
            int e1 = edges[i][0];
            int e2 = edges[i][1];

            degree[e1] += 1;
            degree[e2] += 1;

            mat[e1][e2] = 1;
            mat[e2][e1] = 1;
        }

        Set<Integer> nonLeaveNodes = new HashSet<>();

        for (int i = 0; i < n; i++) {
            nonLeaveNodes.add(i);
        }

        while (nonLeaveNodes.size() > 2) {
            Set<Integer> newNonLeafNodes = new HashSet<>();
            int[] degreeCopy = Arrays.copyOf(degree, n);

            for (int node: nonLeaveNodes) {
                if (degree[node] == 1) {
                    degreeCopy[node] = 0;
                    for (int i = 0; i < n; i++) {
                        if (mat[node][i] == 1) {
                            mat[node][i] = 0;
                            mat[i][node] = 0;
                            degreeCopy[i] -= 1;
                        }
                    }
                } else {
                    newNonLeafNodes.add(node);
                }
            }
            degree = degreeCopy;
            nonLeaveNodes = newNonLeafNodes;
        }

        List<Integer> result = new ArrayList<>();
        result.addAll(nonLeaveNodes);

        return result;
    }

}
