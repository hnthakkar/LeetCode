package linkedlist.cloneGraph133;

import java.util.*;

public class Solution {

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        
        Map<Integer, Node> nodeMapping = new HashMap<>();

        Node newHeadNode = null;

        Queue<Node> q = new LinkedList();
        q.add(node);
        Set<Integer> visited = new HashSet<>();
        visited.add(node.val);

        while (!q.isEmpty()) {
            Node curNode = q.poll();

            Node newCurNode = null;
            if (nodeMapping.containsKey(curNode.val)) {
                newCurNode = nodeMapping.get(curNode.val);
            } else {
                newCurNode = new Node(curNode.val);
                nodeMapping.put(curNode.val, newCurNode);
            }

            if (newHeadNode == null) {
                newHeadNode = newCurNode;
            }

            newCurNode.neighbors = new ArrayList<>();
            for (Node neighbour: curNode.neighbors) {
                Node newListNeighbour = null;
                if (nodeMapping.containsKey(neighbour.val)) {
                    newListNeighbour = nodeMapping.get(neighbour.val);
                } else {
                    newListNeighbour = new Node(neighbour.val);
                    nodeMapping.put(neighbour.val, newListNeighbour);
                }

                newCurNode.neighbors.add(newListNeighbour);

                if (!visited.contains(neighbour.val)) {
                    q.add(neighbour);
                    visited.add(neighbour.val);
                }
            }

        }

        return newHeadNode;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
