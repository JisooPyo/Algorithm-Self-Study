package leetcode.al2404;

public class Leet1289 {
    public static void main(String[] args) {
        Leet1289 l = new Leet1289();

        int[][] grid1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] grid2 = {{7}};

        System.out.println(l.minFallingPathSum(grid1));
        System.out.println(l.minFallingPathSum(grid2));
    }

    // 내 풀이
    // 전날 풀지 못했던 문제와 비슷해 보여서 dp를 이용해서 풀었더니 잘 풀렸다.
    // 처음에는 4ms 였지만 반복되는 부분을 메서드로 빼주어 좀 더 효율적으로 처리할 수 있게끔 하여 1ms로 줄일 수 있었다.
    public int minFallingPathSum(int[][] grid) {
        if (grid.length == 1) {
            return grid[0][0];
        }

        int len = grid.length;

        // 합계 기록할 sum 배열 첫 번째 줄 기록
        int[][] sum = new int[len][len];
        for (int i = 0; i < len; i++) {
            sum[0][i] = grid[0][i];
        }

        // grid의 첫 줄 첫 번째 최솟값 인덱스와 두 번째 최솟값 인덱스 기록
        int[][] minIndexRecord = new int[len][2];
        recordFirstSecondMinIndexOnXthLineOfSum(sum, 0, minIndexRecord, len, grid);

        for (int i = 1; i < len; i++) {
            // 전 줄 minIndexRecord 이용하여 sum 배열 두 번째 줄부터 끝까지 기록
            recordMinSum(grid, len, minIndexRecord, i, sum);

            // 각 줄의 첫번째 최솟값 두 번째 최솟값 찾아서 minIndexRecord에 기록
            recordFirstSecondMinIndexOnXthLineOfSum(sum, i, minIndexRecord, len, sum);
        }

        return sum[len - 1][minIndexRecord[len - 1][0]];
    }

    private void recordMinSum(int[][] grid, int len, int[][] minIndexRecord, int i, int[][] sum) {
        for (int j = 0; j < len; j++) {
            if (j == minIndexRecord[i - 1][0]) {
                sum[i][j] = grid[i][j] + sum[i - 1][minIndexRecord[i - 1][1]];
            } else {
                sum[i][j] = grid[i][j] + sum[i - 1][minIndexRecord[i - 1][0]];
            }
        }
    }

    private void recordFirstSecondMinIndexOnXthLineOfSum(int[][] sum, int x, int[][] minIndexRecord, int len,
        int[][] grid) {
        if (sum[x][0] < sum[x][1]) {
            minIndexRecord[x][0] = 0;
            minIndexRecord[x][1] = 1;
        } else {
            minIndexRecord[x][0] = 1;
            minIndexRecord[x][1] = 0;
        }
        for (int i = 2; i < len; i++) {
            if (sum[x][i] < sum[x][minIndexRecord[x][0]]) {
                minIndexRecord[x][1] = minIndexRecord[x][0];
                minIndexRecord[x][0] = i;
            } else if (grid[x][i] < grid[x][minIndexRecord[x][1]]) {
                minIndexRecord[x][1] = i;
            }
        }
    }
}
