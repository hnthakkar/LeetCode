package tree.serializeDeserializeTree297;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution1 {

    /*
    public static void main(String[] args) {
        Solution1 sol = new Solution1();

        // [1,2,3,null,null,4,5]
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        sol.serialize(root);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        TreeNode nullNode = new TreeNode(1001);
        boolean levelHasValidEntry = true;

        while (levelHasValidEntry) {
            int size = q.size();
            levelHasValidEntry = false;

            while (size > 0) {
                TreeNode curNode = q.poll();
                size--;
                sb.append(curNode.val + ",");

                if (curNode.val == 1001) {
                    q.add(nullNode);
                    q.add(nullNode);
                    continue;
                }

                if (curNode.left != null) {
                    q.add(curNode.left);
                    levelHasValidEntry = true;
                } else {
                    q.add(nullNode);
                }

                if (curNode.right != null) {
                    q.add(curNode.right);
                    levelHasValidEntry = true;
                } else {
                    q.add(nullNode);
                }
            }
        }

        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("".equals(data)) {
            return null;
        }

        String[] nodes = data.split(",");
        int noOfNodes = nodes.length - 1;

        TreeNode[] visitedNode = new TreeNode[noOfNodes];

        for (int i = 0; i < noOfNodes; i++) {
            if (nodes[i].equals("1001")) {
                continue;
            }

            if (visitedNode[i] == null) {
                visitedNode[i] = new TreeNode(Integer.parseInt(nodes[i]));
            }

            // left Child
            int leftChildIndex = (i * 2) + 1;
            if (leftChildIndex < noOfNodes && !nodes[leftChildIndex].equals("1001")) {
                visitedNode[leftChildIndex] = new TreeNode(Integer.parseInt(nodes[leftChildIndex]));
                visitedNode[i].left = visitedNode[leftChildIndex];
            }

            // right child
            int rightChildIndex = (i * 2) + 2;
            if (rightChildIndex < noOfNodes && !nodes[rightChildIndex].equals("1001")) {
                visitedNode[rightChildIndex] = new TreeNode(Integer.parseInt(nodes[rightChildIndex]));
                visitedNode[i].right = visitedNode[rightChildIndex];
            }
        }

        return visitedNode[0];
    }

     */
}

/*
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

 */
