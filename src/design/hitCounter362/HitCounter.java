package design.hitCounter362;

import java.util.LinkedList;
import java.util.Queue;

public class HitCounter {

    Queue<Integer> q;

    public HitCounter() {
        q = new LinkedList();
    }

    public void hit(int timestamp) {
        q.add(timestamp);
    }

    public int getHits(int timestamp) {
        if (q.isEmpty()) {
            return 0;
        }

        int peek = q.peek();

        while (peek <= timestamp - 300) {
            q.poll();

            if (q.isEmpty()) {
                break;
            }
            peek = q.peek();
        }

        return q.size();
    }
}
