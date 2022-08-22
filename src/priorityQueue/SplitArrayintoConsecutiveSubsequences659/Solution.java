package priorityQueue.SplitArrayintoConsecutiveSubsequences659;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.isPossible(new int[]{1, 2, 3, 3, 4, 5});
    }

    public boolean isPossible(int[] nums) {
        int len = nums.length;

        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            insertIntoList(lists, nums[i]);
        }

        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).size() < 3) {
                return false;
            }
        }

        return true;
    }

    private void insertIntoList(List<List<Integer>> lists, int value) {
        int noOfLists = lists.size();

        for (int i = noOfLists - 1; i >= 0; i--) {
            List<Integer> curList = lists.get(i);
            if (curList.get(curList.size() - 1) == value - 1) {
                curList.add(value);
                return;
            }
        }

        List<Integer> newList = new ArrayList<>();
        newList.add(value);

        lists.add(newList);
    }

    /*
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int n : nums) {
            int c = freq.getOrDefault(n, 0);
            freq.put(n, c + 1);
            if (c == 0) {
                pq.add(n);
            }
        }

        List<Integer> list = new ArrayList<>();

        while (!pq.isEmpty()) {
            int counter = 1;

            int cur = pq.poll();

            if (freq.get(cur) > 1) {
                freq.put(cur, freq.get(cur) - 1);
                list.add(cur);
            } else {
                freq.remove(cur);
            }

            while (!pq.isEmpty()) {
                if (pq.poll() != ++cur) {
                    break;
                }

                counter++;

                if (freq.get(cur) > 1) {
                    freq.put(cur, freq.get(cur) - 1);
                    list.add(cur);
                } else {
                    freq.remove(cur);
                }
            }

            if (counter < 3) {
                return false;
            }

            pq.addAll(list);
            list.clear();
        }

        return true;
    }

     */
}
