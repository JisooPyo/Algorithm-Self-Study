package leetcode.al2406;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 Medium
 2192. All Ancestors of a Node in a Directed Acyclic Graph

 Directed Acyclic Graph(DAG)의 노드들의 수를 나타내는 양의 정수 n이 주어진다.
 노드들은 0부터 n-1까지 넘버링된다.
 2D 정수 배열 edges 도 주어지며,
 edges[i] = [from i, to i] 는 그래프에서 `from i`부터 `to i`까지 연결하는 단방향의 edge 를 의미한다.
 answer[i]가 i번째 노드의 조상들의 list 이고 오름차순으로 정렬된, List answer 을 반환하라.
 노드 u는 u가 edges 의 집합을 통해 v에 도달할 수 있다면 다른 노드 v의 조상이다.
 */
public class Leet2192_x {
    public static void main(String[] args) {
        Leet2192_x l = new Leet2192_x();

        int[][] edgeList1 = {{0, 3}, {0, 4}, {1, 3}, {2, 4}, {2, 7}, {3, 5}, {3, 6}, {3, 7}, {4, 6}};
        int[][] edgeList2 = {{0, 1}, {0, 2}, {0, 3}, {0, 4}, {1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4}, {3, 4}};
        // [[],[],[],[0,1],[0,2],[0,1,3],[0,1,2,3,4],[0,1,2,3]]
        System.out.println(l.getAncestors(8, edgeList1));
        // [[],[0],[0,1],[0,1,2],[0,1,2,3]]
        System.out.println(l.getAncestors(5, edgeList2));
    }

    // 내 풀이 : Time Limit Exceeded
    public List<List<Integer>> getAncestorsTLE(int n, int[][] edges) {
        List<List<Integer>> records = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            records.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            records.get(edges[i][1]).add(edges[i][0]);
        }

        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            answer.add(new ArrayList<>());
        }

        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).isEmpty()) {
                continue;
            }
            Set<Integer> set = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>(records.get(i));
            set.addAll(records.get(i));
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    int peek = queue.peek();
                    queue.addAll(records.get(peek));
                    set.addAll(records.get(peek));
                    queue.poll();
                }
            }
            answer.get(i).addAll(set);
            Collections.sort(answer.get(i));
        }
        return answer;
    }

    // 다른 사람 풀이
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(new ArrayList<>());
        }

        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
        }

        for (int i = 0; i < n; i++) {
            dfs(graph, i, i, res, new boolean[n]);
        }

        for (int i = 0; i < n; i++) {
            res.get(i).sort(Integer::compareTo);
        }

        return res;
    }

    private void dfs(ArrayList<Integer>[] graph, int parent, int curr, List<List<Integer>> res, boolean[] visit) {
        visit[curr] = true;
        for (int dest : graph[curr]) {
            if (!visit[dest]) {
                res.get(dest).add(parent);
                dfs(graph, parent, dest, res, visit);
            }
        }
    }
}
