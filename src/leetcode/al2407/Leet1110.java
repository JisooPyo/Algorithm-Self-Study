package leetcode.al2407;

import java.util.ArrayList;
import java.util.List;

/**
 * Medium
 * 1110. Delete Nodes And Return Forest
 *
 * 이진 트리 root 가 주어집니다.
 * 트리의 각 노드는 구별되는 값을 가집니다.
 *
 * to_delete 에 있는 값을 가지는 모든 노드를 삭제하면
 * 포레스트(트리의 분리된 합집합)가 남습니다.
 *
 * 남은 포레스트의 트리들의 root 를 반환하세요.
 * 어떤 순서로든 반환할 수 있습니다.
 */
public class Leet1110 {
    public static void main(String[] args) {
        Leet1110 l = new Leet1110();
        l.problem1();
        l.problem2();
    }

    private void problem2() {
        TreeNode n3 = new TreeNode(3);

        TreeNode n2 = new TreeNode(2, null, n3);
        TreeNode n4 = new TreeNode(4);

        TreeNode n1 = new TreeNode(1, n2, n4);
        int[] to_delete = {3};

        List<TreeNode> list = delNodes(n1, to_delete);
        System.out.println("problem2 list is...");
        for (TreeNode treeNode : list) {
            printTreeNode(treeNode);
            System.out.println("-------");
        }
    }

    private void problem1() {
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        TreeNode n2 = new TreeNode(2, n4, n5);
        TreeNode n3 = new TreeNode(3, n6, n7);

        TreeNode n1 = new TreeNode(1, n2, n3);

        int[] to_delete = {3, 5};

        List<TreeNode> list = delNodes(n1, to_delete);
        System.out.println("problem1 list is...");
        for (TreeNode treeNode : list) {
            printTreeNode(treeNode);
            System.out.println("-------");
        }
    }

    private void printTreeNode(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println("root.val = " + root.val);
        printTreeNode(root.left);
        printTreeNode(root.right);
    }

    List<TreeNode> result;
    boolean[] toDelete;
    // 내 풀이 : 0ms
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        toDelete = new boolean[1001];
        for (int i = 0; i < to_delete.length; i++) {
            toDelete[to_delete[i]] = true;
        }
        result = new ArrayList<>();
        root = rec(root, null);
        if (root != null) {
            result.add(root);
        }
        return result;
    }

    private TreeNode rec(TreeNode cur, TreeNode parent) {
        if (cur == null) {
            return null;
        }
        // ******************************
        cur.left = rec(cur.left, cur);
        cur.right = rec(cur.right, cur);
        // ******************************
        if (toDelete[cur.val]) {
            if (cur.left != null) {
                result.add(cur.left);
            }
            if (cur.right != null) {
                result.add(cur.right);
            }
            return null;  // 삭제된 노드의 부모와의 연결을 끊음
        }
        return cur;
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
