package tree.splittingtree;

public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), new TreeNode(4, new TreeNode(5, null, null), new TreeNode(6, null, null))));
        Solution sol = new Solution();
        System.out.println(sol.maxProduct(root));
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */

    public int maxProduct(TreeNode root) {
        long treeSum = sumOfTreeNodes(root);
        long[] maxProduct = maxProductSplitting(root, treeSum);
        return (int) (maxProduct[1] % 1000000007);
    }

    private long sumOfTreeNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return root.val + sumOfTreeNodes(root.left) + sumOfTreeNodes(root.right);
    }

    /**
     * int[0] == sum including self;
     * int[1] == maxproduct till self;
     */
    private long[] maxProductSplitting(TreeNode root, long treeSum) {
        if (root == null) {
            return new long[]{0, 1};
        }

        long[] leftTree = maxProductSplitting(root.left, treeSum);
        long[] rightTree = maxProductSplitting(root.right, treeSum);

        long maxProduct = Math.max((Math.max((treeSum - leftTree[0]) * leftTree[0], (treeSum - rightTree[0]) * rightTree[0])), root.val);

        maxProduct = Math.max(Math.max(leftTree[1], rightTree[1]), maxProduct);

        return new long[]{(root.val + leftTree[0] + rightTree[0]), maxProduct};
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