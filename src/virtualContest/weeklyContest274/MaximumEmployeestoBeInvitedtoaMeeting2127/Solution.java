package virtualContest.weeklyContest274.MaximumEmployeestoBeInvitedtoaMeeting2127;

import java.util.*;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.maximumInvitations(new int[]{1, 0, 0, 2, 1, 4, 7, 8, 9, 6, 7, 10, 8});
    }

    public int maximumInvitations(int[] favorite) {
        int len = favorite.length;

        Map<Integer, List<Integer>> pref = new HashMap<>();

        for (int i = 0; i < len; i++) {
            if (pref.containsKey(favorite[i])) {
                pref.get(favorite[i]).add(i);
            } else {
                List<Integer> f = new ArrayList<>();
                f.add(i);
                pref.put(favorite[i], f);
            }
        }

        int result = len;
        for (int key : pref.keySet()) {
            List<Integer> f = pref.get(key);

            if (f.size() < 2) {
                continue;
            }

            if (f.size() > 2) {
                result -= (f.size() - 2);
            } else {
                if (!f.contains(favorite[key])) {
                    result -= 1;
                }
            }
        }

        return result;
    }

    private List<Integer> checkForCycle(int item, Map<Integer, List<Integer>> pref, int len) {
        int[] visited = new int[len];
        visited[item] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(item);

        while (!q.isEmpty()) {

        }

        return null;
    }

}
