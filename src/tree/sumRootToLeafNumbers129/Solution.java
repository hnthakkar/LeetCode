package tree.sumRootToLeafNumbers129;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        sol.sumNumbers(root);
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = helper(root, 0);
        return result;
    }

    private int helper(TreeNode root, int valueFromAbove) {
        valueFromAbove = valueFromAbove * 10 + root.val;
        int result = 0;

        if (root.left != null) {
            result += helper(root.left, valueFromAbove);
        }

        if (root.right != null) {
            result += helper(root.right, valueFromAbove);
        }

        return result == 0 ? valueFromAbove: result;
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
