package leetcode.explore.queueStack;

import java.util.*;

public class DFS1 {
    public static void main(String[] args) {
        DFS1 d = new DFS1();
        d.problem1();
    }

    private void problem1() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        List<Node> list1 = new ArrayList<>();
        list1.add(n2);
        list1.add(n4);

        List<Node> list2 = new ArrayList<>();
        list2.add(n1);
        list2.add(n3);

        List<Node> list3 = new ArrayList<>();
        list3.add(n2);
        list3.add(n4);

        List<Node> list4 = new ArrayList<>();
        list4.add(n1);
        list4.add(n3);
        n1.neighbors = list1;
        n2.neighbors = list2;
        n3.neighbors = list3;
        n4.neighbors = list4;

        Node answer = cloneGraph(n1);
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Integer, Node> map = new HashMap<>();
        Set<Node> visited = new HashSet<>();
        Node clone = new Node(node.val);
        dfs(map, visited, node, clone);
        return clone;
    }

    private void dfs(Map<Integer, Node> map, Set<Node> visited, Node node, Node clone) {
        if (visited.contains(clone)) {
            return;
        }
        visited.add(clone);
        if (!map.containsKey(clone.val)) {
            map.put(clone.val, clone);
        }
        List<Node> newNeighbors = new ArrayList<>();
        for (Node n : node.neighbors) {
            if (map.containsKey(n.val)) {
                newNeighbors.add(map.get(n.val));
            } else {
                Node newNeighbor = new Node(n.val);
                map.put(n.val, newNeighbor);
                newNeighbors.add(newNeighbor);
                dfs(map, visited, n, newNeighbor);
            }
        }
        clone.neighbors = newNeighbors;

    }
}
