package leetcode.al11;

public class Leet617 {
    public static void main(String[] args) {
        Leet617 leet617 = new Leet617();

        TreeNode t3 = new TreeNode(5);
        TreeNode t1 = new TreeNode(3, t3, null);
        TreeNode t2 = new TreeNode(2);
        TreeNode t0 = new TreeNode(1, t1, t2);

        TreeNode r4 = new TreeNode(4);
        TreeNode r6 = new TreeNode(7);
        TreeNode r1 = new TreeNode(1, null, r4);
        TreeNode r2 = new TreeNode(3, null, r6);
        TreeNode r0 = new TreeNode(2, r1, r2);

        System.out.println(leet617.mergeTrees(t0, r0).val);
        System.out.println(leet617.mergeTrees(t0, r0).left.val);
        System.out.println(leet617.mergeTrees(t0, r0).left.left.val);
        System.out.println(leet617.mergeTrees(t0, r0).left.right.val);
        System.out.println(leet617.mergeTrees(t0, r0).right.val);
        System.out.println(leet617.mergeTrees(t0, r0).right.right.val);
        // 3 4 5 4 5 7
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode root = new TreeNode();
        return dfs(root, root1, root2);
    }

    private TreeNode dfs(TreeNode root, TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        int i1 = root1 == null ? 0 : root1.val;
        int i2 = root2 == null ? 0 : root2.val;

        root.val = i1 + i2;

        TreeNode left = new TreeNode();
        root.left = dfs(left, root1 == null ? null : root1.left, root2 == null ? null : root2.left);

        TreeNode right = new TreeNode();
        root.right = dfs(right, root1 == null ? null : root1.right, root2 == null ? null : root2.right);

        return root;
    }
}
