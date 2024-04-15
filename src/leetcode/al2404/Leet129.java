package leetcode.al2404;

public class Leet129 {
    public static void main(String[] args) {
        Leet129 l = new Leet129();
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(1);

        TreeNode t2 = new TreeNode(9, t4, t5);
        TreeNode t3 = new TreeNode(0);

        TreeNode t1 = new TreeNode(4, t2, t3);
        System.out.println(l.sumNumbers(t1));   // 1026
    }

    // 내 풀이
    public int sumNumbers(TreeNode root) {
        return getSum(root, root.val);
    }

    private int getSum(TreeNode root, int i) {
        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = getSum(root.left, root.left.val + i * 10);
        }
        if (root.right != null) {
            right = getSum(root.right, root.right.val + i * 10);
        }
        if (root.left == null && root.right == null) {
            return i;
        }
        return left + right;
    }
}
