package leetcode.al2402;

import java.util.LinkedList;
import java.util.Queue;

public class Leet513 {
    int left;

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode peek = queue.peek();
                if (i == 0) {
                    left = peek.val;
                }
                if (peek.left != null) {
                    queue.add(peek.left);
                }
                if (peek.right != null) {
                    queue.add(peek.right);
                }
                queue.poll();
            }
        }
        return left;
    }

    // 다른 사람 풀이
    int leftmost = 0;
    int leftmostrow = -1;

    void visit(TreeNode root, int depth) {
        if (root == null)
            return;
        if (depth > leftmostrow) {
            leftmost = root.val;
            leftmostrow = depth;
        }
        visit(root.left, depth + 1);
        visit(root.right, depth + 1);
    }

    public int findBottomLeftValue2(TreeNode root) {
        visit(root, 0);
        return leftmost;
    }
}
