package leetcode.explore.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class Traversal2 {
    public static void main(String[] args) {
        Traversal2 t = new Traversal2();
        t.problem1();
        t.problem2();
        t.problem3();
        t.problem4();
    }

    private void problem4() {
        TreeNode t1 = new TreeNode('A');
        TreeNode t3 = new TreeNode('C');
        TreeNode t5 = new TreeNode('E');
        TreeNode t8 = new TreeNode('H');

        TreeNode t4 = new TreeNode('D', t3, t5);
        TreeNode t9 = new TreeNode('I', t8, null);

        TreeNode t2 = new TreeNode('B', t1, t4);
        TreeNode t7 = new TreeNode('G', null, t9);

        TreeNode t6 = new TreeNode('F', t2, t7);
        List<Integer> list = inorderTraversal(t6);
        for (Integer i : list) {
            int element = i;
            char ch = (char) element;
            System.out.print(ch + ", ");
        }
    }

    private void problem3() {
        TreeNode t1 = new TreeNode(1);
        System.out.println(inorderTraversal(t1));
    }

    private void problem2() {
        System.out.println(inorderTraversal(null));
    }

    private void problem1() {
        TreeNode t3 = new TreeNode(3);
        TreeNode t2 = new TreeNode(2, t3, null);
        TreeNode t1 = new TreeNode(1, null, t2);
        System.out.println(inorderTraversal(t1));
    }

    // 중위순회: 왼쪽, 루트, 오른쪽
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        recursive(list, root);
        return list;
    }

    private void recursive(List<Integer> list, TreeNode root) {
        if (root.left != null) {
            recursive(list, root.left);
        }
        list.add(root.val);
        if (root.right != null) {
            recursive(list, root.right);
        }
    }
}
