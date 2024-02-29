package leetcode.al2402;

import java.util.LinkedList;
import java.util.Queue;

public class Leet1609 {
    public static void main(String[] args) {
        Leet1609 l = new Leet1609();

        TreeNode t7 = new TreeNode(12);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(6);
        TreeNode t10 = new TreeNode(2);

        TreeNode t4 = new TreeNode(3, t7, t8);
        TreeNode t5 = new TreeNode(7, t9, null);
        TreeNode t6 = new TreeNode(9, null, t10);

        TreeNode t2 = new TreeNode(10, t4, null);
        TreeNode t3 = new TreeNode(4, t5, t6);

        TreeNode t1 = new TreeNode(1, t2, t3);

        System.out.println(l.isEvenOddTree(t1));
    }

    // 1 <= node.val <= 1_000_000
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        int odd;
        int even;
        while (!queue.isEmpty()) {
            odd = 1_000_001;
            even = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode peek = queue.peek();
                if (level % 2 == 0) {
                    if (peek.val > even && peek.val % 2 == 1) {
                        even = peek.val;
                        if (peek.left != null) {
                            queue.add(peek.left);
                        }
                        if (peek.right != null) {
                            queue.add(peek.right);
                        }
                        queue.poll();
                    } else {
                        return false;
                    }
                } else {
                    if (peek.val < odd && peek.val % 2 == 0) {
                        odd = peek.val;
                        if (peek.left != null) {
                            queue.add(peek.left);
                        }
                        if (peek.right != null) {
                            queue.add(peek.right);
                        }
                        queue.poll();
                    } else {
                        return false;
                    }
                }
            }
            level++;
        }
        return true;
    }
}
