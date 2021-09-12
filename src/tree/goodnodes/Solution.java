package tree.goodnodes;

class Solution {
    public int goodNodes(TreeNode root) {
        return 1+ goodNodeCount(root.left, root.val) + goodNodeCount(root.right, root.val);
    }

    private int goodNodeCount(TreeNode root, int maxInPath) {
        if (root == null) {
            return 0;
        }

        int ret = 0;
        if (maxInPath <= root.val) {
            ret += 1;
            maxInPath = root.val;
        }

        return ret + goodNodeCount(root.left, maxInPath) + goodNodeCount(root.right, maxInPath);
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