package leetcode.explore.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Conclusion5 {
    public static void main(String[] args) {
        Conclusion5 c = new Conclusion5();
        c.problem1();
        c.problem2();
        c.problem3();
    }

    private void problem3() {
        TreeNode t2 = new TreeNode(2);

        TreeNode t1 = new TreeNode(1, t2, null);

        TreeNode answer = lowestCommonAncestor(t1, t1, t2);
        System.out.println(answer.val);
    }

    private void problem2() {
        TreeNode t8 = new TreeNode(7);
        TreeNode t9 = new TreeNode(4);

        TreeNode t4 = new TreeNode(6);
        TreeNode t5 = new TreeNode(2, t8, t9);
        TreeNode t6 = new TreeNode(0);
        TreeNode t7 = new TreeNode(8);

        TreeNode t2 = new TreeNode(5, t4, t5);
        TreeNode t3 = new TreeNode(1, t6, t7);

        TreeNode t1 = new TreeNode(3, t2, t3);

        TreeNode answer = lowestCommonAncestor(t1, t2, t9);
        System.out.println(answer.val);
    }

    private void problem1() {
        TreeNode t8 = new TreeNode(7);
        TreeNode t9 = new TreeNode(4);

        TreeNode t4 = new TreeNode(6);
        TreeNode t5 = new TreeNode(2, t8, t9);
        TreeNode t6 = new TreeNode(0);
        TreeNode t7 = new TreeNode(8);

        TreeNode t2 = new TreeNode(5, t4, t5);
        TreeNode t3 = new TreeNode(1, t6, t7);

        TreeNode t1 = new TreeNode(3, t2, t3);

        TreeNode answer = lowestCommonAncestor(t1, t2, t3);
        System.out.println(answer.val);
    }

    // level-order
    private void print(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (queue.size() != 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode peek = queue.peek();
                System.out.print("val: " + peek.val);
                if (peek.left != null) {
                    System.out.print(", left: " + peek.left.val);
                    queue.add(peek.left);
                } else {
                    System.out.print(", left: null");
                }
                if (peek.right != null) {
                    System.out.print(", right: " + peek.right.val);
                    queue.add(peek.right);
                } else {
                    System.out.print(", right: null");
                }
                queue.poll();
            }
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
