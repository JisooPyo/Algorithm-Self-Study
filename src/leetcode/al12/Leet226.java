// Invert Binary Tree
package leetcode.al12;

import leetcode.al11.TreeNode;

public class Leet226 {
    public static void main(String[] args) {
        Leet226 leet226 = new Leet226();

        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(6);
        TreeNode t6 = new TreeNode(9);

        TreeNode t1 = new TreeNode(2, t3, t4);
        TreeNode t2 = new TreeNode(7, t5, t6);

        TreeNode t0 = new TreeNode(4, t1, t2);

        TreeNode answer = leet226.invertTree(t0);
        print(answer);

    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        bfs(root);
        return root;
    }

    private void bfs(TreeNode root) {
        if (root.left != null || root.right != null) {
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;
        }
        if (root.left != null) {
            bfs(root.left);
        }
        if (root.right != null) {
            bfs(root.right);
        }
    }

    private static void print(TreeNode answer) {
        System.out.print(answer.val + ", ");
        if (answer.left != null) {
            print(answer.left);
        }
        if (answer.right != null) {
            print(answer.right);
        }
    }
}
