package tree.AllElementsinTwoBinarySearchTrees1305;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();

        TreeNode root1 = new TreeNode(2, new TreeNode(1), new TreeNode(4));
        TreeNode root2 = new TreeNode(1, new TreeNode(0), new TreeNode(3));

        sol.getAllElements(root1, root2);
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> t1InOrder = new ArrayList<>();
        getInOrder(root1, t1InOrder);

        List<Integer> t2InOrder = new ArrayList<>();
        getInOrder(root2, t2InOrder);

        int t1Size = t1InOrder.size();
        int t2Size = t2InOrder.size();

        int t1Cur = 0;
        int t2Cur = 0;

        List<Integer> result = new ArrayList<>();

        while (t1Cur < t1Size && t2Cur < t2Size) {
            if (t1InOrder.get(t1Cur) <= t2InOrder.get(t2Cur)) {
                result.add(t1InOrder.get(t1Cur++));
            } else {
                result.add(t2InOrder.get(t2Cur++));
            }
        }

        while (t1Cur < t1Size) {
            result.add(t1InOrder.get(t1Cur++));
        }

        while (t2Cur < t2Size) {
            result.add(t2InOrder.get(t2Cur++));
        }

        return result;
    }

    private void getInOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        getInOrder(root.left, result);
        result.add(root.val);
        getInOrder(root.right, result);
    }
    /*
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result = new ArrayList<>();
        helper(root1, root2, result);

        return result;
    }

    private void helper(TreeNode root1, TreeNode root2, List<Integer> result) {
        if (root1 == null || root2 == null) {
            return;
        }

        if (root1.left != null && root2.left != null) {
            helper(root1.left, root2.left, result);
        } else if (root1.left != null) {
            helper(root1.left, root2, result);
        } else if (root2.left != null) {
            helper(root1, root2.left, result);
        }

        if (root1.val < root2.val) {
            result.add(root1.val);
            helper(root1.right, root2, result);
        } else {
            result.add(root2.val);
            helper(root1, root2.right, result);
        }
    }

     */
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