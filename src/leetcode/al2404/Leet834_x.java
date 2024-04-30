package leetcode.al2404;

import java.util.Arrays;

public class Leet834_x {
    public static void main(String[] args) {
        Leet834_x l = new Leet834_x();

        int[][] edges1 = {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};
        int[][] edges2 = {{}};
        int[][] edges3 = {{1, 0}};

        // [8, 12, 6, 10, 10, 10]
        System.out.println(Arrays.toString(l.sumOfDistancesInTree(6, edges1)));
        // [0]
        System.out.println(Arrays.toString(l.sumOfDistancesInTree(1, edges2)));
        // [1, 1]
        System.out.println(Arrays.toString(l.sumOfDistancesInTree(2, edges3)));
    }

    int[][] graph;
    int[] count;
    int[] res;
    int N;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.N = n;                     // 노드 수
        this.res = new int[n];          // 각 노드를 루트로 하는 서브트리의 거리 합
        this.graph = new int[n][];      // 노드에 연결된 노드
        this.count = new int[n];        // 노드에서 시작하는 서브트리의 노드 수

        // 그래프 구성
        for (int[] e : edges) {
            ++count[e[0]];
            ++count[e[1]];
        }
        for (int i = 0; i < n; i++) {
            graph[i] = new int[count[i]];
        }
        for (int[] e : edges) {
            graph[e[0]][--count[e[0]]] = e[1];
            graph[e[1]][--count[e[1]]] = e[0];
        }
        dfs1(0, -1);
        dfs2(0, -1);
        return res;
    }

    // 각 노드를 루트로 하는 서브트리의 거리 합 계산
    public void dfs1(int cur, int parent) {
        count[cur] = 1;
        for (int child : graph[cur]) {
            if (child != parent) {
                dfs1(child, cur);
                count[cur] += count[child];
                res[cur] += res[child] + count[child];
            }
        }
    }

    // 각 노드에서 시작하는 서브트리의 거리 합 계산
    public void dfs2(int cur, int parent) {
        for (int child : graph[cur]) {
            if (child != parent) {
                res[child] = res[cur] + N - 2 * count[child];
                dfs2(child, cur);
            }
        }
    }
}
