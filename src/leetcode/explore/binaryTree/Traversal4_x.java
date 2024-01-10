package leetcode.explore.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Traversal4_x {
    public static void main(String[] args) {
        Traversal4_x t = new Traversal4_x();
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
        List<List<Integer>> list = levelOrder(t6);
        List<List<Character>> list2 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            List<Integer> l = list.get(i);
            List<Character> ch = new ArrayList<>();
            for (int j = 0; j < l.size(); j++) {
                ch.add((char) (int) l.get(j));
            }
            list2.add(ch);
        }
        System.out.println(list2);
    }

    private void problem3() {
        TreeNode t1 = new TreeNode(1);
        System.out.println(levelOrder(t1));
    }

    private void problem2() {
        System.out.println(levelOrder(null));
    }

    private void problem1() {
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);

        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20, t4, t5);

        TreeNode t1 = new TreeNode(3, t2, t3);
        System.out.println(levelOrder(t1));
    }

    // 다른 사람의 풀이 보고 이해 후 다시 작성해보기
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                if (queue.peek().left != null) {
                    queue.add(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.add(queue.peek().right);
                }
                level.add(queue.poll().val);
            }
            answer.add(level);
        }
        return answer;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> wrapList = new LinkedList<>();

        if (root == null) return wrapList;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for (int i = 0; i < levelNum; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                subList.add(queue.poll().val);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }
}