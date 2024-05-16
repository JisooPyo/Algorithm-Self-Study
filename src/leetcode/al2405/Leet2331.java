package leetcode.al2405;

/**
 * 2331. Evaluate Boolean Binary Tree
 *
 * Given
 * root: full binary tree
 *       Leaf node - 0또는 1을 가진다. 0은 false, 1은 true를 나타낸다.
 *       Non-leaf node - 2또는 3을 가진다. 2는 OR 3은 AND를 나타낸다.
 *
 * Return
 * root 노드를 계산했을 때 boolean 결과.
 *
 */
public class Leet2331 {
    // EZ~
    public boolean evaluateTree(TreeNode root) {
        if (root.val == 0 || root.val == 1) {
            return root.val == 1;
        }
        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);

        if (root.val == 2) {
            return left || right;
        } else {
            return left && right;
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
