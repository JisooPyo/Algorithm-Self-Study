package leetcode.explore.n_ary_tree;

public class NTree4 {
    int count;

    public int maxDepth(Node root) {
        count = 0;
        if (root == null) {
            return count;
        }
        dfs(root, 1);
        return count;
    }

    private void dfs(Node root, int level) {
        if (count < level) {
            count = level;
        }
        if (root.children != null) {
            for (Node child : root.children) {
                dfs(child, level + 1);
            }
        }
    }

}
