package leetcode.al2405;

/**
 * 1219. Path with Maximum Gold
 *
 * Given
 * grid: m * n 크기의 골드 광산
 *      광산의 각 칸은 해당 칸에 있는 금의 양을 나타내는 정수 값을 가진다.(비어 있다면 0)
 *
 * Return
 * 아래 조건 하에 모을 수 있는 금의 최대 양
 *
 * Condition
 * - 한 칸에 위치할 때마다 해당 칸에 있는 금을 수거한다.
 * - 현재 포지션에서 왼쪽, 오른쪽, 위, 아래로 한 칸 움직일 수 있다.
 * - 금의 양이 0인 칸은 방문하지 않는다.
 * - 0이 아닌 모든 칸에서 시작하거나 멈출 수 있다.
 */
public class Leet1219_x {   // Backtracking
    public static void main(String[] args) {
        Leet1219_x l = new Leet1219_x();

        int[][] grid1 = {
            {0, 6, 0},
            {5, 8, 7},
            {0, 9, 0}
        };
        int[][] grid2 = {
            {1, 0, 7},
            {2, 0, 6},
            {3, 4, 5},
            {0, 3, 0},
            {9, 0, 20}
        };

        int[][] grid3 = {
            {0, 0, 0, 0, 0, 0, 32, 0, 0, 20},
            {0, 0, 2, 0, 0, 0, 0, 40, 0, 32},
            {13, 20, 36, 0, 0, 0, 20, 0, 0, 0},
            {0, 31, 27, 0, 19, 0, 0, 25, 18, 0},

            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},

            {0, 0, 0, 0, 0, 0, 0, 18, 0, 6},
            {0, 0, 0, 25, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 21, 0, 30, 0, 0, 0, 0},
            {19, 10, 0, 0, 34, 0, 2, 0, 0, 27},
            {0, 0, 0, 0, 0, 34, 0, 0, 0, 0}
        };

        System.out.println(l.getMaximumGold(grid1));    // 24
        System.out.println(l.getMaximumGold(grid2));    // 28
        System.out.println(l.getMaximumGold(grid3));    // 129
    }
    // 내 풀이
    // 못 풀었다.
    // 풀릴 듯 말 듯하다가 간 곳을 다시 안 간 곳으로 체크하는 방식을 구현을 못해서 못 풀었다.

    // 다른 사람 풀이
    int maxGold = 0;
    int[] roww = {1, -1, 0, 0};
    int[] coll = {0, 0, -1, 1};

    public int checkIfAllZeros(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0)
                    count += grid[i][j];
                else
                    return 0;
            }
        }
        return count;
    }

    // 백트래킹
    public void backtrack(int[][] grid, int x, int y, int count) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length)
            return;

        if (grid[x][y] != 0) {
            int curr = grid[x][y];
            // 간 곳은 0으로 check
            grid[x][y] = 0;
            count += curr;
            maxGold = Math.max(maxGold, count);

            for (int i = 0; i < 4; i++) {
                int newX = x + roww[i];
                int newY = y + coll[i];
                backtrack(grid, newX, newY, count);
            }

            // ☆ 돌아와서는 값을 다시 돌려놓는다. ☆
            grid[x][y] = curr;
        }
    }

    public int getMaximumGold(int[][] grid) {
        // 모든 칸이 0이 아닌 경우 모든 값을 더하면 된다.
        int count = checkIfAllZeros(grid);
        if (count != 0)
            return count;


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    backtrack(grid, i, j, 0);
                }
            }
        }

        return maxGold;
    }
}
