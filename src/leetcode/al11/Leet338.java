// Counting Bits
package leetcode.al11;

import java.util.Arrays;

public class Leet338 {
    public static void main(String[] args) {
        Leet338 leet338 = new Leet338();

        System.out.println(Arrays.toString(leet338.countBits(2)));
        System.out.println(Arrays.toString(leet338.countBits(5)));
    }

    public int[] countBits(int n) {
        int[] answer = new int[n + 1];
        answer[0] = 0;
        if (n == 0) {
            return answer;
        }
        answer[1] = 1;
        if (n == 1) {
            return answer;
        }
        for (int i = 2; i <= n; i++) {
            answer[i] = countOne(i, answer);
        }
        return answer;
    }

    private int countOne(int i, int[] answer) {
        return answer[i - (int) Math.pow(2, Integer.toBinaryString(i).length() - 1)] + 1;
    }
}


/*
31번째 줄에 대해서 고민했었는데 이런식으로 하면 더 깔끔하게 할 수 있다.

public int[] countBits(int n) {
    int[] dp = new int[n + 1];
    int sub = 1;

    for (int i = 1; i <= n; i++) {
        if (sub * 2 == i) {
            sub = i;
        }
        dp[i] = dp[i - sub] + 1;
    }
    return dp;
}
 */