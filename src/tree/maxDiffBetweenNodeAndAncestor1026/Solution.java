package tree.maxDiffBetweenNodeAndAncestor1026;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        TreeNode root = new TreeNode(8,
                new TreeNode(3, new TreeNode(1), new TreeNode(6, new TreeNode(4), new TreeNode(7))),
                new TreeNode(10, null, new TreeNode(14, new TreeNode(13), null)));
        sol.maxAncestorDiff(root);
    }

    public int maxAncestorDiff(TreeNode root) {
        int[] result = helper(root);

        return result[2];
    }

    private int[] helper(TreeNode root) {
        if (root == null) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        if (root.left == null && root.right == null) {
            return new int[]{root.val, root.val, 0};
        }

        int[] leftSubTree = helper(root.left);
        int[] rightSubTree = helper(root.right);

        int minTillNow = Math.min(root.val, Math.min(leftSubTree[0], rightSubTree[0]));
        int maxTillNow = Math.max(root.val, Math.max(leftSubTree[1], rightSubTree[1]));

        int leftDiff = Math.max(leftSubTree[0] != Integer.MAX_VALUE ? Math.abs(root.val - leftSubTree[0]): 0,
                leftSubTree[1] != Integer.MIN_VALUE ? Math.abs(root.val - leftSubTree[1]): 0);

        int rightDiff = Math.max(rightSubTree[0] != Integer.MAX_VALUE ? Math.abs(root.val - rightSubTree[0]) : 0,
                rightSubTree[1] != Integer.MIN_VALUE ? Math.abs(root.val - rightSubTree[1]): 0);

        int maxGlobalDiff = Math.max(Math.max(leftDiff, rightDiff), Math.max(leftSubTree[2], rightSubTree[2]));

        return new int[] {minTillNow, maxTillNow, maxGlobalDiff};
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