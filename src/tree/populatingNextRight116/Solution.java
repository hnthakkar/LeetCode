package tree.populatingNextRight116;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            Node prev = null;
            while (size > 0) {
                Node cur = q.poll();

                if (prev != null) {
                    prev.next = cur;
                }

                if (cur.left != null) {
                    q.add(cur.left);
                }

                if (cur.right != null) {
                    q.add(cur.right);
                }

                prev = cur;

                size--;
            }
        }

        return root;
    }

}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
