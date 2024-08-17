package algorithm.dynamic_programming;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5}; // 동전의 종류
        int amount = 11;         // 목표 금액

        int result = coinChange(coins, amount);
        System.out.println("Minimum coins required: " + result);
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // 초기값을 최대값으로 설정
        dp[0] = 0; // 0 금액을 만들기 위한 동전 수는 0

        // dp 테이블 채우기
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // dp[amount]가 초기값 그대로라면, 해당 금액을 만들 수 없는 경우이므로 -1 반환
        return dp[amount] > amount ? -1 : dp[amount];
    }
}

