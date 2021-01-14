package binarysearch.binarytreecloset;

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

class Solution {

    public int closestValue(TreeNode root, double target) {
        TreeNode node = closestValueHelper(root, target);
        return node.val;
    }

    public TreeNode closestValueHelper(TreeNode root, double target) {
        if (root == null) {
            return null;
        }

        if (root.val == target) {
            return root;
        }

        double rootDiff = Math.abs(target - root.val);
        TreeNode leftCloset = null;
        TreeNode rightCloset = null;

        if (target < root.val) {
            leftCloset = closestValueHelper(root.left, target);
            if (leftCloset == null || (rootDiff < Math.abs(target - leftCloset.val))) {
                return root;
            } else {
                return leftCloset;
            }
        } else {
            rightCloset = closestValueHelper(root.right, target);
            if (rightCloset == null || (rootDiff < Math.abs(target - rightCloset.val))) {
                return root;
            } else {
                return rightCloset;
            }
        }
    }
}