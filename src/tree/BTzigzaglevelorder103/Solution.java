package tree.BTzigzaglevelorder103;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, null, new TreeNode(5)));
        sol.zigzagLevelOrder(root);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return Collections.<List<Integer>>emptyList();
        }

        boolean isLeftToRight = true;

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            while (size > 0) {
                TreeNode curNode = q.poll();
                level.add(curNode.val);

                if (curNode.left != null) {
                    q.add(curNode.left);
                }

                if (curNode.right != null) {
                    q.add(curNode.right);
                }

                size--;
            }

            if (!isLeftToRight) {
                Collections.reverse(level);
            }

            result.add(level);
            isLeftToRight = !isLeftToRight;
        }

        return result;
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
