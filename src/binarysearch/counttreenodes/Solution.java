package binarysearch.counttreenodes;

class Solution {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        int count = 0;
        if (root.left != null) {
            count += countNodes(root.left);
            if (root.right != null) {
                count += countNodes(root.right);
            }
        }

        return count + 1;
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
