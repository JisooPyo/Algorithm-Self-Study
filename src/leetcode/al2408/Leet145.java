package leetcode.al2408;

import java.util.ArrayList;
import java.util.List;

/**
 * Easy
 * 145. Binary Tree Postorder Traversal
 *
 * 이진 트리의 root가 주어집니다. 노드들의 값을 postorder 순으로 순회하여 반환하세요.
 */
public class Leet145 {
    List<Integer> list;

    public List<Integer> postorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        postorder(root);
        return list;
    }

    private void postorder(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            postorder(root.left);
        }
        if (root.right != null) {
            postorder(root.right);
        }
        list.add(root.val);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
