package leetcode.al2408;

import java.util.ArrayList;
import java.util.List;

/**
 * Easy
 * 590. N-ary Tree Postorder Traversal
 *
 * n-ary 트리의 root 가 주어집니다. 노드 값을 후위순회해서 반환하세요.
 */
public class Leet590 {
    List<Integer> list;

    public List<Integer> postorder(Node root) {
        list = new ArrayList<>();
        rec(root);
        return list;
    }

    private void rec(Node root) {
        if (root == null) {
            return;
        }
        if (root.children != null) {
            for (Node child : root.children) {
                rec(child);
            }
        }
        list.add(root.val);
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
