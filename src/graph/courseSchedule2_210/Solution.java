package graph.courseSchedule2_210;

import java.util.*;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.findOrder(4, new int[][] {{1, 0}, {2, 0}, {3, 1}, {3, 2}});
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int rows = prerequisites.length;
        Map<Integer, List<Integer>> childCourses = new HashMap<>();

        for (int[] p : prerequisites) {
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

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numCourses; i++) {
            if (checkedNode.contains(i)) {
                continue;
            }

            if (detectDFSCycle(childCourses, visited, i, checkedNode, stack)) {
                return new int[0];
            }

            if (stack.size() == numCourses) {
                break;
            }
        }

        int[] seq = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            seq[i] = stack.pop();
        }

        return seq;
    }

    private boolean detectDFSCycle(Map<Integer, List<Integer>> childCourses, Set<Integer> visited, int course, Set<Integer> checkedNode, Stack<Integer> stack) {
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
                if (detectDFSCycle(childCourses, visited, neighbor, checkedNode, stack)) {
                    return true;
                }
            }
        }

        visited.remove(course);
        checkedNode.add(course);

        stack.add(course);

        return false;
    }
}
