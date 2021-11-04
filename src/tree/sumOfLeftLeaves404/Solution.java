package tree.sumOfLeftLeaves404;

public class Solution {

    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, false);
    }

    private int helper(TreeNode root, boolean isLeftNode) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null && isLeftNode) {
            return root.val;
        }

        return helper(root.left, true) + helper(root.right, false);
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
