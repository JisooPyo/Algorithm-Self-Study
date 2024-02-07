package leetcode.explore.n_ary_tree;

import java.util.ArrayList;
import java.util.List;

public class NTree2 {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        rec(list, root);
        return list;
    }

    private void rec(List<Integer> list, Node root) {
        if (root.children != null) {
            for (Node node : root.children) {
                if (node.children != null) {
                    rec(list, node);
                }
            }
        }
        list.add(root.val);
    }
}
