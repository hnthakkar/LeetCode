package educative.tree.isvalidbst;

import java.util.ArrayList;
import java.util.List;

public class IsValidBST {
    public static boolean isBst(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        getInOrder(root, nodes);

        if (nodes.size() == 1) {
            return true;
        }

        return validateInOrderSorted(nodes);
    }

    private static boolean validateInOrderSorted(List<Integer> nodes) {
        int len = nodes.size();
        int prev = nodes.get(0);

        for (int i = 1; i < len; i++) {
            int cur = nodes.get(i);
            if (cur <= prev) {
                return false;
            }
            prev = cur;
        }

        return true;
    }

    private static void getInOrder(TreeNode root, List<Integer> nodes) {
        if (root == null) {
            return;
        }
        getInOrder(root.left, nodes);
        nodes.add(root.val);
        getInOrder(root.right, nodes);
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
