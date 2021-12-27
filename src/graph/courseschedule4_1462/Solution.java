package graph.courseschedule4_1462;

import java.util.*;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.checkIfPrerequisite(2, new int[][]{{1,0}}, new int[][]{{0,1}, {1,0}});
    }

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int rows = prerequisites.length;
        Map<Integer, Set<Integer>> childCourses = new HashMap<>();

        for (int[] p : prerequisites) {
            if (childCourses.containsKey(p[1])) {
                Set<Integer> courses = childCourses.get(p[1]);
                courses.add(p[0]);
            } else {
                Set<Integer> courses = new HashSet<>();
                courses.add(p[0]);
                childCourses.put(p[1], courses);
            }
        }

        Set<Integer> visited = new HashSet<>();

        int noOfQueries = queries.length;
        List<Boolean> result = new ArrayList<>();

        for (int i = 0; i < noOfQueries; i++) {
            visited.clear();
            int start = queries[i][0];
            int end = queries[i][1];

            result.add(dfs(childCourses, visited, end, start));
        }

        return result;
    }

    private boolean dfs(Map<Integer, Set<Integer>> childCourses, Set<Integer> visited, int start, int end) {
        if (visited.contains(start)) {
            return false;
        }

        visited.add(start);
        Set<Integer> neighbors = childCourses.get(start);

        if (neighbors != null) {
            if (neighbors.contains(end)) {
                return true;
            }

            for (int neighbor : neighbors) {
                neighbors.addAll(childCourses.get(neighbor));
                if (dfs(childCourses, visited, neighbor, end)) {
                    return true;
                }
            }
        }

        visited.remove(start);

        return false;
    }
}
