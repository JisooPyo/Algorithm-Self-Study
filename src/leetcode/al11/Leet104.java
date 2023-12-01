package leetcode.al11;

public class Leet104 {
    public static void main(String[] args) {
        Leet104 leet104 = new Leet104();
        TreeNode t5 = new TreeNode(15);
        TreeNode t6 = new TreeNode(7);

        TreeNode t1 = new TreeNode(9);
        TreeNode t2 = new TreeNode(20, t5, t6);

        TreeNode t0 = new TreeNode(3, t1, t2);

        System.out.println(leet104.maxDepth(t0));
    }

    // dfs 아닌가..
    int maxDepth = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return maxDepth;
        }
        bfs(root, 0);
        return maxDepth;
    }

    private void bfs(TreeNode root, int depth) {
        depth++;
        maxDepth = Math.max(depth, maxDepth);
        if (root.left == null && root.right == null) {
            return;
        }
        if (root.left != null) {
            bfs(root.left, depth);
        }
        if (root.right != null) {
            bfs(root.right, depth);
        }
    }
}
