package tree.binarytreerightview199;

import java.util.*;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return Collections.<Integer> emptyList();
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        List<Integer> result = new ArrayList<>();

        while (!q.isEmpty()) {
            int size = q.size();

            while (size > 0) {
                TreeNode cur = q.poll();

                if (cur.left != null) {
                    q.add(cur.left);
                }

                if (cur.right != null) {
                    q.add(cur.right);
                }

                if (size == 1) {
                    result.add(cur.val);
                }
                size--;
            }
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

/*
public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);

        return result;
    }

    private void helper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        result.add(root.val);

        if (root.right != null) {
            helper(root.right, result);
        } else {
            helper(root.left, result);
        }
    }
 */