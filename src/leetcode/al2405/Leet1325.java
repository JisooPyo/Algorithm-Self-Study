package leetcode.al2405;

/**
 * 1325. Delete Leaves With a Given Value
 *
 * Given
 * root: 이진 트리
 * target: 정수
 *
 * target 값을 가진 leaf node를 모두 제거하라.
 */
public class Leet1325 {
    // 내 풀이
    // 재귀로 쉽게 풀었다!
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        TreeNode left = null;
        if (root.left != null) {
            left = removeLeafNodes(root.left, target);
            if (left == null) {
                root.left = null;
            }
        }

        TreeNode right = null;
        if (root.right != null) {
            right = removeLeafNodes(root.right, target);
            if (right == null) {
                root.right = null;
            }
        }
        if (left == null && right == null && root.val == target) {
            return null;
        } else {
            return root;
        }
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
