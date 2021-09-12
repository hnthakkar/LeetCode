package tree.pathsum3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(3, new TreeNode(3), new TreeNode(-2)), new TreeNode(2, null, new TreeNode(1))), new TreeNode(-3, null, new TreeNode(11)));
        sol.pathSum(root, 8);
    }

    int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        traverseTree(root, new ArrayList(), targetSum);
        return count;
    }

    public void checkForTargetSumInPath(List<Integer> path, int targetSum) {
        int len = path.size();
        int sum = 0;

        for (int i = len - 1; i >= 0; i--) {
            sum += path.get(i);
            if (sum == targetSum) {
                count++;
            }
        }
    }

    public void traverseTree(TreeNode root, List<Integer> current, int targetSum) {
        if (root == null) {
            return;
        }

        current.add(root.val);

        checkForTargetSumInPath(current, targetSum);

        traverseTree(root.left, current.stream().collect(Collectors.toList()), targetSum);
        traverseTree(root.right, current.stream().collect(Collectors.toList()) , targetSum);
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
