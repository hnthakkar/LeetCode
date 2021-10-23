package tree.serializeDeserializeTree297;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /*
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.val);

        serializeNode(root, sb);

        System.out.println(sb.toString());
        return sb.toString();
    }

    private void serializeNode(TreeNode root, StringBuilder sb) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        if (root.right != null) {
            sb.append(",");
            sb.append(root.val + "#" + "R" + "#" + root.right.val);
        }

        if (root.left != null) {
            sb.append(",");
            sb.append(root.val + "#" + "L" + "#" + root.left.val);
        }

        serializeNode(root.left, sb);
        serializeNode(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("".equals(data)) {
            return null;
        }

        String[] edges = data.split(",");
        int noOfEdges = edges.length;

        Map<Integer, TreeNode> treeNodeIndex = new HashMap<>();
        TreeNode root = new TreeNode(Integer.parseInt(edges[0]));
        treeNodeIndex.put(Integer.parseInt(edges[0]), root);

        for (int i = 1; i < noOfEdges; i++) {
            String curEdge = edges[i];
            // System.out.print("\n curEdge : " + curEdge + " i : " + i);

            String[] detail = curEdge.split("#");

            // from Node
            int fromNodeVal = Integer.parseInt(detail[0]);
            TreeNode fromNode;
            if (treeNodeIndex.containsKey(fromNodeVal)) {
                fromNode = treeNodeIndex.get(fromNodeVal);
            } else {
                fromNode = new TreeNode(fromNodeVal);
                treeNodeIndex.put(fromNodeVal, fromNode);
            }

            // To Node
            int toNodeVal = Integer.parseInt(detail[2]);
            TreeNode toNode;
            if (treeNodeIndex.containsKey(toNodeVal)) {
                toNode = treeNodeIndex.get(toNodeVal);
            } else {
                toNode = new TreeNode(toNodeVal);
                treeNodeIndex.put(toNodeVal, toNode);
            }

            if (detail[1].equals("L")) {
                fromNode.left = toNode;
            } else {
                fromNode.right = toNode;
            }
        }

        return null;
    }

     */
}

/*
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


 */