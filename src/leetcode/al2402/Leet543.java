package leetcode.al2402;

public class Leet543 {
    public static void main(String[] args) {
        Leet543 l = new Leet543();
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);

        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t3 = new TreeNode(3);

        TreeNode t1 = new TreeNode(1, t2, t3);
        System.out.println(l.diameterOfBinaryTree(t1));
    }

    int diameter;

    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        helper(root);
        return diameter;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);
        diameter = Math.max(diameter, left + right);

        return Math.max(left, right) + 1;
    }

}
