package tree.levelorderingtraversal;

import java.util.*;

public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> levelOrder = new ArrayList<>();
        List<Integer> level;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            TreeNode cur = q.poll();

            if (cur == null) {
                break;
            }

            level = new ArrayList<>();

            while (cur != null) {
                if (cur.left != null) {
                    q.add(cur.left);
                }

                if (cur.right != null) {
                    q.add(cur.right);
                }

                level.add(cur.val);
                cur = q.poll();
            }

            levelOrder.add(level);
            q.add(null);
        }

        return levelOrder;
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