package leetcode.explore.recursion;

public class Rec4 {
    public static void main(String[] args) {
        Rec4 r = new Rec4();

        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(3);

        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t3 = new TreeNode(7);

        TreeNode t1 = new TreeNode(4, t2, t3);
        TreeNode answer = r.searchBST(t1, 2);
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root.val == val) {
            return root;
        }
        TreeNode left = null;
        TreeNode right = null;
        if (root.left != null) {
            left = searchBST(root.left, val);
        }
        if (left != null) {
            return left;
        }
        if (root.right != null) {
            right = searchBST(root.right, val);
        }
        if (right != null) {
            return right;
        }
        return null;
    }
}
