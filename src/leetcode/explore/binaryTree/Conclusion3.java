// Populating Next Right Pointers in Each Node
package leetcode.explore.binaryTree;

public class Conclusion3 {
    public static void main(String[] args) {
        Conclusion3 c = new Conclusion3();
        c.problem1();
    }

    private void problem1() {
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        Node n6 = new Node(6);
        Node n7 = new Node(7);

        Node n2 = new Node(2, n4, n5, null);
        Node n3 = new Node(3, n6, n7, null);

        Node n1 = new Node(1, n2, n3, null);
        Node answer = connect(n1);
        print(answer);
    }

    // preorder(전위): root -> left -> right
    private void print(Node node) {
        if (node == null) {
            return;
        }
        System.out.print("val: " + node.val);
        if (node.left != null) {
            System.out.print(", left: " + node.left.val);
            System.out.print(", right: " + node.right.val);
        } else {
            System.out.print(", leaf node");
        }
        if (node.next != null) {
            System.out.println(", next: " + node.next.val);
        } else {
            System.out.println(", next is null");
        }
        print(node.left);
        print(node.right);
    }

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        recursion(root);
        return root;
    }

    private void recursion(Node root) {
        if (root.left == null) {
            return;
        }
        root.left.next = root.right;
        if (root.next != null) {
            root.right.next = root.next.left;
        }
        recursion(root.left);
        recursion(root.right);
    }
}
