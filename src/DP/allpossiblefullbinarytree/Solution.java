package DP.allpossiblefullbinarytree;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.allPossibleFBT(3);
    }

    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> empty = Collections.<TreeNode>emptyList();

        if (n % 2 == 0) {
            return empty;
        }

        List<TreeNode> singleNode = new ArrayList<>();
        singleNode.add(new TreeNode(0));
        if (n == 1) {
            return singleNode;
        }

        Map<Integer, List<TreeNode>> dp = new HashMap<>();
        dp.put(0, empty);
        dp.put(1, singleNode);

        return allPossibleFBTHelper(n, dp);
    }

    private List<TreeNode> allPossibleFBTHelper(int n, Map<Integer, List<TreeNode>> dp) {
        if (dp.containsKey(n)) {
            return dp.get(n);
        }

        List<TreeNode> listOfNodes = new ArrayList<>();

        for (int l = 0; l < n - 1; l++) {
            int r = n -1 - l;

            List<TreeNode> leftSubTree = l % 2 == 0 ? dp.get(0) : allPossibleFBTHelper(l, dp);
            List<TreeNode> rightSubTree = r % 2 == 0 ? dp.get(0) : allPossibleFBTHelper(r, dp);

            for (TreeNode sl : leftSubTree) {
                for (TreeNode sr : rightSubTree) {
                    listOfNodes.add(new TreeNode(0, sl, sr));
                }
            }
        }

        dp.put(n, listOfNodes);

        return listOfNodes;
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