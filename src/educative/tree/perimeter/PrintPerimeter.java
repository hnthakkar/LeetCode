package educative.tree.perimeter;

public class PrintPerimeter {

    public static String displayTreePerimeter(BinaryTreeNode root) {
        List<BinaryTreeNode> nodes = new ArrayList<>();
        addLeftBoundary(root, nodes);
        addLeafNodes(root, nodes);
        addRightBoundary(root.right, nodes);

        return convertListToString(nodes);
    }

    public static String convertListToString(List<BinaryTreeNode> nodes) {
        StringBuilder sb = new StringBuilder();

        for (BinaryTreeNode node: nodes) {
            sb.append(node.data + " ");
        }

        return sb.toString();
    }

    public static void addLeafNodes(BinaryTreeNode root, List<BinaryTreeNode> nodes) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            nodes.add(root);
            return;
        }

        addLeafNodes(root.left, nodes);
        addLeafNodes(root.right, nodes);
    }

    public static void addLeftBoundary(BinaryTreeNode root, List<BinaryTreeNode> nodes) {
        while(root != null) {
            if (root.left != null) {
                nodes.add(root);
            }
            root = root.left;
        }
    }

    public static void addRightBoundary(BinaryTreeNode root, List<BinaryTreeNode> nodes) {
        if (root == null) {
            return;
        }

        addRightBoundary(root.right, nodes);
        if (root.right != null) {
            nodes.add(root);
        }
    }

}
