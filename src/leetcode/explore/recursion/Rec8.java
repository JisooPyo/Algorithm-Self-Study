package leetcode.explore.recursion;

public class Rec8 {
    int count;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        count = 1;
        dfs(root, 1);
        return count;
    }

    private void dfs(TreeNode root, int level) {
        count = Math.max(count, level);
        if (root.left != null) {
            dfs(root.left, level + 1);
        }
        if (root.right != null) {
            dfs(root.right, level + 1);
        }
    }
}
