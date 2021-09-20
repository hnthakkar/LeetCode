package educative.tree.isvalidbst;

public class IsValidBST {
    public static boolean isBst(BinaryTreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        getInOrder(root, nodes);

        if (nodes.size() == 1) {
            return true;
        }

        return validateInOrderSorted(nodes);
    }

    private static boolean validateInOrderSorted(List<Integer> nodes) {
        int len = nodes.size();
        int prev = nodes.get(0);

        for (int i = 1; i < len; i++) {
            int cur = nodes.get(i);
            if (cur <= prev) {
                return false;
            }
            prev = cur;
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
