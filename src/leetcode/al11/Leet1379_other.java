package leetcode.al11;

public class Leet1379_other {
    // declare reference to result node
    public TreeNode reference;

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        // start depth first search traversal
        dfs(original, cloned, target);
        // return found reference
        return reference;
    }

    // declare dfs function
    public void dfs(TreeNode original, TreeNode cloned, TreeNode target) {
        // check if we have original node
        if (original == null) return;
        // check if we found target node in original tree, if true set reference to current cloned node
        if (original.val == target.val) this.reference = cloned;
        // traverse further to the left
        dfs(original.left, cloned.left, target);
        // traverse further to the right
        dfs(original.right, cloned.right, target);
    }
}
