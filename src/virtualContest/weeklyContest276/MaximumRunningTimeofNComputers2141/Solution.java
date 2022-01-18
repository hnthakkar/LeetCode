package virtualContest.weeklyContest276.MaximumRunningTimeofNComputers2141;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        // sol.maxRunTime(2, new int[]{3, 3, 3});
        // sol.maxRunTime(2, new int[]{1, 1, 1, 1});
        // sol.maxRunTime(2, new int[]{3, 3, 3});
        // sol.maxRunTime(2, new int[]{31, 87, 85, 44, 47, 25});
        sol.maxRunTime(12, new int[]{11, 89, 16, 32, 70, 67, 35, 35, 31, 24, 41, 29, 6, 53, 78, 83});
    }

    public long maxRunTime(int n, int[] batteries) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (Integer b : batteries) {
            pq.add(b);
        }

        long result = 0;

        while (!pq.isEmpty()) {
            boolean ok = true;
            List<Integer> inUse = new ArrayList<>();
            int minTime = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (pq.size() == 0) {
                    ok = false;
                    break;
                }

                int entry = pq.poll();
                minTime = Math.min(minTime, entry);
                inUse.add(entry);
            }

            if (!ok) {
                break;
            }

            for (Integer r : inUse) {
                if (r == 1) {
                    continue;
                }

                if (minTime == 1) {
                    pq.add(r - 1);
                    continue;
                }

                pq.add(r - (minTime - 1));
            }

            result += minTime == 1 ? 1 : (minTime - 1);
        }

        return result;
    }

}
