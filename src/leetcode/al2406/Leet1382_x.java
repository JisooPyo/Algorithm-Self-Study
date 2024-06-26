package leetcode.al2406;

import java.util.ArrayList;
import java.util.List;

/**
 Medium
 1382. Balance a Binary Search Tree

 Given
 root: 이진 탐색 트리

 Return
 같은 노드 값을 가지는 균형 이진 탐색 트리를 반환하라.
 만약 답이 한 개 이상 있다면 그들 중 아무거나 하나를 반환하라.

 균형 이진 탐색 트리는 모든 노드의 두 서브트리 깊이 차이가 1을 넘지 않는 경우를 말합니다.
 */
public class Leet1382_x {
    public static void main(String[] args) {
        Leet1382_x l = new Leet1382_x();
        l.problem1();
    }

    private void problem1() {
        TreeNode t15 = new TreeNode(15);
        TreeNode t14 = new TreeNode(14);
        TreeNode t13 = new TreeNode(13);
        TreeNode t12 = new TreeNode(12);
        TreeNode t11 = new TreeNode(11);
        TreeNode t10 = new TreeNode(10);
        TreeNode t9 = new TreeNode(9);
        TreeNode t8 = new TreeNode(8);
        TreeNode t7 = new TreeNode(7, t14, t15);
        TreeNode t6 = new TreeNode(6, t12, t13);
        TreeNode t5 = new TreeNode(5, t10, t11);
        TreeNode t4 = new TreeNode(4, t8, t9);
        TreeNode t3 = new TreeNode(3, t6, t7);
        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t1 = new TreeNode(1, t2, t3);
        //           1
        //     2          3
        //  4    5     6     7
        // 8 9 10 11 12 13 14 15

        printBST(balanceBST(t1));
    }

    private void printBST(TreeNode node) {
        System.out.print("val : " + node.val + ", left : ");
        if (node.left != null) {
            System.out.print(node.left.val + ", right : ");
        } else {
            System.out.print("null, right : ");
        }
        if (node.right != null) {
            System.out.println(node.right.val);
        } else {
            System.out.println("null");
        }
        if (node.left != null) {
            printBST(node.left);
        }
        if (node.right != null) {
            printBST(node.right);
        }
    }

    // 다른 사람의 풀이 : 2ms
    // 왜 내 풀이가 틀렸는지 잘 모르겠다.. ;ㅅ; 나도 List에 value를 저장한 후 트리 만들어 return 하는 것으로 풀긴 했는데..
    // 왜 틀렸는지 알아냄.
    // 이진 탐색 트리는 이진 트리 기반의 "탐색"을 위한 자료구조이다.
    // 따라서 왼쪽 서브 트리 키들은 루트 키보다 작고, 오른쪽 서브 트리의 키들은 루트의 키보다 크다는 특징이 있다.
    // 이 키대로 배치를 하기 위해서 다른 사람은 in-order의 방식으로 value를 수집하여 정렬을 해둔 것.
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> sortedElements = new ArrayList<>();
        inOrderTraversal(root, sortedElements);
        return buildBalancedBST(sortedElements, 0, sortedElements.size() - 1);
    }

    // left, root, right 의 순으로 List에 저장된다.(in-order)
    private void inOrderTraversal(TreeNode node, List<Integer> sortedElements) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, sortedElements);
        sortedElements.add(node.val);
        inOrderTraversal(node.right, sortedElements);
    }

    private TreeNode buildBalancedBST(List<Integer> elements, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(elements.get(mid));
        node.left = buildBalancedBST(elements, start, mid - 1);
        node.right = buildBalancedBST(elements, mid + 1, end);
        return node;
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
