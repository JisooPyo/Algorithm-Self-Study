package leetcode.explore.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Conclusion4 {
    public static void main(String[] args) {
        Conclusion4 c = new Conclusion4();
//        c.problem1();
//        c.problem2();
        c.problem3();
    }

    private void problem3() {
        Node n13 = new Node(7);

        Node n8 = new Node(2);
        Node n9 = new Node(1);
        Node n10 = new Node(0, n13, null, null);
        Node n11 = new Node(8);
        Node n12 = new Node(8);

        Node n4 = new Node(0, n8, null, null);
        Node n5 = new Node(7, n9, n10, null);
        Node n6 = new Node(9);
        Node n7 = new Node(1, n11, n12, null);

        Node n2 = new Node(1, n4, n5, null);
        Node n3 = new Node(3, n6, n7, null);

        Node n1 = new Node(2, n2, n3, null);
        Node answer = connect(n1);
        print(answer);
    }

    private void problem2() {
        Node answer = connect(null);
        print(answer);  // x
    }

    private void problem1() {
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        Node n7 = new Node(7);

        Node n2 = new Node(2, n4, n5, null);
        Node n3 = new Node(3, null, n7, null);

        Node n1 = new Node(1, n2, n3, null);
        Node answer = connect(n1);
        print(answer);
    }

    // level-order
    private void print(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (queue.size() != 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node peek = queue.peek();
                System.out.print("val: " + peek.val);
                if (peek.left != null) {
                    System.out.print(", left: " + peek.left.val);
                    queue.add(peek.left);
                } else {
                    System.out.print(", left: null");
                }
                if (peek.right != null) {
                    System.out.print(", right: " + peek.right.val);
                    queue.add(peek.right);
                } else {
                    System.out.print(", right: null");
                }
                if (peek.next != null) {
                    System.out.println(", next: " + peek.next.val);
                } else {
                    System.out.println(", next: null");
                }
                queue.poll();
            }
        }
    }

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() != 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node peek = queue.peek();
                if (peek.left != null) {
                    if (peek.right != null) {
                        peek.left.next = peek.right;
                    } else {
                        Node pointer = peek.next;
                        while (pointer != null) {
                            if (pointer.left != null) {
                                peek.left.next = pointer.left;
                                break;
                            }
                            if (pointer.right != null) {
                                peek.left.next = pointer.right;
                                break;
                            }
                            pointer = pointer.next;
                        }
                    }
                    queue.add(peek.left);
                }
                if (peek.right != null) {
                    Node pointer = peek.next;
                    while (pointer != null) {
                        if (pointer.left != null) {
                            peek.right.next = pointer.left;
                            break;
                        }
                        if (pointer.right != null) {
                            peek.right.next = pointer.right;
                            break;
                        }
                        pointer = pointer.next;
                    }
                    queue.add(peek.right);
                }
                queue.poll();
            }
        }
        return root;
    }
}
