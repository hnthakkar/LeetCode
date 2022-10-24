package tree.RecoverBinarySearchTree99;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();

        TreeNode root = new TreeNode(1, new TreeNode(3, null, new TreeNode(2)), null);
        sol.recoverTree(root);
    }

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }

        List<TreeNode> inOrder = new ArrayList<>();
        List<Integer> intOrder = new ArrayList<>();

        checkInOrder(root, inOrder, intOrder);
        Collections.sort(intOrder);

        int len = inOrder.size();

        for (int i = 0; i < len; i++) {
            inOrder.get(i).val = intOrder.get(i);
        }
    }

    private void checkInOrder(TreeNode root, List<TreeNode> inOrder, List<Integer> intOrder) {
        if (root == null) {
            return;
        }

        checkInOrder(root.left, inOrder, intOrder);
        inOrder.add(root);
        intOrder.add(root.val);
        checkInOrder(root.right, inOrder, intOrder);
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

