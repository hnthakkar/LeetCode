package tree.binaryTreeTilt563;

public class Solution {

    public int findTilt(TreeNode root) {
        int[] ret = helper(root);
        return ret[0];
    }

    private int[] helper(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        if (root.left == null && root.right == null) {
            return new int[]{0, root.val};
        }

        int[] rightSubtree = helper(root.right);
        int[] leftSubtree = helper(root.left);

        int diff = Math.abs(leftSubtree[1] - rightSubtree[1]);


        return new int[]{diff + rightSubtree[0] + leftSubtree[0], root.val + rightSubtree[1] + leftSubtree[1]};
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
