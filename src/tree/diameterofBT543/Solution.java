package tree.diameterofBT543;

public class Solution {

    public static void main(String[] args) {
        // TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));

        // TreeNode root = new TreeNode(1, new TreeNode(2), null);
        TreeNode root = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), null);
        Solution sol = new Solution();
        sol.diameterOfBinaryTree(root);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        NodeInfo rootInfo = helper(root);

        return rootInfo.maxDiaMeterTillNow;
    }

    private NodeInfo helper(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return new NodeInfo();
        }

        NodeInfo leftNodeInfo = helper(root.left);
        NodeInfo rightNodeInfo = helper(root.right);

        NodeInfo curNode = new NodeInfo();
        curNode.maxLeftDepth = root.left != null? leftNodeInfo.maxDepth + 1 : 0;
        curNode.maxRightDepth = root.right != null? rightNodeInfo.maxDepth + 1 : 0;

        curNode.maxDepth = Math.max(curNode.maxLeftDepth, curNode.maxRightDepth);

        int maxDiameterCurNode = curNode.maxLeftDepth + curNode.maxRightDepth;
        curNode.maxDiaMeterTillNow = Math.max(maxDiameterCurNode, Math.max(leftNodeInfo.maxDiaMeterTillNow, rightNodeInfo.maxDiaMeterTillNow));

        return curNode;
    }
}

class NodeInfo {
    int maxLeftDepth = 0;
    int maxRightDepth = 0;
    int maxDepth = 0;
    int maxDiaMeterTillNow = 0;
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