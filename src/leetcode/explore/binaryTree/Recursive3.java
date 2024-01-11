// Path Sum
package leetcode.explore.binaryTree;

public class Recursive3 {
    public static void main(String[] args) {
        Recursive3 r = new Recursive3();
        r.problem1();   // true
        r.problem2();   // false
    }

    private void problem2() {
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);

        TreeNode t1 = new TreeNode(1, t2, t3);
        System.out.println(hasPathSum(t1, 5));
    }

    private void problem1() {
        TreeNode t8 = new TreeNode(7);
        TreeNode t9 = new TreeNode(2);

        TreeNode t15 = new TreeNode(1);

        TreeNode t4 = new TreeNode(11, t8, t9);

        TreeNode t6 = new TreeNode(13);
        TreeNode t7 = new TreeNode(4, null, t15);

        TreeNode t2 = new TreeNode(4, t4, null);
        TreeNode t3 = new TreeNode(8, t6, t7);

        TreeNode t1 = new TreeNode(5, t2, t3);
        System.out.println(hasPathSum(t1, 22));
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return recursion(root, 0, targetSum);
    }

    private boolean recursion(TreeNode root, int sum, int targetSum) {
        if (root == null) {
            return false;
        }
        sum += root.val;
        if (root.left == null && root.right == null) {
            return sum == targetSum;
        }
        boolean left = recursion(root.left, sum, targetSum);
        boolean right = recursion(root.right, sum, targetSum);

        return left || right;
    }
}
