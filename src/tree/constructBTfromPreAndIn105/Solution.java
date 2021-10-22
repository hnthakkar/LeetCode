package tree.constructBTfromPreAndIn105;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
    }

    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        int noOfNodes = preOrder.length;

        if (noOfNodes == 1) {
            return new TreeNode(preOrder[0]);
        }

        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < noOfNodes; i++) {
            indexMap.put(inOrder[i], i);
        }

        return helper(0, 0, noOfNodes - 1, indexMap, preOrder, inOrder, noOfNodes);
    }


    private TreeNode helper(int preOrderIndex, int inOrderStart, int inOrderEnd, Map<Integer, Integer> indexMap, int[] preOrder, int[] inOrder, int noOfNodes) {
        if (preOrderIndex >= noOfNodes || inOrderEnd < inOrderStart) {
            return null;
        }

        TreeNode curNode = new TreeNode(preOrder[preOrderIndex]);

        int curNodeInOrderIndex = indexMap.get(preOrder[preOrderIndex]);

        curNode.left = helper(preOrderIndex + 1, inOrderStart, curNodeInOrderIndex - 1, indexMap, preOrder, inOrder, noOfNodes);
        curNode.right = helper(preOrderIndex + (curNodeInOrderIndex - inOrderStart + 1), curNodeInOrderIndex + 1, inOrderEnd, indexMap, preOrder, inOrder, noOfNodes);

        return curNode;
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
