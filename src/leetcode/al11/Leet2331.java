package leetcode.al11;

public class Leet2331 {
    public static void main(String[] args) {
        Leet2331 leet2331 = new Leet2331();
        TreeNode t5 = new TreeNode(0);
        TreeNode t6 = new TreeNode(1);

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(3, t5, t6);

        TreeNode t0 = new TreeNode(2, t1, t2);

        System.out.println(leet2331.evaluateTree(t0));
    }

    public boolean evaluateTree(TreeNode root) {
        while (!(root.val == 0 || root.val == 1)) {
            dfs(root);
        }
        return root.val == 1;
    }

    private void dfs(TreeNode root) {
        if (root.left != null) {
            if (isLeftAndRightBoolean(root)) {
                boolean left = root.left.val == 1;
                boolean right = root.right.val == 1;
                if (root.val == 3) {
                    root.val = left && right ? 1 : 0;
                }
                if (root.val == 2) {
                    root.val = left || right ? 1 : 0;
                }
                root.left = null;
                root.right = null;
                return;
            }
            dfs(root.left);
            dfs(root.right);
        }
    }

    private static boolean isLeftAndRightBoolean(TreeNode root) {
        return (root.left.val == 0 || root.left.val == 1) && (root.right.val == 0 || root.right.val == 1);
    }

    private void printTree(TreeNode root) {
        System.out.print(root.val + ", ");
        if (root.left != null) {
            printTree(root.left);
            printTree(root.right);
        }
    }
}
