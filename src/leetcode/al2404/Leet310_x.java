package leetcode.al2404;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Given
 * 0부터 n - 1까지 라벨링된 n개의 노드를 가지는 트리
 * n - 1개의 edges 배열
 *   -> edges[i] = [ai, bi]는 트리에서 두 노드 ai와 bi 사이에 연결된 방향성없는 선을 나타낸다.
 *
 * 어떤 노드든 트리의 root로 선택가능하다.
 * node x를 root로 정한다면, 그 결과 트리는 높이 h를 가진다.
 * 모든 가능한 트리에서 최소 높이를 가지는 트리를 최소 높이 트리(Minimum Height Trees, MHTs)라고 한다.
 *
 * 문제
 * MHT의 root list를 반환하라.
 */
public class Leet310_x {
    public static void main(String[] args) {
        Leet310_x l = new Leet310_x();

        int[][] edges1 = {{1, 0}, {1, 2}, {1, 3}};
        int[][] edges2 = {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};

        System.out.println(l.findMinHeightTrees(4, edges1));
        System.out.println(l.findMinHeightTrees(6, edges2));
    }

    // 내 풀이
    // 시간복잡도 O(N^2) -> 시간 초과
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            return list;
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            if (!map.containsKey(edges[i][0])) {
                Set<Integer> set = new HashSet<>();
                set.add(edges[i][1]);
                map.put(edges[i][0], set);
            } else {
                map.get(edges[i][0]).add(edges[i][1]);
            }
            if (!map.containsKey(edges[i][1])) {
                Set<Integer> set = new HashSet<>();
                set.add(edges[i][0]);
                map.put(edges[i][1], set);
            } else {
                map.get(edges[i][1]).add(edges[i][0]);
            }
        }

        int[] heightRecord = new int[n];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            heightRecord[i] = getTreeHeight(map, n, i);
            min = Math.min(min, heightRecord[i]);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (heightRecord[i] == min) {
                list.add(i);
            }
        }

        return list;
    }

    private int getTreeHeight(Map<Integer, Set<Integer>> map, int total, int root) {
        boolean[] visited = new boolean[total];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        visited[root] = true;
        int height = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int poll = queue.poll();
                for (Integer node : map.get(poll)) {
                    if (!visited[node]) {
                        queue.add(node);
                        visited[node] = true;
                    }
                }
            }
            height++;
        }

        return height;
    }

    // 다른 사람 풀이
    // 나랑 전체적으로 흘러가는 건 비슷한데 getTreeHeight에서 조금 더 효율적으로 이 사람이 코드를 작성한 것 같다.
    // 노드에서 다른 노드까지의 거리를 계산하여 높이를 구함
    public List<Integer> findMinHeightTreesOther(int n, int[][] edges) {
        // 그래프 연결 정보 기록
        int[] counts = new int[n];  // 노드 당 연결된 간선 수
        int[] links = new int[n];   // XOR연산으로 연결된 노드 기록(?)
        for (int[] edge : edges) {
            links[edge[0]] ^= edge[1];
            counts[edge[0]]++;
            links[edge[1]] ^= edge[0];
            counts[edge[1]]++;
        }

        // 리프 노드(간선이 1개인 노드)를 찾아서 큐에 추가
        Queue<Integer> Qu = new LinkedList<>();
        int[] dists = new int[n];
        for (int i = 0; i < n; i++) {
            if (counts[i] == 1)
                Qu.add(i);
        }

        // 큐에서 노드를 꺼내면서 count 배열 업데이트, 간선 수가 1이 되면 다음 단계에서 사용
        // 노드까지의 거리 계산, 거리 업데이트
        int stp = 1;
        while (!Qu.isEmpty()) {
            int size = Qu.size();
            for (int j = 0; j < size; j++) {
                int tmp = Qu.poll();
                links[links[tmp]] ^= tmp;
                counts[links[tmp]]--;
                if (counts[links[tmp]] == 1) {
                    dists[links[tmp]] = Math.max(stp, dists[links[tmp]]);
                    Qu.add(links[tmp]);
                }
            }
            stp++;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(dists[i], max);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dists[i] == max)
                res.add(i);
        }
        return res;
    }
}
