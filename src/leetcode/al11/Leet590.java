package leetcode.al11;

import java.util.ArrayList;
import java.util.List;

public class Leet590 {
    public static void main(String[] args) {
        Leet590 leet590 = new Leet590();
        Node n14 = new Node(14);
        List<Node> list1 = new ArrayList<>();
        list1.add(n14);

        Node n11 = new Node(11, list1);
        Node n12 = new Node(12);
        Node n13 = new Node(13);
        List<Node> list2 = new ArrayList<>();
        list2.add(n11);
        List<Node> list3 = new ArrayList<>();
        list3.add(n12);
        List<Node> list4 = new ArrayList<>();
        list4.add(n13);

        Node n6 = new Node(6);
        Node n7 = new Node(7, list2);
        Node n8 = new Node(8, list3);
        Node n9 = new Node(9, list4);
        Node n10 = new Node(10);
        List<Node> list5 = new ArrayList<>();
        list5.add(n6);
        list5.add(n7);
        List<Node> list6 = new ArrayList<>();
        list6.add(n8);
        List<Node> list7 = new ArrayList<>();
        list7.add(n9);
        list7.add(n10);

        Node n2 = new Node(2);
        Node n3 = new Node(3, list5);
        Node n4 = new Node(4, list6);
        Node n5 = new Node(5, list7);
        List<Node> list8 = new ArrayList<>();
        list8.add(n2);
        list8.add(n3);
        list8.add(n4);
        list8.add(n5);

        Node n1 = new Node(1, list8);

        System.out.println(leet590.postorder(n1));
    }

    // postorder: Left -> Right -> Root
    List<Integer> answer;

    public List<Integer> postorder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        answer = new ArrayList<>();
        dfs(root);
        return answer;
    }

    private void dfs(Node root) {
        if (root.children != null) {
            while (root.children.size() != 0) {
                dfs(root.children.get(0));
                root.children.remove(root.children.get(0));
            }
        }
        if (root.children == null || root.children.size() == 0) {
            answer.add(root.val);
        }
    }
}
