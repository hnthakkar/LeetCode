package hashmap;

import java.util.ArrayList;

public class MyHashMap {
    public static void main(String[] args) {
        MyHashMapSol sol = new MyHashMapSol();
        sol.put(1, 1);
        sol.put(2, 2);
        sol.get(1);            // returns 1
        sol.get(3);            // returns -1 (not found)
        sol.put(2, 1);          // update the existing value
        sol.get(2);            // returns 1
        sol.remove(2);          // remove the mapping for 2
        sol.get(2);            // returns -1 (not found)
    }
}

class Node {
    public int key;
    public int value;
    public Node next;

    public Node(int pKey, int pValue) {
        key = pKey;
        value = pValue;
    }
}

class MyHashMapSol {

    private Node[] dataMap;
    private static final int bucket_size = 10000;

    public MyHashMapSol() {
        dataMap = new Node[bucket_size];
    }

    private int computeIndex(int key) {
        return  key % bucket_size;
    }

    public void put(int key, int value) {
        int bucket = computeIndex(key);

        Node node = dataMap[bucket];
        if (node == null) {
            dataMap[bucket] = new Node(key, value);
            return;
        } else {
            Node prev = null;
            while( node != null && node.key != key) {
                prev = node;
                node = node.next;
            }
            if (node == null) {
                prev.next = new Node(key, value);
            } else {
                node.value = value;
            }
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int bucket = computeIndex(key);
        Node node = dataMap[bucket];

        while (node != null && node.key != key) {
            node = node.next;
        }

        if (node == null) {
            return -1;
        }

        return node.value;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int bucket = computeIndex(key);
        Node prev = null;
        Node curr = dataMap[bucket];

        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }

        if (curr == null) {
            return;
        }

        if (prev != null) {
            prev.next = curr.next;
        } else {
            dataMap[bucket] = curr.next;
        }

        curr = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */