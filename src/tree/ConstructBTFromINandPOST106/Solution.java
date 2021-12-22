package tree.ConstructBTFromINandPOST106;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        sol.buildTree(new int[]{3,2,1}, new int[]{3,2,1});
    }

    public TreeNode buildTree(int[] inOrder, int[] postOrder) {
        int len = inOrder.length;

        if (len == 1) {
            return new TreeNode(inOrder[0]);
        }

        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < len; i++) {
            indexMap.put(inOrder[i], i);
        }

        return helper(inOrder, postOrder, len, indexMap, len - 1, 0, len - 1);
    }

    private TreeNode helper(int[] inOrder, int[] postOrder, int len, Map<Integer, Integer> indexMap, int postOrderIndex, int inOrderStart, int inOrderEnd) {
        if (postOrderIndex < 0 || inOrderStart > inOrderEnd) {
            return null;
        }

        TreeNode node = new TreeNode(postOrder[postOrderIndex]);

        int curNodeInOrderIndex = indexMap.get(postOrder[postOrderIndex]);

        node.right = helper(inOrder, postOrder, len, indexMap, postOrderIndex - 1, inOrderStart, curNodeInOrderIndex + 1);
        node.left = helper(inOrder, postOrder, len, indexMap, postOrderIndex - (inOrderStart - curNodeInOrderIndex) - 1, curNodeInOrderIndex - 1, inOrderEnd);


        return node;
    }
}

class TreeNode {
    int val;
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