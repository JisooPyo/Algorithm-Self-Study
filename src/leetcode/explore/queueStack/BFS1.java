package leetcode.explore.queueStack;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFS1 {
    public static void main(String[] args) {
        BFS1 b = new BFS1();
//        b.problem1();
//        b.problem2();
//        b.problem3();
//        b.problem4();
        b.problem5();
    }

    private void problem5() {
        char[][] grid = {
                {'1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '0', '1', '1'},
                {'0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '0'},
                {'1', '0', '1', '1', '1', '0', '0', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '0', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '0', '1', '1', '1', '0', '1', '1', '1'},
                {'0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '0', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '0', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'0', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1'},
                {'1', '0', '1', '1', '1', '1', '1', '0', '1', '1', '1', '0', '1', '1', '1', '1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '0', '1', '1', '1', '1', '0', '0'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'}
        };
        System.out.println(numIslands(grid));
    }

    private void problem4() {
        char[][] grid = {
                {'1', '0', '1', '1', '1'},
                {'1', '0', '1', '0', '1'},
                {'1', '1', '1', '0', '1'}
        };
        System.out.println(numIslands(grid));   // 1

    }

    private void problem3() {
        char[][] grid = {{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}};
        System.out.println(numIslands(grid));   // 1
    }

    private void problem2() {
        char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        System.out.println(numIslands(grid));   // 3
    }

    private void problem1() {
        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println(numIslands(grid));   // 1
    }

    // 간단하게.. 풀자 queue & while 이외에 재귀 방법도 있다.

    // 다른 사람의 풀이 - 1ms
    int r;
    int c;
    char[][] a;
    int count;

    public int numIslands2(char[][] grid) {
        r = grid.length;
        c = grid[0].length;
        a = grid;
        count = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    visit(i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void visit(int i, int j) {
        a[i][j] = 2;
        if (i - 1 >= 0 && a[i - 1][j] == '1') {
            visit(i - 1, j);
        }
        if (i + 1 < r && a[i + 1][j] == '1') {
            visit(i + 1, j);
        }
        if (j - 1 >= 0 && a[i][j - 1] == '1') {
            visit(i, j - 1);
        }
        if (j + 1 < c && a[i][j + 1] == '1') {
            visit(i, j + 1);
        }
    }

    // 내 풀이 - 375ms
    public int numIslands(char[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    checkIsland(i, j, visited, grid);
                    count++;
                }
            }
        }
        return count;
    }

    private void checkIsland(int i, int j, boolean[][] visited, char[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.add(new int[]{i, j});
        set.add(i + "," + j);
        int iMax = grid.length - 1;
        int jMax = grid[0].length - 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] peek = queue.peek();
                visited[peek[0]][peek[1]] = true;
                if (peek[0] != iMax && grid[peek[0] + 1][peek[1]] == '1' && !visited[peek[0] + 1][peek[1]]) {
                    int w = peek[0] + 1;
                    int h = peek[1];
                    if (!set.contains(w + "," + h)) {
                        queue.add(new int[]{w, h});
                        set.add(w + "," + h);
                    }
                }
                if (peek[1] != jMax && grid[peek[0]][peek[1] + 1] == '1' && !visited[peek[0]][peek[1] + 1]) {
                    queue.add(new int[]{peek[0], peek[1] + 1});
                    int w = peek[0];
                    int h = peek[1] + 1;
                    if (!set.contains(w + "," + h)) {
                        queue.add(new int[]{w, h});
                        set.add(w + "," + h);
                    }
                }
                if (peek[0] != 0 && grid[peek[0] - 1][peek[1]] == '1' && !visited[peek[0] - 1][peek[1]]) {
                    queue.add(new int[]{peek[0] - 1, peek[1]});
                    int w = peek[0] - 1;
                    int h = peek[1];
                    if (!set.contains(w + "," + h)) {
                        queue.add(new int[]{w, h});
                        set.add(w + "," + h);
                    }
                }
                if (peek[1] != 0 && grid[peek[0]][peek[1] - 1] == '1' && !visited[peek[0]][peek[1] - 1]) {
                    queue.add(new int[]{peek[0], peek[1] - 1});
                    int w = peek[0];
                    int h = peek[1] - 1;
                    if (!set.contains(w + "," + h)) {
                        queue.add(new int[]{w, h});
                        set.add(w + "," + h);
                    }
                }
                queue.poll();
            }
        }
    }
}
