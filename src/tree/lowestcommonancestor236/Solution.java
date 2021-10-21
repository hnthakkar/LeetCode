package tree.lowestcommonancestor236;

public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) {
            return root;
        }

        boolean isPInLeftSubtree = isInSubtree(root.left, p);
        boolean isQInLeftSubtree = isInSubtree(root.right, q);

        if (isPInLeftSubtree && isQInLeftSubtree) {
            return lowestCommonAncestor(root.left, p, q);
        }

        if (!isPInLeftSubtree && !isQInLeftSubtree) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }

    private boolean isInSubtree(TreeNode root, TreeNode p) {
        if (root == null) {
            return false;
        }

        if (root == p) {
            return true;
        }

        return isInSubtree(root.left, p) || isInSubtree(root.right, p);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/*
Better Solution

 public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == q || root == p) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left == null ? right: left;
    }
 */