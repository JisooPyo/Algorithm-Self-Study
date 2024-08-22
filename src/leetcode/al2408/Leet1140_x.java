package leetcode.al2408;

/**
 * 1140. Stone Game 2
 *
 * Alice와 Bob이 돌 무더기로 게임을 계속합니다.
 * 여러 개의 돌 무더기가 일렬로 배열되어 있으며, 각 무더기에는 양의 정수 개수의 돌이 있습니다.
 * 게임의 목표는 가장 많은 돌을 차지하는 것입니다.
 *
 * Alice와 Bob은 차례로 돌을 가져가며, Alice가 먼저 시작합니다.
 * 처음에는 M = 1입니다.
 *
 * 각 플레이어의 차례에서, 해당 플레이어는 남아있는 첫 번째 X개의 돌 무더기에서 모든 돌을 가져갈 수 있습니다.
 * 여기서 1 <= X <= 2M입니다. 그러고 나서 M = max(M, X)로 설정합니다.
 *
 * 게임은 모든 돌이 가져갈 때까지 계속됩니다.
 *
 * Alice와 Bob이 최적으로 플레이한다고 가정할 때, Alice가 얻을 수 있는 최대 돌 수를 반환하세요.
 */
public class Leet1140_x {
    public static void main(String[] args) {
        Leet1140_x l = new Leet1140_x();

        int[] piles1 = {2, 7, 9, 4, 4};
        int[] piles2 = {1, 2, 3, 4, 5, 100};

        System.out.println(l.stoneGameII(piles1));  // 10
        System.out.println(l.stoneGameII(piles2));  // 104
    }

    // 다른 사람 풀이: 8ms
    // 알고리즘: Dynamic Programming
    public int stoneGameII(int[] piles) {
        int n = piles.length;

        // dp[i][m]은 i번째 돌부터 시작하고 M이 m일 때, 현재 플레이어가 가져갈 수 있는 최대 돌의 개수
        int[][] dp = new int[n][n + 1];

        // suffixSum[i]는 i번째 돌부터 끝까지 남은 돌의 총합을 나타냄
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];

        // 뒤에서부터 순서대로 suffixSum을 채움
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        // 뒤에서부터 돌 무더기와 M에 대해 최적의 결과 계산
        for (int i = n - 1; i >= 0; i--) {
            for (int m = 1; m <= n; m++) {
                // 만약 i번째 돌에서 남은 돌의 수가 현재 M으로 가져갈 수 있는 최대 돌의 수보다 적으면
                if (i + 2 * m >= n) {
                    // 남은 모든 돌을 가져감
                    dp[i][m] = suffixSum[i];
                } else {
                    // 가져갈 수 있는 돌의 수를 1부터 2M까지 시도하며 최적의 선택 계산
                    for (int x = 1; x <= 2 * m; x++) {
                        // 현재 가져갈 수 있는 돌의 수를 빼고 상대방이 가져갈 수 있는 돌의 개수를 뺀 후 최댓값 선택
                        dp[i][m] = Math.max(dp[i][m], suffixSum[i] - dp[i + x][Math.max(m, x)]);
                    }
                }
            }
        }

        // 게임의 시작점에서 Alice가 최대한 가져갈 수 있는 돌의 개수 반환
        return dp[0][1];
    }
}
