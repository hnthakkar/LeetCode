package tree.NaryTreePreorderTraversal589;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);

        return result;
    }

    private void helper(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }

        result.add(root.val);

        for (Node child: root.children) {
            helper(child, result);
        }
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};