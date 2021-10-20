package tree.convertArrayToBST;

public class Solution {

    public static void main(String[] args) {
        Solution  sol = new Solution();
        sol.sortedArrayToBST(new int[]{-10,-3,0,5,9});
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;

        if (len == 1) {
            return new TreeNode(nums[0]);
        }

        return helper(nums, 0, len - 1);
    }

    private TreeNode helper(int[] nums, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return null;
        }

        int mid = startIndex + (endIndex - startIndex) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = helper(nums, startIndex, mid - 1);
        root.right = helper(nums, mid + 1, endIndex);

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
