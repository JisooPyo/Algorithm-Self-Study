package programmers.test2312;

public class TwoTimesNTiling {
    public static void main(String[] args) {
        TwoTimesNTiling t = new TwoTimesNTiling();
        System.out.println(t.solution(52));
    }

    public int solution(int n) {
        long[] memo = new long[n + 1];
        memo[1] = 1;
        memo[2] = 2;
        if (n == 1 || n == 2) {
            return (int) memo[n];
        }
        for (int i = 3; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
            if (memo[i] >= 1_000_000_007) {
                memo[i] = memo[i] % 1_000_000_007;
            }
        }
        return (int) memo[n];
    }

}
