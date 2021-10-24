package tree.countCompleteTreeNodes222;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null));
        sol.countNodes(root);
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root, true);
        int rightHeight = getHeight(root, false);

        if (leftHeight == rightHeight) {
            return ((int) Math.pow(2, leftHeight)) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int getHeight(TreeNode root, boolean leftHeight) {
        if (root == null) {
            return 0;
        }

        int height = 0;
        while (root != null) {
            if (leftHeight) {
                root = root.left;
            } else {
                root = root.right;
            }

            height++;
        }

        return height;
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
