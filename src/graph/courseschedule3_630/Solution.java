package graph.courseschedule3_630;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        int len = courses.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        int currentTime = 0;

        for (int i = 0; i < len; i++) {
            int[] course = courses[i];

            currentTime += course[0];
            pq.add(course[0]);

            if (currentTime > course[1]) {
                currentTime -= pq.poll();
            }
        }

        return pq.size();
    }

}
