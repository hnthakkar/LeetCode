package bfs.BusRoutes815;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.numBusesToDestination(new int[][]{{1, 2, 7}, {3, 6, 7}}, 1, 6);
    }

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }

        int noOfBus = routes.length;
        Map<Integer, Set<Integer>> busRouteMap = new HashMap<>();

        Set<Integer> sourceBus = new HashSet<>();
        Set<Integer> targetBus = new HashSet<>();

        for (int i = 0; i < noOfBus; i++) {
            Set<Integer> stops = getRouteSet(routes[i]);

            if (stops.contains(source) && stops.contains(target)) {
                return 1;
            }

            busRouteMap.put(i, stops);

            if (stops.contains(source)) {
                sourceBus.add(i);
            }

            if (stops.contains(target)) {
                targetBus.add(i);
            }
        }

        Map<Integer, List<Integer>> nMap = new HashMap<>();

        for (int i = 0; i < noOfBus; i++) {
            nMap.put(i, new ArrayList<Integer>());
        }

        for (int i = 0; i < noOfBus; i++) {
            for (int j = i + 1; j < noOfBus; j++) {
                if (checkIfNeighbors(busRouteMap.get(i), busRouteMap.get(j))) {
                    nMap.get(i).add(j);
                    nMap.get(j).add(i);
                }
            }
        }

        Queue<Integer> que = new LinkedList<>();
        int[] visited = new int[noOfBus];

        for (int src: sourceBus) {
            que.add(src);
            visited[src] = 1;
        }

        int result = 0;
        boolean found = false;

        while (!que.isEmpty()) {
            int size = que.size();

            while (size > 0) {
                int top = que.poll();

                if (targetBus.contains(top)) {
                    found = true;
                    break;
                }

                List<Integer> ngbs = nMap.get(top);

                for (int ngb: ngbs) {
                    if (visited[ngb] != 1) {
                        que.add(ngb);
                        visited[ngb] = 1;
                    }
                }

                size--;
            }

            if (found) {
                break;
            }

            result++;
        }

        return found? result + 1: -1;
    }

    private boolean checkIfNeighbors(Set<Integer> b1, Set<Integer> b2) {
        for (int stop: b1) {
            if (b2.contains(stop)) {
                return true;
            }
        }

        return false;
    }

    private Set<Integer> getRouteSet(int[] route) {
        Set<Integer> set = new HashSet<>();

        for (int r: route) {
            set.add(r);
        }

        return set;
    }

}
