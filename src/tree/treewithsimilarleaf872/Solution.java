package tree.treewithsimilarleaf872;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        if (root1 != null) {
            getLeafNodeSequence(root1, list1);
        }

        List<Integer> list2 = new ArrayList<>();
        if (root2 != null) {
            getLeafNodeSequence(root2, list2);
        }

        return compareList(list1, list2);
    }

    private boolean compareList(List<Integer> list1, List<Integer> list2) {
        int len1 = list1.size();
        int len2 = list2.size();

        if (len1 != len2) {
            return false;
        }

        for (int i = 0; i < len1; i++) {
            if (list1.get(i) != list2.get(i)) {
                return false;
            }
        }

        return true;
    }

    private void getLeafNodeSequence(TreeNode root, List<Integer> list) {
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }

        if (root.left != null) {
            getLeafNodeSequence(root.left, list);
        }

        if (root.right != null) {
            getLeafNodeSequence(root.right, list);
        }
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