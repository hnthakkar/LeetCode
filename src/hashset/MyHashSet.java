package hashset;

class MyHashSet {

    private Node[] dataMap;
    private static final int bucket_size = 10000;

    /** Initialize your data structure here. */
    public MyHashSet() {
        dataMap = new Node[bucket_size];
    }

    private int computeIndex(int key) {
        return  key % bucket_size;
    }

    public void add(int key) {
        int bucket = computeIndex(key);

        Node node = dataMap[bucket];
        if (node == null) {
            dataMap[bucket] = new Node(key, key);
            return;
        } else {
            Node prev = null;
            while( node != null && node.key != key) {
                prev = node;
                node = node.next;
            }
            if (node == null) {
                prev.next = new Node(key, key);
            }
        }

    }

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

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = computeIndex(key);

        Node node = dataMap[bucket];
        if (node == null) {
            return false;
        } else {
            Node prev = null;
            while( node != null && node.key != key) {
                prev = node;
                node = node.next;
            }
            if (node == null) {
                return false;
            }
            return true;
        }

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

