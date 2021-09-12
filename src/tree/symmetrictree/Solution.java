package tree.symmetrictree;

public class Solution {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        if ((root.left == null && root.right != null) || (root.left != null && root.right == null)) {
            return false;
        }

        return areMirrorTrees(root.left, root.right);
    }

    public boolean areMirrorTrees(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if ((p != null && q == null) || (p == null && q != null)) {
            return false;
        }

        if (p.val == q.val && areMirrorTrees(p.left, q.right) && areMirrorTrees(p.right, q.left)) {
            return true;
        }

        return false;
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
