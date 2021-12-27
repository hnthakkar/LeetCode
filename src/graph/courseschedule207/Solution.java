package graph.courseschedule207;

import java.util.*;

public class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int rows = prerequisites.length;
        Map<Integer, List<Integer>> childCourses = new HashMap<>();

        for (int[] p: prerequisites) {
            if (childCourses.containsKey(p[1])) {
                List<Integer> courses = childCourses.get(p[1]);
                courses.add(p[0]);
            } else {
                List<Integer> courses = new ArrayList<>();
                courses.add(p[0]);
                childCourses.put(p[1], courses);
            }
        }

        Set<Integer> checkedNode = new HashSet<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            if (checkedNode.contains(i)) {
                continue;
            }

            if (detectDFSCycle(childCourses, visited, i, checkedNode)) {
                return false;
            }
        }

        return true;
    }

    private boolean detectDFSCycle(Map<Integer, List<Integer>> childCourses, Set<Integer> visited, int course, Set<Integer> checkedNode) {
        if (visited.contains(course)) {
            return true;
        }

        if (checkedNode.contains(course)) {
            return false;
        }

        visited.add(course);
        List<Integer> neighbors = childCourses.get(course);

        if (neighbors != null) {
            for (int neighbor : neighbors) {
                if (detectDFSCycle(childCourses, visited, neighbor, checkedNode)) {
                    return true;
                }
            }
        }

        checkedNode.add(course);
        visited.remove(course);

        return false;
    }
}
