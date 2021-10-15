package tree.constructBTFromPreorder;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.bstFromPreorder(new int[]{8,5,1,7,10,12});
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        int len = preorder.length;
        Arrays.sort(preorder);

        return constructBT(preorder, 0, len - 1);
    }

    private TreeNode constructBT(int[] preorder, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return null;
        }

        int mid = startIndex + (endIndex - startIndex) / 2;

        TreeNode root = new TreeNode(preorder[mid]);
        root.left = constructBT(preorder, startIndex, mid - 1);
        root.right = constructBT(preorder, mid + 1, endIndex);

        return root;
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

