package leetcode.al2406;

/**
 Hard
 1579. Remove Max Number of Edges to Keep Graph Fully Traversable

 Alice 와 Bob 은 n개의 노드와 세 가지 유형의 간선이 있는 무방향 그래프를 가지고 있습니다:

 유형 1: Alice 만 통과할 수 있는 간선.
 유형 2: Bob 만 통과할 수 있는 간선.
 유형 3: Alice 와 Bob 모두 통과할 수 있는 간선.

 각 edges[i] = [type_i, u_i, v_i]가 type_i 유형의 간선이
 노드 u_i와 v_i 사이를 양방향으로 연결하는 것을 나타내는 배열 edges 가 주어졌을 때,
 간선을 제거한 후에도 그래프가 Alice 와 Bob 모두에 의해
 완전히 탐색될 수 있도록 할 수 있는 최대 간선 수를 구하세요.
 그래프는 Alice 와 Bob 이 어떤 노드에서 시작하더라도 다른 모든 노드에 도달할 수 있는 경우 완전히 탐색될 수 있다고 합니다.

 제거할 수 있는 최대 간선 수를 반환하고, 만약 Alice와 Bob이 그래프를 완전히 탐색할 수 없다면 -1을 반환하세요.
 */
public class Leet1579_x {
    public static void main(String[] args) {
        Leet1579_x l = new Leet1579_x();

        int[][] edges1 = {{3, 1, 2}, {3, 2, 3}, {1, 1, 3}, {1, 2, 4}, {1, 1, 2}, {2, 3, 4}};
        int[][] edges2 = {{3, 1, 2}, {3, 2, 3}, {1, 1, 4}, {2, 1, 4}};
        int[][] edges3 = {{3, 2, 3}, {1, 1, 2}, {2, 3, 4}};

        System.out.println(l.maxNumEdgesToRemove(4, edges1));   // 2
        System.out.println(l.maxNumEdgesToRemove(4, edges2));   // 0
        System.out.println(l.maxNumEdgesToRemove(4, edges3));   // -1
    }

    // 다른 사람 풀이 : 7ms
    // 쓰인 알고리즘 : Union-Find(합집합 찾기), Disjoint Set(서로소 집합)
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int[] seta = new int[n + 1];    // 앨리스 그룹
        int[] setb = new int[n + 1];    // 밥 그룹
        // set a = [0, 1, 2, 3, ...]
        for (int i = 1; i <= n; i++)
            seta[i] = i;

        // 유형 3의 간선을 먼저 처리하여 Alice와 Bob 모두 사용할 수 있도록 합니다.
        // 이 간선을 통해 두 노드를 같은 그룹으로 묶을 수 있으면 counter3를 증가시킵니다.
        int counter3 = 0;
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (union(seta, edge[1], edge[2]))
                    counter3++;
            }
        }

        // Alice와 Bob의 그룹을 따로따로 관리하기 위해 seta를 setb에 복사합니다.
        // 유형 1 간선은 Alice의 그룹에만 영향을 주고, 유형 2 간선은 Bob의 그룹에만 영향을 줍니다.
        // 각 간선이 두 노드를 같은 그룹으로 묶을 수 있으면 해당 카운터(counter1, counter2)를 감소시킵니다.
        int len = edges.length;
        if (counter3 == n - 1)
            return len - counter3;
        System.arraycopy(seta, 0, setb, 0, n + 1);
        int counter1 = n - 1 - counter3;
        int counter2 = counter1;
        for (int i = 0; i < len && (counter1 > 0 || counter2 > 0); i++) {
            int[] edge = edges[i];
            if (edge[0] == 1) {
                if (counter1 > 0 && union(seta, edge[1], edge[2]))
                    counter1--;
            } else if (edge[0] == 2) {
                if (counter2 > 0 && union(setb, edge[1], edge[2]))
                    counter2--;
            }
        }

        // 만약 아직도 Alice나 Bob이 모든 노드를 연결하지 못했다면 -1을 반환합니다.
        // 그렇지 않으면 제거할 수 있는 간선의 최대 수를 반환합니다.
        if (counter1 > 0 || counter2 > 0)
            return -1;
        return len - 2 * n + 2 + counter3;
    }

    // 노드 u의 대표 노드를 찾습니다. 경로 압축(Path Compression)을 사용하여 탐색 시간을 최적화합니다.
    private int find(int[] set, int u) {
        return set[u] == u ? u : (set[u] = find(set, set[u]));
    }

    // 두 노드를 같은 그룹으로 합칩니다. 두 노드의 대표 노드가 다르면 합치고 true를 반환합니다.
    private boolean union(int[] set, int u, int v) {
        u = find(set, u);
        v = find(set, v);
        if (u != v) {
            set[v] = u;
            return true;
        }
        return false;
    }
}
