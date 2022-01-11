package tree.SumofRootToLeafBinaryNumbers1022;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        TreeNode root = new TreeNode(1, new TreeNode(0, new TreeNode(0), new TreeNode(1)), new TreeNode(1, new TreeNode(0), new TreeNode(1)));
        sol.sumRootToLeaf(root);
    }

    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }

        List<Integer> curPath = new ArrayList<>();
        int result = helper(root, curPath);

        return result;
    }


    private int helper(TreeNode root, List<Integer> curPath) {
        if (root == null) {
            return 0;
        }

        curPath.add(root.val);

        if (root.left == null && root.right == null) {
            int tmp = convertToInt(curPath);
            curPath.remove(curPath.size() - 1);
            return tmp;
        }

        int result = 0;
        result += helper(root.left, curPath);
        result += helper(root.right, curPath);

        curPath.remove(curPath.size() - 1);

        return result;
    }

    private int convertToInt(List<Integer> curPath) {
        int len = curPath.size();

        int power = 0;
        int result = 0;

        for (int i = len - 1; i >= 0; i--) {
            if (curPath.get(i) == 1) {
                result += Math.pow(2, power);
            }

            power++;
        }

        return result;
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
