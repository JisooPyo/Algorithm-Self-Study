package leetcode.al2408;

import java.util.Arrays;

/**
 * Medium
 * 650. 2 Keys Keyboard
 *
 * 노트패드 스크린에는 'A'가 있습니다.
 * 각 스텝마다 이 노트패드에 두 연산 중 하나를 수행할 수 있습니다.
 *   - Copy All: 스크린에 있는 모든 문자들을 복사할 수 있다.(부분 복사는 허용하지 않음)
 *   - Paste: 저번에 복사했던 문자들을 붙여넣기 할 수 있다.
 *
 * 정수 n이 주어질 때, 화면에 'A'를 정확히 n개가 보이도록 해야 하는 연산의 최소 수를 구하시오.
 */
public class Leet650 {
    public static void main(String[] args) {
        Leet650 l = new Leet650();
        System.out.println(l.minSteps(1));      // 0
        System.out.println(l.minSteps(2));      // 2
        System.out.println(l.minSteps(3));      // 3
        System.out.println(l.minSteps(4));      // 4
        System.out.println(l.minSteps(5));      // 5
        System.out.println(l.minSteps(6));      // 5
        System.out.println(l.minSteps(7));      // 7
        System.out.println(l.minSteps(8));      // 6
        System.out.println(l.minSteps(9));      // 6
        System.out.println(l.minSteps(10));     // 7
        System.out.println(l.minSteps(20));     // 9
    }

    // 내 풀이: 5ms
    public static Prime p = new Prime();

    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            // 소수인 경우
            if (p.isPrime[i]) {
                dp[i] = i;
                continue;
            }

            // 소수가 아닌 경우
            int min = Integer.MAX_VALUE;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                // 소수가 아닌 경우 나누어보지 않는다.
                if (!p.isPrime[j]) {
                    continue;
                }
                // 나누어지지 않는 경우 pass한다.
                if (i % j != 0) {
                    continue;
                }
                min = dp[i / j] + j;
            }
            dp[i] = min;
        }
        return dp[n];
    }

    static class Prime {
        public boolean[] isPrime = new boolean[1001];

        public Prime() {
            Arrays.fill(isPrime, true);
            isPrime[1] = false;
            for (int i = 2; i <= 1000; i++) {
                if (isPrime[i]) {
                    for (int j = 2; i * j <= 1000; j++) {
                        isPrime[i * j] = false;
                    }
                }
            }
        }
    }

    // 다른 사람의 풀이: 0ms
    // 너무 쉽게 푸셨네.. ;ㅅ;
    public int minStepsOther(int n) {
        int ans = 0;
        for (int i = 2; i * i <= n; ) {
            if (n % i == 0) {
                ans += i;
                n = n / i;
            } else {
                i++;
            }
        }
        if (n != 1)
            ans = ans + n;
        return ans;
    }

}
