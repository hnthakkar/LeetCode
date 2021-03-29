package educative.tree.isvalidbst;

public class IsValidBST {
    public static boolean isBst(BinaryTreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        getInOrder(root, nodes);

        return validateInOrderSorted(nodes);
    }

    private static boolean validateInOrderSorted(List<Integer> nodes) {
        int prev = Integer.MIN_VALUE;

        for (int node: nodes) {
            if (node < prev) {
                return false;
            }
            prev = node;
        }

        return true;
    }

    private static void getInOrder(BinaryTreeNode root, List<Integer> nodes) {
        if (root == null) {
            return;
        }
        getInOrder(root.left, nodes);
        nodes.add(root.data);
        getInOrder(root.right, nodes);
    }
}
