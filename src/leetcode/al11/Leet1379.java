// Find a Corresponding Node of a Binary Tree in a Clone of That Tree
package leetcode.al11;

public class Leet1379 {
    public static void main(String[] args) {
        Leet1379 leet1379 = new Leet1379();
        TreeNode t0 = new TreeNode(7);
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(3);
        TreeNode t5 = new TreeNode(6);
        TreeNode t6 = new TreeNode(19);
        t0.left = t1;
        t0.right = t2;
        t2.left = t5;
        t2.right = t6;
        TreeNode answer = leet1379.getTargetCopy(t0, t0, t2);
        System.out.println(answer.val);
        System.out.println(answer.left.val);
        System.out.println(answer.right.val);
    }

    public final TreeNode getTargetCopy(
            final TreeNode original,
            final TreeNode cloned,
            final TreeNode target) {
        return dfs(original, cloned, target);
    }

    private TreeNode dfs(TreeNode original, TreeNode cloned, TreeNode target) {
        TreeNode answer = null;
        if (cloned.val == target.val) {
            return cloned;
        } else {
            if (original.left != null) {
                TreeNode leftnode = dfs(original.left, cloned.left, target);
                if (leftnode != null) {
                    answer = leftnode;
                }
            }
            if (original.right != null) {
                TreeNode rightNode = dfs(original.right, cloned.right, target);
                if (rightNode != null) {
                    answer = rightNode;
                }
            }
        }
        return answer;
    }
}
