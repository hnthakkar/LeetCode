package tree.inverttree;

public class Solution {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        invertTree(root.left);
        invertTree(root.right);

        TreeNode tmp = null;
        tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        return root;
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