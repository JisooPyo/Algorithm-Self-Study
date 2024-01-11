package leetcode.explore.binaryTree;

public class Recursive1 {
    public static void main(String[] args) {
        Recursive1 r = new Recursive1();
        r.problem1();
        r.problem2();
    }

    private void problem2() {
        TreeNode t2 = new TreeNode(2);
        TreeNode t1 = new TreeNode(1, null, t2);

        System.out.println(maxDepth(t1));
    }

    private void problem1() {
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);

        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20, t4, t5);

        TreeNode t1 = new TreeNode(3, t2, t3);
        System.out.println(maxDepth(t1));
    }

    // bottom-up
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
