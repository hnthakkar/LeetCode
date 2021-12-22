package tree.distributeCoinsInBT979;

public class Solution {

    public static void main(String[] str) {
        Solution sol = new Solution();
        TreeNode root = new TreeNode(1, new TreeNode(0, null, new TreeNode(3)), new TreeNode(0));
        System.out.println(sol.distributeCoins(root));
    }

    public int distributeCoins(TreeNode root) {
        DistributionInfo tree = helper(root);
        return tree.moves;
    }

    private DistributionInfo helper(TreeNode root) {
        if (root == null) {
            return new DistributionInfo(0, 0, 0);
        }

        if (root.left == null && root.right == null) {
            return new DistributionInfo(1, root.val, 0);
        }


        DistributionInfo leftSubTree = helper(root.left);
        DistributionInfo rightSubTree = helper(root.right);

        int noOfNodes = leftSubTree.numberOfNode + rightSubTree.numberOfNode + 1;
        int noOfCoins = leftSubTree.noOfCoins + rightSubTree.noOfCoins + root.val;
        int moves = leftSubTree.moves + rightSubTree.moves + Math.abs(leftSubTree.numberOfNode - leftSubTree.noOfCoins)
                + Math.abs(rightSubTree.numberOfNode - rightSubTree.noOfCoins);

        return new DistributionInfo(noOfNodes, noOfCoins, moves);
    }

    /*
    public int distributeCoins(TreeNode root) {
        if (root.left == null && root.right == null) {
            if (root.val > 1) {
                return root.val - 1;
            } else if (root.val == 1) {
                return 0;
            } else {
                return 1;
            }
        }

        int count = 0;

        int leftSubTree = root.left != null ? distributeCoins(root.left) : -1;

        if (leftSubTree > 1) {
            count = leftSubTree;
            root.val += leftSubTree;
        } else if (leftSubTree == 0) {
            count = 1;
            root.val -= 1;
        }

        int rightSubTree = root.right != null ? distributeCoins(root.right) : -1;

        if (rightSubTree > 1) {
            count += rightSubTree;
            root.val += rightSubTree;
        } else if (rightSubTree == 0) {
            count += 1;
            root.val -= 1;
        }

        if (root.val == 0) {
            return count + (count - 1);
        } else if (root.val > 1) {
            return count + (root.val - 1);
        } else {
            return count + count;
        }
    }

     */


}

class DistributionInfo {

    int numberOfNode;
    int noOfCoins;
    int moves;

    public DistributionInfo(int pNumberOfNode, int pNoOfCoins, int pMoves) {
        numberOfNode = pNumberOfNode;
        noOfCoins = pNoOfCoins;
        moves = pMoves;
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

