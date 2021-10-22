package tree.kthsmallestnode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));
        sol.kthSmallest(root, 1);
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inOrder = new ArrayList<>();
        inOrderOfTree(root, inOrder);
        int noOfNodes = inOrder.size();
        System.out.println("noOfNodes : " + noOfNodes + " K : " + k);

        if (k - 1 < noOfNodes) {
            return inOrder.get(k - 1);
        }

        return -1;
    }

    private void inOrderOfTree(TreeNode root, List<Integer> inOrder) {
        if (root == null) {
            return;
        }

        inOrderOfTree(root.left, inOrder);
        inOrder.add(root.val);
        inOrderOfTree(root.right, inOrder);
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
