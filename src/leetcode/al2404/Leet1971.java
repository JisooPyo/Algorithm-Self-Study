package leetcode.al2404;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 문제.
 * n개의 꼭짓점을 가지는 양방향 그래프가 있다.
 * 각 꼭짓점은 0부터 n-1까지 구성되어 있다.
 * 선은 배열 edges로 나타내며, i번째 꼭짓점 ui와 i번째 꼭짓점 vi 사이에 선은 edges[i] = [ui, vi]로 나타낸다.
 * 모든 꼭짓점끼리는 많아도 한 개의 선으로만 연결되어 있다.
 * 자신을 연결하는 꼭짓점은 없다.
 *
 * 시작점부터 도착점까지 유효한 경로가 있는지 boolean으로 반환하라.
 */
public class Leet1971 {
    public static void main(String[] args) {
        Leet1971 l = new Leet1971();

        int[][] edges1 = {{0, 1}, {1, 2}, {2, 0}};
        int[][] edges2 = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
        int[][] edges3 = {{}};
        int[][] edges4 = {
            {31, 5}, {10, 46}, {19, 31}, {5, 1}, {31, 28},
            {28, 29}, {8, 26}, {13, 23}, {16, 34}, {30, 1},
            {16, 18}, {33, 46}, {27, 35}, {2, 25}, {49, 33},
            {44, 19}, {22, 26}, {30, 13}, {27, 12}, {8, 16},
            {42, 13}, {18, 3}, {21, 20}, {2, 17}, {5, 48},
            {41, 37}, {39, 37}, {2, 11}, {20, 26}, {19, 43},
            {45, 7}, {0, 21}, {44, 23}, {2, 39}, {27, 36},
            {41, 48}, {17, 42}, {40, 32}, {2, 28}, {35, 38},
            {3, 9}, {41, 30}, {5, 11}, {24, 22}, {39, 5},
            {40, 31}, {18, 35}, {23, 39}, {20, 24}, {45, 12}
        };

        // System.out.println(l.validPath(3, edges1, 0, 2));
        // System.out.println(l.validPath(6, edges2, 0, 5));
        // System.out.println(l.validPath(1, edges3, 0, 0));
        System.out.println(l.validPath(50, edges4, 29, 46));
    }

    // 내 풀이
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) {
            return true;
        }
        // map을 이용하여 graph 정보 저장
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            if (map.containsKey(edges[i][0])) {
                map.get(edges[i][0]).add(edges[i][1]);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(edges[i][1]);
                map.put(edges[i][0], set);
            }
            if (map.containsKey(edges[i][1])) {
                map.get(edges[i][1]).add(edges[i][0]);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(edges[i][0]);
                map.put(edges[i][1], set);
            }
        }

        // BFS를 이용하여 root 파악
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        for (Integer i : map.get(source)) {
            queue.add(i);
            visited[i] = true;
        }
        visited[source] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int ver = queue.poll();
                if (ver == destination) {
                    return true;
                }
                for (Integer element : map.get(ver)) {
                    if (!visited[element]) {
                        queue.add(element);
                        visited[element] = true;
                    }
                }
            }
        }
        return false;
    }

    // 다른 사람 풀이
    // visited 배열을 만들어 source를 true로 체크한다.
    // visited값이 다른지 확인하면서 source와 연결되어 있는 그래프를 방문한다.
    // 방문하면서 목적지를 방문했는지 계속 체크해준다.
    // 중간에 목적지를 방문하게 되면 true
    // 목적지를 방문하지 않고 더 이상 방문할 꼭짓점이 없으면 false를 return한다.
    public boolean validPathOther(int n, int[][] edges, int source, int destination) {
        if (edges.length == 0)
            return true;
        boolean[] visited = new boolean[n];
        boolean flag = true;
        visited[source] = true;
        while (flag) {
            flag = false;
            for (int[] edge : edges) {
                if (visited[edge[0]] != visited[edge[1]]) {
                    visited[edge[0]] = true;
                    visited[edge[1]] = true;
                    flag = true;
                }
                if (visited[destination])
                    return true;
            }
        }
        return false;
    }
}
