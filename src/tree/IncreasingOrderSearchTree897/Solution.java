package tree.IncreasingOrderSearchTree897;

import java.util.Stack;

public class Solution {

    public TreeNode increasingBST(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        helper(root, s);

        TreeNode ref = null;

        while (!s.isEmpty()) {
            TreeNode top = s.pop();
            top.left = null;
            top.right = ref;
            ref = top;
        }

        return ref;
    }

    private void helper(TreeNode cur, Stack s) {
        if (cur == null) {
            return;
        }

        helper(cur.left, s);
        s.push(cur);
        helper(cur.right, s);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}