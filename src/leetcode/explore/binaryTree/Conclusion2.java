// Construct Binary Tree from Preorder and Inorder Traversal
package leetcode.explore.binaryTree;

import java.util.Arrays;

public class Conclusion2 {
    public static void main(String[] args) {
        Conclusion2 c = new Conclusion2();
        c.problem1();
        c.problem2();
        c.problem3();
    }

    // preorder(전위): root -> left -> right
    private void print(TreeNode t) {
        if (t == null) {
            return;
        }
        System.out.print(t.val + ", ");
        print(t.left);
        print(t.right);
    }

    // char일 때
    private void print2(TreeNode t) {
        if (t == null) {
            return;
        }
        System.out.print((char) t.val + ", ");
        print2(t.left);
        print2(t.right);
    }

    private void problem3() {
        int[] preorder = {'F', 'B', 'A', 'D', 'C', 'E', 'G', 'I', 'H'};
        int[] inorder = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};
        TreeNode t = buildTree(preorder, inorder);
        // preorder로 나오면 정답
        print2(t);
        System.out.println();
    }

    private void problem2() {
        int[] preorder = {-1};
        int[] inorder = {-1};
        TreeNode t = buildTree(preorder, inorder);
        print(t);
        System.out.println();
    }

    private void problem1() {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode t = buildTree(preorder, inorder);
        print(t);
        System.out.println();
    }

    // preorder(전위): root -> left -> right
    // inorder(중위): left -> root -> right
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);
        recursion(root, preorder, inorder);
        return root;
    }

    private void recursion(TreeNode root, int[] preorder, int[] inorder) {
        int rootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                rootIndex = i;
                break;
            }
        }
        // right가 있을 때
        if (rootIndex != inorder.length - 1) {
            TreeNode right = new TreeNode(preorder[rootIndex + 1]);
            root.right = right;
            int[] rightInorder = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
            int[] rightPreorder = Arrays.copyOfRange(preorder, rootIndex + 1, preorder.length);
            recursion(right, rightPreorder, rightInorder);
        }
        // left가 있을 때
        if (rootIndex != 0) {
            TreeNode left = new TreeNode(preorder[1]);
            root.left = left;
            int[] leftInorder = Arrays.copyOfRange(inorder, 0, rootIndex);
            int[] leftPreorder = Arrays.copyOfRange(preorder, 1, rootIndex + 1);
            recursion(left, leftPreorder, leftInorder);
        }
    }
}
