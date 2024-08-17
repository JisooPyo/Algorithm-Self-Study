package algorithm.dynamic_programming;

public class Knapsack {
    public static void main(String[] args) {
        int W = 50; // 배낭의 무게 제한
        int[] weights = {10, 20, 30}; // 각 아이템의 무게
        int[] values = {60, 100, 120}; // 각 아이템의 가치
        int n = weights.length; // 아이템의 개수

        int[][] dp = new int[n + 1][W + 1];

        // DP 테이블 채우기
        // dp[i][w]는 i번째 아이템까지 고려했을 때, 배낭의 무게가 w일 때 얻을 수 있는 최대 가치를 의미합니다.
        for (int i = 1; i <= n; i++) {  // 각 아이템에 대해
            for (int w = 1; w <= W; w++) {  // 각 배낭의 무게에 대해
                if (weights[i - 1] <= w) {  // 현재 아이템의 무게가 현재 배낭 무게보다 작거나 같으면
                    dp[i][w] = Math.max(dp[i - 1][w],  // 현재 아이템을 선택하지 않은 경우
                        dp[i - 1][w - weights[i - 1]] + values[i - 1]);  // 현재 아이템을 선택한 경우
                } else {
                    dp[i][w] = dp[i - 1][w];  // 현재 아이템의 무게가 너무 무거워 선택할 수 없는 경우
                }
            }
        }

        System.out.println("Maximum value in Knapsack = " + dp[n][W]);      // 220
    }
}

