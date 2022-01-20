package priorityQueue.KokoEatingBananas875;

import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        // sol.minEatingSpeed(new int[]{3, 6, 7, 11}, 8);
        sol.minEatingSpeed(new int[]{2, 2}, 2);
    }

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1000000000;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int days = 0;
            for (int pile : piles) {
                days += (int) Math.ceil((double) pile / mid);
            }

            if (days > h) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    /*
    public int minEatingSpeed(int[] piles, int h) {
        if (piles.length == 1) {
            return (int) Math.ceil((double)piles[0] / h);
        }

        PriorityQueue<PileInfo> pq = new PriorityQueue<>((p1, p2) -> p2.max - p1.max);
        for (int pile : piles) {
            pq.add(new PileInfo(pile));
        }

        int noOfdays = pq.size();
        while (noOfdays < h) {
            PileInfo top = pq.poll();
            top.incDayByOne();
            pq.add(top);
            noOfdays++;
        }

        return pq.poll().max;
    }

     */
}

/*
class PileInfo {
    int noOfbanana;
    int daysToComplete;
    int max;

    public PileInfo(int pCount) {
        noOfbanana = pCount;
        max = pCount;
        daysToComplete = 1;
    }

    public void incDayByOne() {
        max = (int) Math.ceil((double)noOfbanana / ++daysToComplete);
    }
}

 */
