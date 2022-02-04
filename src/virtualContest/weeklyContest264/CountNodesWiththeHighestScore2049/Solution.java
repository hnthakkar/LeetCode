package virtualContest.weeklyContest264.CountNodesWiththeHighestScore2049;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        // sol.countHighestScoreNodes(new  int[]{-1, 2, 0, 2, 0});
        sol.countHighestScoreNodes(new  int[]{-1, 2, 0});
        // sol.countHighestScoreNodes(new  int[]{-1, 2, 0, 2, 0});
    }

    public int countHighestScoreNodes(int[] parents) {
        int noOfNodes = parents.length;

        Map<Integer, TreeNode> nodeMap = new HashMap<>();

        for (int i = 0; i < noOfNodes; i++) {
            nodeMap.put(i, new TreeNode(i));
        }

        for (int i = 1; i < noOfNodes; i++) {
            TreeNode parent = nodeMap.get(parents[i]);
            TreeNode child = nodeMap.get(i);

            if (parent.left == null) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }

        helper(nodeMap.get(0));

        int max = 0;
        int result = 0;

        for (int i = 0; i < noOfNodes; i++) {
            TreeNode curNode = nodeMap.get(i);

            int left = curNode.noOfNodesToLeft > 0? curNode.noOfNodesToLeft: 1;
            int right = curNode.noOfNodesToRight > 0? curNode.noOfNodesToRight: 1;
            int others = (noOfNodes - curNode.noOfNodesToLeft - curNode.noOfNodesToRight - 1) > 0? (noOfNodes - curNode.noOfNodesToLeft - curNode.noOfNodesToRight - 1): 1;

            int count = left * right * others;

            if (count > max) {
                max = count;
                result = 1;
            } else if (count == max) {
                result++;
            }
        }

        return result;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        root.noOfNodesToLeft = helper(root.left);
        root.noOfNodesToRight = helper(root.right);

        return 1 + root.noOfNodesToLeft + root.noOfNodesToRight;
    }
}

class TreeNode {
    int val;
    int noOfNodesToLeft;
    int noOfNodesToRight;

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