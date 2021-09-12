package tree.pathsum2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        hasPathSumHelper(root, targetSum, 0, new ArrayList<Integer>(), result);
        return result;
    }

    public void hasPathSumHelper(TreeNode root, int targetSum, int sumTillNow, List<Integer> current, List<List<Integer>> result) {

        if (root == null) {
            return;
        }

        int pathSum = sumTillNow + root.val;
        current.add(root.val);


        if (pathSum == targetSum && root.left == null && root.right == null) {
            result.add(current);
            return;
        }

        hasPathSumHelper(root.left, targetSum, pathSum, current.stream().collect(Collectors.toList()), result);
        hasPathSumHelper(root.right, targetSum, pathSum, current.stream().collect(Collectors.toList()) , result);
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
