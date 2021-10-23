package tree.deleteNode450;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)), new TreeNode(6, null, new TreeNode(7)));
        sol.deleteNode(root, 7);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val > key) {
            root.left =  deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right =  deleteNode(root.right, key);
        } else {
            // root is the ndoe to be deleted

            if (root.left == null && root.right == null) {
                return null;
            }

            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            // root has both left and right child
            // find inOrder successor

            TreeNode inOrderSuccessor = findInOrderSuccessor(root.right);
            root.val = inOrderSuccessor.val;

            root.right = deleteNode(root.right, inOrderSuccessor.val);
        }

        return root;
    }

    private TreeNode findInOrderSuccessor(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }

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
