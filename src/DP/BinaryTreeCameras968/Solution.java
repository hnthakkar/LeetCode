package DP.BinaryTreeCameras968;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        // TreeNode root = new TreeNode(0, new TreeNode(0, new TreeNode(0, new TreeNode(0, null, new TreeNode(0)),  null), null), null);

        // TreeNode root = new TreeNode(0, new TreeNode(0), new TreeNode(0, new TreeNode(0), null));

        TreeNode root = new TreeNode(0, new TreeNode(0, new TreeNode(0, new TreeNode(0), new TreeNode(0)), new TreeNode(0, new TreeNode(0), new TreeNode(0))), new TreeNode(0, new TreeNode(0), new TreeNode(0)));
        sol.minCameraCover(root);
        //[0,0,null,0,null,0,null,null,0]
    }

    public int minCameraCover(TreeNode root) {
        int[] result = helper(root);

        return result[0] == 2? result[1] + 1: result[1];
    }

    /*
        0 --> I am covered from child
        1 --> I have a camera
        2 --> I need a camera
     */
    private int[] helper(TreeNode root) {
        if (root == null) {
            return new int[]{0 , 0};
        }

        int[] left = helper(root.left);
        int[] right = helper(root.right);

        // one of the child needs a camera
        if (left[0] == 2 || right[0] == 2) {
            return new int[] {1, 1 + left[1] + right[1]};
        }

        // covered from child
        if (left[0] == 1 || right[0] == 1) {
            return new int[]{0, left[1] + right[1]};
        }

        return new int[] {2, left[1] + right[1]};
    }

    /*
    public int minCameraCover(TreeNode root) {
        Map<TreeNode, Integer> includedMap = new HashMap<>();
        Map<TreeNode, Integer> notIncludedMap = new HashMap<>();

        int includeRoot = helper(root, false, true, includedMap, notIncludedMap);
        int skipRoot = helper(root, true, true, includedMap, notIncludedMap);

        return Math.min(includeRoot, skipRoot == 0? 1: skipRoot);
    }

    private int helper(TreeNode root, boolean skipRoot, boolean isParentSkipped, Map<TreeNode, Integer> includedMap, Map<TreeNode, Integer> notIncludedMap) {
        if (root == null) {
            return 0;
        }

        if (skipRoot && notIncludedMap.containsKey(root)) {
            return notIncludedMap.get(root);
        }

        if (!skipRoot && includedMap.containsKey(root)) {
            return includedMap.get(root);
        }

        if (root.left == null && root.right == null) {
            return isParentSkipped? 1: 0;
        }

        int result = 0;

        if (skipRoot) {
            if (root.left != null && root.right != null) {
                int skipLeftChild = helper(root.left, true, true, includedMap, notIncludedMap);
                int includeRightChild = helper(root.right, false, true, includedMap, notIncludedMap);

                int skipRightChild = helper(root.right, true, true, includedMap, notIncludedMap);
                int includeLeftChild = helper(root.left, false, true, includedMap, notIncludedMap);

                result = Math.min(includeLeftChild + includeRightChild, Math.min(skipLeftChild + includeRightChild, skipRightChild + includeLeftChild));
            } else {
                if (root.left != null) {
                    result = helper(root.left, false, true, includedMap, notIncludedMap);
                } else {
                    result = helper(root.right, false, true, includedMap, notIncludedMap);
                }
            }

        } else {
            // root has camera
            int left = helper(root.left, true, false, includedMap, notIncludedMap);
            int right = helper(root.right, true, false, includedMap, notIncludedMap);

            result = 1 + left + right;
        }

        if (skipRoot) {
            notIncludedMap.put(root, result);
        } else {
            includedMap.put(root, result);
        }

        return result;
    }

     */

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
