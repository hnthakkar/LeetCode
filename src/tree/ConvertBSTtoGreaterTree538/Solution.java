package tree.ConvertBSTtoGreaterTree538;

public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(1, new TreeNode(0), new TreeNode(2, null, new TreeNode(3))), new TreeNode(6, new TreeNode(5), new TreeNode(7, null, new TreeNode(8))));
        Solution sol = new Solution();
        sol.convertBST(root);
    }

    public TreeNode convertBST(TreeNode root) {
        sumGreater(root, 0, false);

        return root;
    }

    private int sumGreater(TreeNode root, int parent, boolean isLeftChild) {
        if (root == null) {
            return 0;
        }

        root.val += parent + sumGreater(root.right, isLeftChild ? parent: 0, false);
        int leftSum = sumGreater(root.left, root.val, true);

        return Math.max(root.val, leftSum);
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
