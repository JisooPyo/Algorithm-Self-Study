// Symmetric Tree
package leetcode.explore.binaryTree;

public class Recursive2 {
    public static void main(String[] args) {
        Recursive2 r = new Recursive2();
        r.problem1();   // true
        r.problem2();   // false
    }

    private void problem2() {
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(3);

        TreeNode t2 = new TreeNode(2, null, t4);
        TreeNode t3 = new TreeNode(2, null, t5);

        TreeNode t1 = new TreeNode(1, t2, t3);
        System.out.println(isSymmetric(t1));
    }

    private void problem1() {
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(4);

        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(3);

        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t3 = new TreeNode(2, t6, t7);

        TreeNode t1 = new TreeNode(1, t2, t3);
        System.out.println(isSymmetric(t1));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return compare(left.right, right.left) && compare(left.left, right.right);
    }
}
