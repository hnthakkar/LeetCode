package tree.serializeDeserializeTree297;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3 {

    public static void main(String[] args) {
        Solution3 sol = new Solution3();

        // [1,2,3,null,null,4,5]
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        sol.serialize(root);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        List<Integer> preOrderList = new ArrayList<>();
        preOrder(root, preOrderList);
        String preString = appendList(preOrderList);

        List<Integer> inOrderList = new ArrayList<>();
        inOrder(root, inOrderList);
        String inString = appendList(inOrderList);


        sb.append(preString).append("#").append(inString);

        System.out.println(sb.toString());

        return sb.toString();
    }

    private String appendList(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for(int item: list) {
            sb.append(item).append(",");
        }

        return sb.toString();
    }

    private void preOrder(TreeNode root, List<Integer> preOrderList) {
        if (root == null) {
            return;
        }

        preOrderList.add(root.val);
        preOrder(root.left, preOrderList);
        preOrder(root.right, preOrderList);
    }

    private void inOrder(TreeNode root, List<Integer> inOrderList) {
        if (root == null) {
            return;
        }

        inOrder(root.left, inOrderList);
        inOrderList.add(root.val);
        inOrder(root.right, inOrderList);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] info = data.split("#");

        if (info.length != 2) {
            return null;
        }

        String[] preString = info[0].split(",");
        String[] intString = info[1].split(",");

        int len = preString.length;

        int[] preOrder = convertStringArrayToIntArray(preString, len);
        int[] inOrder = convertStringArrayToIntArray(intString, len);


        return buildTree(preOrder, inOrder);
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

    private int[] convertStringArrayToIntArray(String[] sArray, int len) {
        int[] result = new int[len];

        for (int i = 0; i < len; i++) {
            result[i] = Integer.parseInt(sArray[i]);
        }

        return result;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    TreeNode(int x, TreeNode left, TreeNode right) {
        val = x;
        this.left = left;
        this.right = right;
    }
}
