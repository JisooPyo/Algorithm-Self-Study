// Serialize and Deserialize Binary Tree
package leetcode.explore.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Conclusion6 {
    public static void main(String[] args) {
        Conclusion6 c = new Conclusion6();
//        c.problem1();
//        c.problem2();
        c.problem3();
    }

    private void problem3() {
        String data = "[1,2,3,null,null,4,5,6,7]";
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);

        TreeNode t4 = new TreeNode(4, t6, t7);
        TreeNode t5 = new TreeNode(5);

        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3, t4, t5);

        TreeNode t1 = new TreeNode(1, t2, t3);
        System.out.println(serialize(t1));
        TreeNode answer = deserialize(data);
        print(answer);
    }

    private void problem2() {
        String data = "[]";
        TreeNode t1 = null;
        System.out.println(serialize(t1));
        TreeNode answer = deserialize(data);
        print(answer);
    }

    private void problem1() {
        String data = "[1,2,3,null,null,4,5]";
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);

        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3, t4, t5);

        TreeNode t1 = new TreeNode(1, t2, t3);
        System.out.println(serialize(t1));
        TreeNode answer = deserialize(data);
        print(answer);
    }

    // level-order
    private void print(TreeNode node) {
        if (node == null) {
            System.out.println("node is null");
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (queue.size() != 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode peek = queue.peek();
                System.out.print("val: " + peek.val);
                if (peek.left != null) {
                    System.out.print(", left: " + peek.left.val);
                    queue.add(peek.left);
                } else {
                    System.out.print(", left: null");
                }
                if (peek.right != null) {
                    System.out.println(", right: " + peek.right.val);
                    queue.add(peek.right);
                } else {
                    System.out.println(", right: null");
                }
                queue.poll();
            }
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append(root.val);
        sb.append(',');
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode peek = queue.peek();
                if (peek.left == null) {
                    sb.append("null,");
                } else {
                    sb.append(peek.left.val);
                    sb.append(',');
                    queue.add(peek.left);
                }
                if (peek.right == null) {
                    sb.append("null,");
                } else {
                    sb.append(peek.right.val);
                    sb.append(',');
                    queue.add(peek.right);
                }
                queue.poll();
            }
        }
        while (sb.charAt(sb.length() - 2) == 'l') {
            sb.delete(sb.length() - 5, sb.length());
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(']');
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) {
            return null;
        }
        String trim = data.substring(1, data.length() - 1);
        String[] elements = trim.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(elements[0]));
        queue.add(root);
        int index = 1;
        while (index < elements.length) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode peek = queue.peek();
                if (!elements[index].equals("null")) {
                    peek.left = new TreeNode(Integer.parseInt(elements[index]));
                    queue.add(peek.left);
                }
                index++;
                if (index == elements.length) {
                    break;
                }
                if (!elements[index].equals("null")) {
                    peek.right = new TreeNode(Integer.parseInt(elements[index]));
                    queue.add(peek.right);
                }
                index++;
                if (index == elements.length) {
                    break;
                }
                queue.poll();
            }
        }
        return root;
    }
}
