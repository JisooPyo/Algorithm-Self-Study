package leetcode.al2407;

/**
 * Mediym
 * 1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance
 *
 * 주어진 문제는 n개의 도시가 있고, 각 도시는 0부터 n-1까지 번호가 매겨져 있습니다.
 * 배열 edges 는 edges[i] = [from_i, to_i, weight_i] 형태로 주어지며,
 * 이는 from_i 도시와 to_i 도시 사이의 가중치 weight_i를 가지는 양방향 간선을 나타냅니다.
 * 또한 정수 distanceThreshold(거리임계) 가 주어집니다.
 *
 * 문제는 다음과 같습니다:
 *
 * 특정 도시로부터 다른 도시로 도달할 수 있는 경로 중에서
 * 그 경로의 거리 합이 distanceThreshold 이하인 도시의 수가 가장 적은 도시를 찾습니다.
 * 만약 그러한 도시가 여러 개라면, 그 중 도시 번호가 가장 큰 도시를 반환합니다.
 *
 * 경로의 거리는 각 경로를 구성하는 간선의 가중치 합으로 계산됩니다.
 */
public class Leet1334_x {
    public static void main(String[] args) {
        Leet1334_x l = new Leet1334_x();
        int[][] edges1 = {{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}};
        int[][] edges2 = {{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}};

        System.out.println(l.findTheCity(4, edges1, 4));    // 3
        System.out.println(l.findTheCity(5, edges2, 2));    // 0
    }

    // 다른 사람의 풀이 : 10ms
    // 쓰인 알고리즘 : Graph, Dynamic Programming, Shortest Path
    // Floyd-Warshall 알고리즘 공부..!
    public int findTheCity(int n, int[][] edges, int t) {
        int m = edges.length;
        // 1. 그래프 정보 등록
        //   1) 같은 도시끼리의 거리는 0, 그 외는 MAX_VALUE
        int[][] d = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    d[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        //    2) edges 정보 등록
        for (int i = 0; i < m; i++) {
            if (edges[i][2] <= t) {
                d[edges[i][0]][edges[i][1]] = edges[i][2];
                d[edges[i][1]][edges[i][0]] = edges[i][2];
            }
        }

        // 2. Floyd-Warshall 알고리즘을 사용하여 모든 도시 쌍 간의 최단 거리 계산
        //    d[i][j]는 도시 i에서 도시 j로 가는 최단 거리
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (d[i][k] == Integer.MAX_VALUE)
                    continue;
                for (int j = i; j < n; j++) {
                    if (d[k][j] < Integer.MAX_VALUE && d[i][j] > (d[i][k] + d[k][j])) {
                        d[i][j] = d[j][i] = d[i][k] + d[k][j];
                    }
                }
            }
        }

        // 3. 가장 적은 수의 도시로 도달할 수 있는 도시를 찾고, 그러한 도시가 여러 개라면 도시 번호가 가장 큰 도시를 반환.
        int count = n;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            int c = 0;
            for (int j = 0; j < n; j++) {
                if (d[i][j] <= t) {
                    c++;
                }
            }
            if (c <= count) {
                count = c;
                ans = i;
            }
        }
        return ans;
    }
}
