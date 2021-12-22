package design.LFU460;

import java.util.*;

class LFUCache {

    int c;
    Map<Integer, QueueElem> elemMap;
    PriorityQueue<QueueElem> pq;
    int reqNo;

    public static void main(String[] str) {
        LFUCache sol = new LFUCache(2);
        sol.get(2);
        sol.put(2, 6);
        sol.get(1);
        sol.put(1, 5);
        sol.put(1, 2);
        sol.get(1);
        sol.get(2);

        /*
            ["LFUCache","get","put","get","put","put","get","get"]
            [[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
         */
    }

    public LFUCache(int capacity) {
        c = capacity;
        elemMap = new HashMap<>();
        pq = new PriorityQueue<>(new QueueElemComparator());
        reqNo = 1;
    }

    public int get(int key) {
        if (!elemMap.containsKey(key)) {
            return -1;
        }

        if (pq.size() > 0) {
            QueueElem elem = elemMap.get(key);
            pq.remove(elemMap.get(key));

            elem.lastRequestNo = reqNo++;
            elem.freqCounter += 1;

            if (pq.size() < c) {
                pq.add(elem);
            }

            return elem.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (pq.size() >= c && pq.size() > 0 && !elemMap.containsKey(key)) {
            QueueElem removedElem = pq.poll();
            elemMap.remove(removedElem.key);
        }

        QueueElem elem = null;
        if (elemMap.containsKey(key)) {
            elem = elemMap.get(key);
            pq.remove(elemMap.get(key));

            elem.lastRequestNo = reqNo++;
            elem.freqCounter += 1;
            elem.val = value;
        } else {
            elem = new QueueElem(key, value, reqNo++);
            elemMap.put(key, elem);
        }

        if (pq.size() < c) {
            pq.add(elem);
        }

    }

}

class QueueElem {
    int freqCounter;
    int key;
    int val;
    int lastRequestNo;

    public QueueElem(int pKey, int pValue, int pLastRequestNo) {
        freqCounter = 1;
        key = pKey;
        val = pValue;
        lastRequestNo = pLastRequestNo;
    }
}

class QueueElemComparator implements Comparator<QueueElem> {

    @Override
    public int compare(QueueElem o1, QueueElem o2) {
        if (o1.freqCounter != o2.freqCounter) {
            return o1.freqCounter - o2.freqCounter;
        } else {
            return o1.lastRequestNo - o2.lastRequestNo;
        }
    }
}