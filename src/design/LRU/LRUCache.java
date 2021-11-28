package design.LRU;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {


    public static void main(String[] str) {
        LRUCache sol = new LRUCache(1);
        sol.put(2,1);
        sol.get(2);
        sol.put(3,2);
        sol.get(2);
        sol.get(3);
        /*
        LRUCache sol = new LRUCache(2);
        sol.put(1,1);
        sol.put(2,2);
        sol.get(1);
        sol.put(3,3);
        sol.get(2);
        sol.put(4,4);
        sol.get(1);
        sol.get(3);
        sol.get(4);

         */
    }

    int capacity;
    Node head;
    Node tail;
    int curSize;
    Map<Integer, Node> nodeMap = new HashMap<>();

    public LRUCache(int pCapacity) {
        capacity = pCapacity;
        head = null;
        tail = null;
        curSize = 0;
    }

    public int get(int key) {
        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            deleteNode(node);
            addToHead(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (curSize >= capacity) {
            deleteNode(tail);
        }

        if (nodeMap.containsKey(key)) {
            // update if needed and push to the head of the List
            Node reqNode = nodeMap.get(key);
            reqNode.val = value;

            deleteNode(reqNode);
            addToHead(reqNode);
        } else {
            // new entry
            if (curSize == capacity) {
                deleteNode(tail);
            }

            Node cur = new Node(key, value);
            addToHead(cur);
        }
    }

    private void deleteNode(Node node) {
        nodeMap.remove(node.key);
        if (node == head) {
            head = head.next;
        }

        if (node == tail) {
            tail = node.prev;
        }

        if (node.prev != null) {
            node.prev.next = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }

        node.prev = null;
        node.next = null;
        curSize--;
    }

    private void addToHead (Node node) {
        nodeMap.put(node.key, node);
        if (head == null) {
            head = node;
            tail = head;
            nodeMap.put(node.key, node);
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }

        curSize++;
    }
}

class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node (int pKey, int pVal) {
        key = pKey;
        val = pVal;
        prev = null;
        next = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */