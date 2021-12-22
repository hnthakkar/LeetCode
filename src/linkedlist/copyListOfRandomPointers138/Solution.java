package linkedlist.copyListOfRandomPointers138;

import java.util.HashMap;
import java.util.Map;

public class Solution {


    public Node copyRandomList(Node head) {
        Map<Node, Node> nodeMapping = new HashMap<>();

        Node newHead = null;
        Node newListCur = null;
        Node cur = head;

        while (cur != null) {
            Node n = new Node(cur.val);
            nodeMapping.put(cur, n);

            if (newListCur == null) {
                newHead = n;
                newListCur = n;
            } else {
                newListCur.next = n;
                newListCur = newListCur.next;
            }

            cur = cur.next;
        }

        cur = head;
        newListCur = newHead;

        while (cur != null) {
            newListCur.random = nodeMapping.get(cur.random);

            newListCur = newListCur.next;
            cur = cur.next;
        }

        return newHead;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
