package graph.minnumberofvertextoreachall;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] incomingCount = new int[n];

        for (List<Integer> edge: edges) {
            incomingCount[edge.get(1)] += 1;
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (incomingCount[i] == 0) {
                result.add(i);
            }
        }

        return result;
    }

}
