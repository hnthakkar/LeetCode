package virtualContest.weeklyContest265.three;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.minimumOperations(new int[]{2, 8, 16}, 0, 1);
    }

    public int minimumOperations(int[] nums, int start, int goal) {
        return helper(nums, start, goal, 0);
    }

    private int helper(int[] nums, int start, int goal, int noOfOperations) {
        Queue<Integer> q = new LinkedList();
        int[] visited = new int[1001];
        q.add(start);
        visited[start] = 1;

        int ops = 0;
        boolean found = false;

        while (!q.isEmpty()) {
            int size = q.size();
            ops++;


            while (size > 0) {
                int top = q.poll();

                for (int i = 0; i < nums.length; i++) {
                    int plus = top + nums[i];
                    if (plus == goal) {
                        found = true;
                        break;
                    } else if (plus > 0 && plus < 1000 && visited[plus] == 0) {
                        q.add(plus);
                        visited[plus] = 1;
                    }

                    int minus = top - nums[i];
                    if (minus == goal) {
                        found = true;
                        break;
                    } else if (minus > 0 && minus < 1000 && visited[minus] == 0) {
                        q.add(minus);
                        visited[minus] = 1;
                    }

                    int xor = top ^ nums[i];
                    if (xor == goal) {
                        found = true;
                        break;
                    } else if (xor > 0 && xor < 1000 && visited[xor] == 0) {
                        q.add(xor);
                        visited[xor] = 1;
                    }
                }

                if (found) {
                    break;
                }
                size--;
            }

            if (found) {
                break;
            }
        }

        if (found) {
            return ops;
        } else {
            return -1;
        }
    }
}
