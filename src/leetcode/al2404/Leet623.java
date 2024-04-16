package leetcode.al2404;

import java.util.LinkedList;
import java.util.Queue;

public class Leet623 {
    public static void main(String[] args) {
        Leet623 l = new Leet623();
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(1);
        TreeNode t6 = new TreeNode(5);

        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t3 = new TreeNode(6, t6, null);

        TreeNode t1 = new TreeNode(4, t2, t3);
        TreeNode answer = l.addOneRow(t1, 1, 2);
    }

    // 내 풀이
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode t1 = new TreeNode(val);
            t1.left = root;
            return t1;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int curDepth = 2;

        while (curDepth < depth) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode t = queue.poll();
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
            curDepth++;
        }

        while (!queue.isEmpty()) {
            TreeNode left = null;
            TreeNode right = null;
            TreeNode poll = queue.poll();
            if (poll.left != null) {
                left = poll.left;
            }
            if (poll.right != null) {
                right = poll.right;
            }
            poll.left = new TreeNode(val);
            poll.right = new TreeNode(val);
            poll.left.left = left;
            poll.right.right = right;
        }

        return root;
    }
}
