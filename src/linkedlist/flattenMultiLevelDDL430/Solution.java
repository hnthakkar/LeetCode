package linkedlist.flattenMultiLevelDDL430;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        Node node_1 = new Node(1);
        Node node_2 = new Node(2);
        Node node_3 = new Node(3);
        Node node_4 = new Node(4);
        Node node_5 = new Node(5);
        Node node_6 = new Node(6);
        Node node_7 = new Node(7);
        Node node_8 = new Node(8);
        Node node_9 = new Node(9);
        Node node_10 = new Node(10);
        Node node_11 = new Node(11);
        Node node_12 = new Node(12);

        node_1.next = node_2;

        node_2.prev = node_1;
        node_2.next = node_3;

        node_3.prev = node_2;
        node_3.child = node_7;
        node_3.next = node_4;

        node_4.prev = node_3;
        node_4.next = node_5;

        node_5.prev = node_4;
        node_5.next = node_6;

        node_6.prev = node_5;

        node_7.next = node_8;

        node_8.prev = node_7;
        node_8.child = node_11;
        node_8.next = node_9;

        node_9.prev = node_8;
        node_9.next = node_10;

        node_10.prev = node_9;

        node_11.next = node_12;

        node_12.prev = node_11;

        sol.flatten(node_1);
    }

    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }

        Node root = helper(head)[0];
        return root;
    }

    private Node[] helper(Node head) {
        Node next = head.next;
        Node child = head.child;

        Node tail = head;

        if (child != null) {
            Node[] childCall = helper(child);

            if (childCall[0] != null) {
                head.next = childCall[0];
                head.next.prev = head;

                tail = childCall[1];
            }
            head.child = null;
        }

        if (next != null){
            tail.next = next;
            next.prev = tail;
            tail = next;
            Node[] childCall = helper(next);
            tail = childCall[1];
        }

        return new Node[] {head, tail};
    }
}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node(int pVal) {
        val = pVal;
    }
};
