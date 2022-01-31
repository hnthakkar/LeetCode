package tree.BinaryTreePaths257;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3));
        sol.binaryTreePaths(root);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        helper(root, cur, result);

        return result;
    }

    private void helper(TreeNode root, List<Integer> cur, List<String> result) {
        if (root == null) {
            return;
        }

        cur.add(root.val);

        if (root.left == null && root.right == null) {
            result.add(pathToString(cur));
            cur.remove(cur.size() - 1);
            return;
        }

        helper(root.left, cur, result);
        helper(root.right, cur, result);

        cur.remove(cur.size() - 1);
    }

    private String pathToString(List<Integer> cur) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < cur.size(); i++) {
            if (i == cur.size() - 1) {
                sb.append(cur.get(i));
            } else {
                sb.append(cur.get(i) + "->");
            }
        }

        return sb.toString();
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