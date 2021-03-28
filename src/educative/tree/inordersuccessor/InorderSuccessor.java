package educative.tree.inordersuccessor;

public class InorderSuccessor {
    static BinaryTreeNode inorderSuccessorBST(BinaryTreeNode root, int d) {
        BinaryTreeNode[] parentChildNodes = findNodeInTree(root, d);

        BinaryTreeNode parent = parentChildNodes[0];
        BinaryTreeNode node = parentChildNodes[1];

        // Node itself not found
        if (node == null) {
            return null;
        }

        if (node.right != null) {
            BinaryTreeNode immideateRightNode = node.right;

            if (immideateRightNode.left == null) {
                // case 1
                return immideateRightNode;
            }

            BinaryTreeNode leftMostNode = immideateRightNode.left;
            while (leftMostNode.left != null) {
                leftMostNode = leftMostNode.left;
            }
            // case 2
            return leftMostNode;
        } else {
            if (d > root.data) {
                if (parent.data < d) {
                    // rightmost node
                    return null;
                } else {
                    return parent;
                }
            } else {
                // left side of the tree and right child is null
                if (parent.data > d) {
                    return parent;
                } else {
                    BinaryTreeNode[] parentChild1 = findNodeInTree(root, parent.data);
                    while (parentChild1[0].data < parentChild1[1].data) {
                        parentChild1 = findNodeInTree(root, parentChild1[0].data);
                    }
                    return parentChild1[0];
                }
            }
        }
    }

    static BinaryTreeNode[] findNodeInTree(BinaryTreeNode root, int d) {
        BinaryTreeNode[] parentChild = new BinaryTreeNode[2];
        if (root == null) {
            return parentChild;
        }

        if (root.data == d) {
            parentChild[0] = null;
            parentChild[1] = root;
            return parentChild;
        }

        BinaryTreeNode parent = null;
        BinaryTreeNode child = root;

        while (child != null) {
            if (child.data == d) {
                break;
            }

            if (child.data > d) {
                parent = child;
                child = child.left;
            } else {
                parent = child;
                child = child.right;
            }
        }

        parentChild[0] = parent;
        parentChild[1] = child;

        return parentChild;
    }
}
