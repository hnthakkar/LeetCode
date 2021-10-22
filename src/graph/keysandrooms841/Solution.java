package graph.keysandrooms841;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int noOfRooms = rooms.size();

        int[] visited = new int[noOfRooms];

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = 1;

        while(!q.isEmpty()) {
            int curRoom = q.poll();

            List<Integer> keysTo = rooms.get(curRoom);

            for (int room: keysTo) {
                if (visited[room] == 0) {
                    q.add(room);
                    visited[room] = 1;
                }
            }
        }

        for (int i = 0; i < noOfRooms; i++) {
            if (visited[i] == 0) {
                return false;
            }
        }

        return true;
    }
}
