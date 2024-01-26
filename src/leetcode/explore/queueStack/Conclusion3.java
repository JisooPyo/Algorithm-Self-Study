package leetcode.explore.queueStack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Conclusion3 {
    public static void main(String[] args) {
        Conclusion3 c = new Conclusion3();
        // [[0, 0, 0], [0, 1, 0], [0, 0, 0]]
        int[][] mat1 = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        // [[0, 0, 0], [0, 1, 0], [1, 2, 1]]
        int[][] mat2 = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        System.out.println(Arrays.deepToString(c.updateMatrix(mat1)));
        System.out.println(Arrays.deepToString(c.updateMatrix(mat2)));
    }

    public int[][] updateMatrix(int[][] mat) {
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        int[][] answer = new int[mat.length][mat[0].length];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int x = queue.peek()[0];
                int y = queue.peek()[1];
                answer[x][y] = count;
                if (x != 0 && !visited[x - 1][y]) {
                    queue.add(new int[]{x - 1, y});
                    visited[x - 1][y] = true;
                }
                if (x != mat.length - 1 && !visited[x + 1][y]) {
                    queue.add(new int[]{x + 1, y});
                    visited[x + 1][y] = true;
                }
                if (y != 0 && !visited[x][y - 1]) {
                    queue.add(new int[]{x, y - 1});
                    visited[x][y - 1] = true;
                }
                if (y != mat[0].length - 1 && !visited[x][y + 1]) {
                    queue.add(new int[]{x, y + 1});
                    visited[x][y + 1] = true;
                }
                queue.poll();
            }
            count++;
        }
        return answer;
    }

    // 시간초과
    public int[][] updateMatrix1(int[][] mat) {
        int[][] answer = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    continue;
                }
                answer[i][j] = getDistance(mat, i, j);// 0과의 거리 구하기
            }
        }
        return answer;
    }

    private int getDistance(int[][] mat, int i, int j) {
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});

        loop1:
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int x = queue.peek()[0];
                int y = queue.peek()[1];
                visited[x][y] = true;
                if (mat[x][y] == 0) {
                    break loop1;
                }
                if (x != 0 && !visited[x - 1][y]) {
                    queue.add(new int[]{x - 1, y});
                }
                if (x != mat.length - 1 && !visited[x + 1][y]) {
                    queue.add(new int[]{x + 1, y});
                }
                if (y != 0 && !visited[x][y - 1]) {
                    queue.add(new int[]{x, y - 1});
                }
                if (y != mat[0].length - 1 && !visited[x][y + 1]) {
                    queue.add(new int[]{x, y + 1});
                }
                queue.poll();
            }
            count++;
        }
        return count;
    }
}
