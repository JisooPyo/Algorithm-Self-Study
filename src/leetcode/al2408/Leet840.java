package leetcode.al2408;

/**
 * Medium
 * 840. Magic Squares In Grid
 *
 * 3 * 3 매직 스퀘어는 각각의 행, 열, 대각선의 합이 같고, 1부터 9까지 각각 다른 숫자로 채워진 3 * 3 그리드입니다.
 *
 * 정수 row * col 그리드가 주어지면, 그리드 내에 magic square은 몇 개가 있는지 반환하세요.
 */
public class Leet840 {
    public static void main(String[] args) {
        Leet840 leet = new Leet840();
        int[][] grid1 = {{4, 3, 8, 4}, {9, 5, 1, 9}, {2, 7, 6, 2}};
        int[][] grid2 = {{8}};
        int[][] grid3 = {{1, 8, 6}, {10, 5, 0}, {4, 2, 9}};
        int[][] grid4 = {
            {3, 10, 2, 3, 4},
            {4, 5, 6, 8, 1},
            {8, 8, 1, 6, 8},
            {1, 3, 5, 7, 1},
            {9, 4, 9, 2, 9}
        };
        System.out.println(leet.numMagicSquaresInside(grid1));  // 1
        System.out.println(leet.numMagicSquaresInside(grid2));  // 0
        System.out.println(leet.numMagicSquaresInside(grid3));  // 0
        System.out.println(leet.numMagicSquaresInside(grid4));  // 1
    }

    // 내 풀이
    // 행, 열, 대각선 합은 15가 되어야 한다.
    int[][] rowSum;
    int[][] colSum;
    int[][] rightDownSum;
    int[][] leftUpSum;
    boolean[][] distinct;

    public int numMagicSquaresInside(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        if (row < 3 || col < 3) {
            return 0;
        }

        rowSum = new int[row][col - 2];
        colSum = new int[row - 2][col];
        rightDownSum = new int[row - 2][col - 2];
        leftUpSum = new int[row - 2][col - 2];
        distinct = new boolean[row - 2][col - 2];

        // 행 합 구하기
        for (int i = 0; i < row; i++) {
            int sum = grid[i][0] + grid[i][1] + grid[i][2];
            rowSum[i][0] = sum;
            for (int j = 0; j < col - 3; j++) {
                sum -= grid[i][j];
                sum += grid[i][j + 3];
                rowSum[i][j + 1] = sum;
            }
        }

        // 열 합 구하기
        for (int j = 0; j < col; j++) {
            int sum = grid[0][j] + grid[1][j] + grid[2][j];
            colSum[0][j] = sum;
            for (int i = 0; i < row - 3; i++) {
                sum -= grid[i][j];
                sum += grid[i + 3][j];
                colSum[i + 1][j] = sum;
            }
        }

        // 왼쪽 위로 올라가는 대각선 합 구하기
        for (int i = 0; i < row - 2; i++) {
            for (int j = 2; j < col; j++) {
                leftUpSum[i][j - 2] = grid[i][j] + grid[i + 1][j - 1] + grid[i + 2][j - 2];
            }
        }

        // 오른쪽 아래로 내려가는 대각선 합 구하기
        for (int i = 0; i < row - 2; i++) {
            for (int j = 0; j < col - 2; j++) {
                rightDownSum[i][j] = grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2];
            }
        }

        // 서로 다른 숫자로 이루어져 있는지 구하기
        for (int i = 0; i < row - 2; i++) {
            int[] arr = new int[16];
            for (int r = i; r <= i + 2; r++) {
                for (int c = 0; c <= 2; c++) {
                    arr[grid[r][c]]++;
                }
            }
            if (isGridDistinct(arr)) {
                distinct[i][0] = true;
            }
            for (int j = 0; j < col - 3; j++) {
                arr[grid[i][j]]--;
                arr[grid[i + 1][j]]--;
                arr[grid[i + 2][j]]--;
                arr[grid[i][j + 3]]++;
                arr[grid[i + 1][j + 3]]++;
                arr[grid[i + 2][j + 3]]++;

                if (isGridDistinct(arr)) {
                    distinct[i][j + 1] = true;
                }
            }
        }

        // 구해놓았던 sum 들 확인하면서 매직 스퀘어 찾기
        int count = 0;
        for (int i = 0; i < row - 2; i++) {
            for (int j = 0; j < col - 2; j++) {
                if (isMagicSquare(i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isGridDistinct(int[] arr) {
        for (int i = 1; i <= 9; i++) {
            if (arr[i] != 1) {
                return false;
            }
        }
        return true;
    }

    private boolean isMagicSquare(int i, int j) {
        return distinct[i][j]
            && rightDownSum[i][j] == 15
            && leftUpSum[i][j] == 15
            && rowSum[i][j] == 15
            && rowSum[i + 1][j] == 15
            && rowSum[i + 2][j] == 15
            && colSum[i][j] == 15
            && colSum[i][j + 1] == 15
            && colSum[i][j + 2] == 15;
    }
}
