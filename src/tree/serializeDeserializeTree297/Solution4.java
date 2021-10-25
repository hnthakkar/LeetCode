package tree.serializeDeserializeTree297;

import java.util.ArrayList;
import java.util.List;

public class Solution4 {

    public static void main(String[] args) {
        Solution4 sol = new Solution4();

        // [1,2,3,null,null,4,5]
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        sol.deserialize(sol.serialize(root));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root ==  null) {
            return "";
        }

        List<String> paths = new ArrayList<>();
        pathHelper(root, "", paths);

        StringBuilder sb = new StringBuilder();

        for (String path: paths) {
            sb.append(path).append("%");
        }

        return sb.toString();
    }

    private void pathHelper(TreeNode root, String pathTillNow, List<String> paths) {
        pathTillNow = pathTillNow + root.val;
        if (root.left == null && root.right == null) {
            // leaf node
            paths.add(pathTillNow);
            return;
        }

        if (root.left != null) {
            pathHelper(root.left, pathTillNow + "#L#", paths);
        }

        if (root.right != null) {
            pathHelper(root.right, pathTillNow + "#R#", paths);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] paths = data.split("%");

        TreeNode root = null;

        for (int i = 0; i < paths.length; i++) {
            String path = paths[i];
            String[] info = path.split("#");
            int len = info.length;

            if (root == null) {
                root = new TreeNode(Integer.parseInt(info[0]));
            }
            TreeNode ref = root;
            int cur = 1;

            while (cur < len) {
                // direction
                String dirction = info[cur];
                int nextNodeVal = Integer.parseInt(info[cur + 1]);

                if ("L".equals(dirction)) {
                    if (ref.left == null) {
                        ref.left = new TreeNode(nextNodeVal);
                    }
                    ref = ref.left;
                } else {
                    if (ref.right == null) {
                        ref.right = new TreeNode(nextNodeVal);
                    }
                    ref = ref.right;
                }

                cur += 2;
            }
        }

        return root;
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
