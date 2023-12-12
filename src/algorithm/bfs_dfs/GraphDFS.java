package algorithm.bfs_dfs;

import java.util.Iterator;
import java.util.LinkedList;

class GraphDFS {
    private int V; // 노드의 수
    private LinkedList<Integer>[] adjList; // 인접 리스트 배열

    // 그래프 초기화
    GraphDFS(int v) {
        V = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adjList[i] = new LinkedList();
    }

    // 간선 추가
    void addEdge(int v, int w) {
        adjList[v].add(w);
    }

    // DFS 탐색
    void DFS(int v) {
        boolean visited[] = new boolean[V];
        DFSUtil(v, visited);
    }

    // 재귀를 통한 DFS 탐색
    private void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");

        Iterator<Integer> iterator = adjList[v].listIterator();
        while (iterator.hasNext()) {
            int n = iterator.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    public static void main(String args[]) {
        GraphDFS g = new GraphDFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
//        g.addEdge(3, 3);

        System.out.println("DFS 탐색 결과 (시작 노드: 0): ");
        g.DFS(0);

        System.out.println("\nDFS 탐색 결과 (시작 노드: 1): ");
        g.DFS(1);

        System.out.println("\nDFS 탐색 결과 (시작 노드: 2): ");
        g.DFS(2);

        System.out.println("\nDFS 탐색 결과 (시작 노드: 3): ");
        g.DFS(3);
    }
}

