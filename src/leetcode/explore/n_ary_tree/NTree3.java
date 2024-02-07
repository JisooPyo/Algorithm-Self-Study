package leetcode.explore.n_ary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NTree3 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> sublist = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.peek();
                if (node.children != null) {
                    queue.addAll(node.children);
                }
                sublist.add(node.val);
                queue.poll();
            }
            list.add(sublist);
        }
        return list;
    }
}
