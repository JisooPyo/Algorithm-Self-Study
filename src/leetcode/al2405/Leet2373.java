package leetcode.al2405;

import java.util.Arrays;

/**
 * 2373. Largest Local Values in a Matrix
 *
 * Given
 * grid: n * n 정수 배열
 *
 * return
 * 크기가 (n - 2) * (n - 2)인 정수 배열 maxLocal
 *   - maxLocal[i][j]는 grid에서 [i, j]을 중심으로 하는 3 * 3 배열 중 가장 큰 값이다.
 */
public class Leet2373 {
    public static void main(String[] args) {
        Leet2373 l = new Leet2373();

        int[][] grid1 = {{9, 9, 8, 1}, {5, 6, 2, 6}, {8, 2, 6, 4}, {6, 2, 2, 2}};
        int[][] grid2 = {{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 2, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}};

        System.out.println(Arrays.deepToString(l.largestLocal(grid1)));
        System.out.println(Arrays.deepToString(l.largestLocal(grid2)));
    }

    int[][] grid;

    // 단순탐색
    public int[][] largestLocal(int[][] grid) {
        this.grid = grid;
        int n = grid.length;
        int[][] largest = new int[n - 2][n - 2];

        for (int i = 0; i < largest.length; i++) {
            for (int j = 0; j < largest.length; j++) {
                largest[i][j] = getLargest(i, j);
            }
        }
        return largest;
    }

    private int getLargest(int x, int y) {
        int max = Integer.MIN_VALUE;
        for (int i = x; i <= x + 2; i++) {
            for (int j = y; j <= y + 2; j++) {
                max = Math.max(grid[i][j], max);
            }
        }
        return max;
    }
}
