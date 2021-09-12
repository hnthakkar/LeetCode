package tree.pathsum;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        // TreeNode root = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null), new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1))));
        TreeNode root = new TreeNode(-2, null, new TreeNode(-3));
        sol.hasPathSum(root, -5);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        return hasPathSumHelper(root, targetSum, 0);
    }

    public boolean hasPathSumHelper(TreeNode root, int targetSum, int sumTillNow) {
        if (root == null) {
            return false;
        }

        int pathSum = sumTillNow + root.val;

        if (pathSum == targetSum && root.left == null && root.right == null) {
            return true;
        }

        return hasPathSumHelper(root.left, targetSum, pathSum) || hasPathSumHelper(root.right, targetSum, pathSum);
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