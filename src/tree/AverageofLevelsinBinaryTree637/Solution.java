package tree.AverageofLevelsinBinaryTree637;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Double> averageOfLevels(TreeNode root) {
        List<List<Long>> levelSum = new ArrayList<>();

        helper(root, levelSum, 1);

        List<Double> result = new ArrayList<>();

        for (List<Long> cur : levelSum) {
            Double d = Double.valueOf(cur.get(0)) / Double.valueOf(cur.get(1));
            result.add(d);
        }

        return result;
    }

    private void helper(TreeNode root, List<List<Long>> levelSum, int curLevel) {
        if (root == null) {
            return;
        }

        List<Long> curLevelList = null;

        if (levelSum.size() < curLevel) {
            curLevelList = new ArrayList<>();
            curLevelList.add(Long.valueOf(root.val));
            curLevelList.add(1L);

            levelSum.add(curLevelList);
        } else {
            curLevelList = levelSum.get(curLevel - 1);
            curLevelList.set(0, curLevelList.get(0) + Long.valueOf(root.val));
            curLevelList.set(1, curLevelList.get(1) + 1L);
        }


        helper(root.left, levelSum, curLevel + 1);
        helper(root.right, levelSum, curLevel + 1);
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