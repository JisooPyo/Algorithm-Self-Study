package programmers.test2311;

import java.util.LinkedList;

public class ShortestPathInGameMap {

    public static void main(String[] args) {
        ShortestPathInGameMap shortPath = new ShortestPathInGameMap();
        int[][] maps1 = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        // 11
        int[][] maps2 = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}};
        // - 1
        System.out.println(shortPath.solution(maps1));
        System.out.println(shortPath.solution(maps2));
    }

    int[] bx = {1, 0, -1, 0};
    int[] by = {0, 1, 0, -1};

    public int solution(int[][] maps) {
        int[][] visited = new int[maps.length][maps[0].length];
        visited[0][0] = 1;
        bfs(visited, maps);
        int answer = visited[maps.length - 1][maps[0].length - 1];
        if (answer == 0) {
            answer = -1;
        }
        return answer;
    }

    private void bfs(int[][] visited, int[][] maps) {
        LinkedList<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0, 0});
        while (queue.size() != 0) {
            int[] start = queue.poll();
            int ax = start[0];
            int ay = start[1];

            for (int i = 0; i < 4; i++) {
                int nx = ax + bx[i];
                int ny = ay + by[i];
                if (nx < 0 || nx == visited.length || ny < 0 || ny == visited[0].length) {
                    continue;
                }
                if (visited[nx][ny] == 0 && maps[nx][ny] == 1) {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = visited[ax][ay] + 1;
                }
            }
        }
    }
}
