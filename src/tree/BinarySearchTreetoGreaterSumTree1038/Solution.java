package tree.BinarySearchTreetoGreaterSumTree1038;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public TreeNode bstToGst(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrderList(root, list);

        int len = list.size();

        for (int i = len -  2; i >= 0; i--) {
            list.set(i, list.get(i) + list.get(i + 1));
        }

        /*
        for (int i = 0; i < len; i++) {
            System.out.println("Number : " + list.get(i));
        }*/


        updateValues(root, list, 0);

        return root;
    }

    private int updateValues(TreeNode root, List<Integer> inOrderList, int index) {
        if (root == null) {
            return index - 1;
        }

        int done = updateValues(root.left, inOrderList, index);
        // System.out.println("updating " + root.val + " with value : " + inOrderList.get(done + 1));
        root.val = inOrderList.get(done + 1);
        done = updateValues(root.right, inOrderList, done + 2);

        return done;
    }

    private void inOrderList(TreeNode root, List<Integer> inOrder) {
        if (root == null) {
            return;
        }

        inOrderList(root.left, inOrder);
        inOrder.add(root.val);
        inOrderList(root.right, inOrder);
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