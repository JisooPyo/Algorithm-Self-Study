package algorithm;

import java.util.Iterator;
import java.util.LinkedList;

class GraphBFS {
    private int V; // 노드의 수
    private LinkedList<Integer>[] adjList; // 인접 리스트

    // 그래프 초기화
    GraphBFS(int v) {
        V = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adjList[i] = new LinkedList();
    }

    // 간선 추가
    void addEdge(int v, int w) {
        adjList[v].add(w);
    }

    // BFS 탐색
    void BFS(int start) {
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (queue.size() != 0) {
            start = queue.poll();
            System.out.print(start + " ");

            Iterator<Integer> iterator = adjList[start].listIterator();
            while (iterator.hasNext()) {
                int n = iterator.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String args[]) {
        GraphBFS g = new GraphBFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
//        g.addEdge(3, 3);

        System.out.println("BFS 탐색 결과 (시작 노드: 2): ");
        g.BFS(2);
    }
}

