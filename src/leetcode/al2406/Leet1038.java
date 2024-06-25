package leetcode.al2406;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 Medium
 1038. Binary Search Tree to Greater Sum Tree

 Given
 root: BST(Binary Search Tree)의 root

 root 를 더 큰 트리로 바꾸자.
 더 큰 트리로 바꾼다는 것은 원래 BST 의 모든 key 를 key + 원래 키보다 큰 모든 키들의 합 으로 바꾸는 것이다.
 주어진 BST 는 다음과 같은 특징을 만족한다.
 - 노드의 left subtree 는 노드의 key 보다 작은 값을 key 로 가져야 한다.
 - 노드의 right subtree 는 노드의 key 보다 큰 값을 key 로 가져야 한다.
 - left, right subtree 역시 이 조건을 만족하는 BST 여야 한다.

 ex.
 0에서 8까지 값을 가지고 있는 노드가 있다고 하자.
 0 : +1 +2 +3 +4 +5 +6 +7 +8 -> 36
 1 : +2 +3 +4 +5 +6 +7 +8 -> 36
 2 : +3 +4 +5 +6 +7 +8 -> 35
 3 : +4 +5 +6 +7 +8 -> 33
 4 : +5 +6 +7 +8 -> 30
 5 : +6 +7 +8 -> 26
 6 : +7 +8 -> 21
 7 : +8 -> 15
 8 : 더 큰 값이 없음 +0 -> 8
 */
public class Leet1038 {
    public static void main(String[] args) {
        Leet1038 l = new Leet1038();
        l.problem1();
    }

    private void problem1() {
        TreeNode t3 = new TreeNode(3);
        TreeNode t8 = new TreeNode(8);

        TreeNode t0 = new TreeNode(0);
        TreeNode t2 = new TreeNode(2, null, t3);
        TreeNode t5 = new TreeNode(5);
        TreeNode t7 = new TreeNode(7, null, t8);

        TreeNode t1 = new TreeNode(1, t0, t2);
        TreeNode t6 = new TreeNode(6, t5, t7);

        TreeNode t4 = new TreeNode(4, t1, t6);

        TreeNode answer = bstToGst(t4);
        printTreeNode(answer);
    }

    private void printTreeNode(TreeNode answer) {
        System.out.print("root : " + answer.val + " (left : ");
        if (answer.left != null) {
            System.out.print(answer.left.val + "   ");
        } else {
            System.out.print("null");
        }
        System.out.print(", right : ");
        if (answer.right != null) {
            System.out.println(answer.right.val + ")");
        } else {
            System.out.println("null)");
        }
        if (answer.left != null) {
            printTreeNode(answer.left);
        }
        if (answer.right != null) {
            printTreeNode(answer.right);
        }
    }

    // 내 풀이 : 1ms
    // 걸린 시간 : 20분
    List<Integer> list;
    Map<Integer, Integer> map;

    public TreeNode bstToGst(TreeNode root) {
        list = new ArrayList<>();
        saveKey(root);
        Collections.sort(list);
        // 원래 값 + 더해야 할 값
        map = new HashMap<>();
        int sum = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            map.put(list.get(i), sum);
            sum += list.get(i);
        }
        plusKey(root);
        return root;
    }

    private void plusKey(TreeNode root) {
        root.val += map.get(root.val);
        if (root.left != null) {
            plusKey(root.left);
        }
        if (root.right != null) {
            plusKey(root.right);
        }
    }

    private void saveKey(TreeNode root) {
        list.add(root.val);
        if (root.left != null) {
            saveKey(root.left);
        }
        if (root.right != null) {
            saveKey(root.right);
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
