package educative.tree.deletezerosubtree;

public class DelZeroSum {

    public static void deleteZeroSumSubtree(BinaryTree tree) {
        System.out.println("Root Node : " + tree.root.data);
        markZeroSumSubTree(tree.root);
        deleteAllZeroMarkedNode(tree.root);
    }

    private static void deleteAllZeroMarkedNode(BinaryTreeNode tree) {
        if (tree == null) {
            return;
        }

        if (tree.left != null && tree.left.data == 0) {
            tree.left = null;
        } else {
            deleteAllZeroMarkedNode(tree.left);
        }

        if (tree.right != null && tree.right.data == 0) {
            tree.right = null;
        } else {
            deleteAllZeroMarkedNode(tree.right);
        }
    }

    private static void markZeroSumSubTree(BinaryTreeNode tree) {
        if (tree == null || (tree.left == null && tree.right == null)) {
            return;
        }


        markZeroSumSubTree(tree.left);
        markZeroSumSubTree(tree.right);

        int leftData = subTreeWeight(tree.left);
        System.out.println("LeftData of :" + tree.data + "is : " + leftData);
        int rightData = subTreeWeight(tree.right);
        System.out.println("RightData of :" + tree.data + "is : " + rightData);

        if (leftData + rightData + tree.data == 0) {
            System.out.println("Marking all child zero..");
            markAllChildZero(tree);
        }
    }

    private static void markAllChildZero(BinaryTreeNode tree) {
        if (tree == null) {
            return;
        }

        System.out.println("Mark Node Zero :" + tree.data);
        tree.data = 0;
        markAllChildZero(tree.left);
        markAllChildZero(tree.right);
    }

    private static int subTreeWeight(BinaryTreeNode tree) {
        if (tree == null) {
            return 0;
        }

        int leftWeight = subTreeWeight(tree.left);
        int rightWeight = subTreeWeight(tree.right);

        return tree.data + leftWeight + rightWeight;
    }

    public static String convertListToString(List<BinaryTreeNode> nodes) {
        StringBuilder sb = new StringBuilder();

        for (BinaryTreeNode node: nodes) {
            sb.add(node.data + " ");
        }

        return sb.toString();
    }
}
