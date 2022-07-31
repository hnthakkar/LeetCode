package tree.FlattenBinaryTreetoLinkedList114;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        List<TreeNode> nodes = new ArrayList<>();
        helper(root, nodes);

        TreeNode prev = nodes.get(0);
        prev.left = null;

        for (int i = 1; i < nodes.size(); i++) {
            TreeNode cur = nodes.get(i);
            prev.right = cur;
            cur.left = null;
            prev = cur;
        }
    }

    private void helper(TreeNode root, List<TreeNode> preOrder) {
        if (root == null) {
            return;
        }

        preOrder.add(root);
        helper(root.left, preOrder);
        helper(root.right, preOrder);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}