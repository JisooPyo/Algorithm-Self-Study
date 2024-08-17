package leetcode.al2408;

/**
 * Medium
 * 1937. Maximum Number of Points with Cost
 *
 * 0-indexed m X n 인 정수 2차원 배열 points 가 주어집니다.
 * 0 포인트에서 시작해서 2차원 배열의 점수를 이용하여 최대 점수를 받으려고 합니다.
 *
 * 점수를 얻기 위해서는, 각 행에서 한 칸을 골라야 합니다.
 * (r,c) 좌표의 칸을 고르면 points[r][c]가 점수에 더해집니다.
 *
 * 그러나, 만약 이전 행에서 골랐던 칸보다 너무 먼 칸을 고르게 된다면, 점수를 잏을 수 있습니다.
 * 모든 두 개의 인접한 행 r, r + 1 (0 <= r < m - 1) 에서,
 * (r, c1)과 (r + 1, c2) 좌표에 있는 칸을 고르면, 점수에서 abs(c1 - c2) 를 빼야 합니다.
 *
 * 얻을 수 있는 최대 점수를 반환하시오.
 */
public class Leet1937_x {
    public static void main(String[] args) {
        Leet1937_x l = new Leet1937_x();
        int[][] points1 = {{1, 2, 3}, {1, 5, 1}, {3, 1, 1}};
        int[][] points2 = {{1, 5}, {2, 3}, {4, 2}};

        System.out.println(l.maxPoints(points1));    // 9
        System.out.println(l.maxPoints(points2));    // 11
    }

    // 내 풀이 1
    // Time Limit Exceeded
    // 시간 복잡도 : m * n * n
    public long maxPoints1(int[][] points) {
        int m = points.length;
        int n = points[0].length;

        long[][] dp = new long[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    long score = dp[i - 1][k] - Math.abs(k - j) + points[i - 1][j - 1];
                    dp[i][j] = Math.max(score, dp[i][j]);
                }
            }
        }

        long max = Long.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            max = Math.max(dp[m][i], max);
        }

        return max;
    }

    // GPT 도움으로 푼 풀이 : 8ms
    // 시간 복잡도 : m * n
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;

        long[] dp = new long[n];
        for (int j = 0; j < n; j++) {
            dp[j] = points[0][j];
        }

        for (int i = 1; i < m; i++) {
            long[] leftMax = new long[n];
            long[] rightMax = new long[n];

            leftMax[0] = dp[0];
            for (int j = 1; j < n; j++) {
                leftMax[j] = Math.max(leftMax[j - 1], dp[j] + j);
            }

            rightMax[n - 1] = dp[n - 1] - (n - 1);
            for (int j = n - 2; j >= 0; j--) {
                rightMax[j] = Math.max(rightMax[j + 1], dp[j] - j);
            }

            for (int j = 0; j < n; j++) {
                dp[j] = points[i][j] + Math.max(leftMax[j] - j, rightMax[j] + j);
            }
        }

        long max = Long.MIN_VALUE;
        for (int j = 0; j < n; j++) {
            max = Math.max(max, dp[j]);
        }

        return max;
    }

}
