package leetcode.al2406;

/**
 Easy
 1791. Find Center of Star Graph

 n개의 노드가 1부터 n까지 라벨링된 무방향 스타 그래프가 있습니다.
 스타 그래프는 하나의 중심 노드와 중심 노드와 다른 모든 노드를 연결하는, 정확히 n - 1개의 간선이 있는 그래프입니다.
 각 edges[i] = [ui, vi]가 노드 ui와 vi 사이에 간선이 있음을 나타내는 2D 정수 배열 edges가 주어집니다.
 주어진 스타 그래프의 중심을 반환하세요.
 */
public class Leet1791 {
    public static void main(String[] args) {
        Leet1791 l = new Leet1791();

        int[][] edges1 = {{1, 2}, {2, 3}, {4, 2}};
        int[][] edges2 = {{1, 2}, {5, 1}, {1, 3}, {1, 4}};

        System.out.println(l.findCenter(edges1));   // 2
        System.out.println(l.findCenter(edges2));   // 1
    }

    // 내 풀이 : 0ms
    // 푸는 데 걸리는 시간 : 5m
    // edges 의 길이가 n-1이기 때문에 겹치는 점은 중심밖에 없다는 것을 뜻한다.
    // 첫 두 간선에서 겹치는 점이 중심점.
    public int findCenter(int[][] edges) {
        if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) {
            return edges[0][0];
        } else {
            return edges[0][1];
        }
    }
}
