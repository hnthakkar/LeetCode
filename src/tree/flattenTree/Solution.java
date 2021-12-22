package tree.flattenTree;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.flatten(new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null, new TreeNode(6))));
    }

    public TreeNode flatten(TreeNode a) {
        if (a.left == null && a.right == null) {
            return a;
        }

        if (a.left == null && a.right != null) {
            a.right = flatten(a.right);
            return a;
        }

        if (a.left != null && a.right == null) {
            a.right = flatten(a.left);
            a.left = null;
            return a;
        }

        TreeNode leftRef = a.left;
        TreeNode rightRef = a.right;

        TreeNode ref = flatten(leftRef);
        a.right = ref;
        while (ref.right != null) {
            ref = ref.right;
        }
        ref.right = flatten(rightRef);
        a.left = null;

        return a;
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