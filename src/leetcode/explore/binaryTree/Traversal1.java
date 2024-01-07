package leetcode.explore.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class Traversal1 {
    public static void main(String[] args) {
        Traversal1 t = new Traversal1();

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
        List<Integer> list = preorderTraversal(t6);
        for (Integer i : list) {
            int element = i;
            char ch = (char) element;
            System.out.print(ch + ", ");
        }
    }

    private void problem3() {
        TreeNode t1 = new TreeNode(1);
        System.out.println(preorderTraversal(t1));
    }

    private void problem2() {
        System.out.println(preorderTraversal(null));
    }

    private void problem1() {
        TreeNode t3 = new TreeNode(3);
        TreeNode t2 = new TreeNode(2, t3, null);
        TreeNode t1 = new TreeNode(1, null, t2);
        System.out.println(preorderTraversal(t1));
    }

    // 전위 순회: 루트 -> 왼쪽 -> 오른쪽
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        list.add(root.val);
        recursive(list, root);
        return list;
    }

    private void recursive(List<Integer> list, TreeNode root) {
        if (root.left != null) {
            list.add(root.left.val);
            recursive(list, root.left);
        }
        if (root.right != null) {
            list.add(root.right.val);
            recursive(list, root.right);
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
