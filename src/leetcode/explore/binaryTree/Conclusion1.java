package leetcode.explore.binaryTree;

import java.util.Arrays;

public class Conclusion1 {
    public static void main(String[] args) {
        Conclusion1 c = new Conclusion1();
        c.problem1();
        c.problem2();
        c.problem3();
        c.testPrint1();
        c.testPrint2();
    }

    private void problem3() {
        int[] inorder = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};
        int[] postorder = {'A', 'C', 'E', 'D', 'B', 'H', 'I', 'G', 'F'};
        TreeNode t = buildTree(inorder, postorder);
        print2(t);
        System.out.println();
    }

    private void testPrint2() {
        TreeNode t1 = new TreeNode('A');
        TreeNode t3 = new TreeNode('C');
        TreeNode t5 = new TreeNode('E');
        TreeNode t8 = new TreeNode('H');

        TreeNode t4 = new TreeNode('D', t3, t5);
        TreeNode t9 = new TreeNode('I', t8, null);

        TreeNode t2 = new TreeNode('B', t1, t4);
        TreeNode t7 = new TreeNode('G', null, t9);

        TreeNode t6 = new TreeNode('F', t2, t7);
        print2(t6);
        System.out.println();
    }

    private void testPrint1() {
        TreeNode t6 = new TreeNode(15);
        TreeNode t7 = new TreeNode(7);

        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20, t6, t7);

        TreeNode t1 = new TreeNode(3, t2, t3);
        print(t1);
        System.out.println();
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

    private void print2(TreeNode t) {
        if (t == null) {
            return;
        }
        System.out.print((char) t.val + ", ");
        print2(t.left);
        print2(t.right);
    }

    private void problem2() {
        int[] inorder = {-1};
        int[] postorder = {-1};
        TreeNode t = buildTree(inorder, postorder);
        print(t);
        System.out.println();
    }

    private void problem1() {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode t = buildTree(inorder, postorder);
        print(t);
        System.out.println();
    }

    // inorder(중위): left -> root -> right
    // postorder(후위): left -> right -> root
    // postorder을 보고 root을 구한 뒤 inorder에서 root.left와 root.right 파악한다.
    // root.left의 root을 파악한 뒤 -> 반복
    // root.right의 root을 파악한 뒤 -> 반복
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int rootValue = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootValue);
        recursion(root, inorder, postorder);
        return root;
    }

    private void recursion(TreeNode root, int[] inorder, int[] postorder) {
        int rootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                rootIndex = i;
                break;
            }
        }
        // right가 있을 때
        if (rootIndex != inorder.length - 1) {
            TreeNode right = new TreeNode(postorder[postorder.length - 2]);
            root.right = right;
            int[] rightInorder = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
            int[] rightPostorder = Arrays.copyOfRange(postorder, rootIndex, postorder.length - 1);
            recursion(right, rightInorder, rightPostorder);
        }
        // left가 있을 때
        if (rootIndex != 0) {
            TreeNode left = new TreeNode(postorder[rootIndex - 1]);
            root.left = left;
            int[] leftInorder = Arrays.copyOfRange(inorder, 0, rootIndex);
            int[] leftPostorder = Arrays.copyOfRange(postorder, 0, rootIndex);
            recursion(left, leftInorder, leftPostorder);
        }
    }
}
