package priorityQueue.LastStoneWeight1046;

import java.util.PriorityQueue;

public class Solution {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));

        for (int stone: stones) {
            pq.add(stone);
        }

        int largest = pq.poll();
        int secondLarget = pq.isEmpty()? -1: pq.poll();

        while (secondLarget != -1) {
            if (largest != secondLarget) {
                pq.add(largest - secondLarget);
            }

            largest = pq.isEmpty()? -1: pq.poll();
            secondLarget = pq.isEmpty()? -1: pq.poll();
        }

        return largest == -1? 0: largest;
    }

}
