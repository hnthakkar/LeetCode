package tree.maxlevelsumBT;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int globalMax = Integer.MIN_VALUE;
        int localSum = 0;

        int curLevel = 1;
        int levelOfGlobalMax = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            localSum = 0;

            while (size > 0) {
                TreeNode cur = q.poll();

                if (cur.left != null) {
                    q.add(cur.left);
                }

                if (cur.right != null) {
                    q.add(cur.right);
                }

                localSum += cur.val;

                size--;
            }

            // System.out.println("Level :" + curLevel + " Level Sum : " + localSum);

            if (localSum > globalMax) {
                globalMax = localSum;
                levelOfGlobalMax = curLevel;
                // System.out.println("@@@ Max level Sum : " + globalMax + " For Level : " + curLevel);
            }
            curLevel++;
        }

        return levelOfGlobalMax;
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
