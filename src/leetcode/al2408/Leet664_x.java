package leetcode.al2408;

import java.util.Arrays;

/**
 * Hard
 * 664. Strange Printer
 *
 * 특별한 두 가지 성질을 가진 프린터가 있습니다:
 *
 * 프린터는 한 번에 같은 문자의 연속된 시퀀스만 출력할 수 있습니다.
 * 프린터는 매번 새로운 문자를 출력할 때, 원하는 위치에서 시작하여 원하는 위치에서 끝낼 수 있으며, 이미 출력된 문자 위에 덮어씌울 수 있습니다.
 * 주어진 문자열 s를 출력하기 위해 프린터가 필요한 최소 출력 횟수를 구하세요.
 *
 * 입력:
 * 하나의 문자열 s (문자열의 길이는 최대 100입니다).
 *
 * 출력:
 * 주어진 문자열을 출력하는 데 필요한 최소 출력 횟수를 반환합니다.
 */
public class Leet664_x {
    public static void main(String[] args) {
        Leet664_x l = new Leet664_x();
        System.out.println(l.strangePrinter("aaabbb"));     // 2
        System.out.println(l.strangePrinter("aba"));        // 2
    }

    // 다른 사람의 풀이: 9ms
    // 알고리즘: Dynamic Programming
    public int strangePrinter(String s) {
        int n = s.length();
        char[] sChar = s.toCharArray();
        int[][] dp = new int[n][n];
        for (int[] in : dp)
            Arrays.fill(in, -1);
        return Util(0, n - 1, sChar, dp);
    }

    public int Util(int i, int j, char[] sChar, int[][] dp) {
        if (i > j) {
            return 0;
        }

        if (dp[i][j] != -1)
            return dp[i][j];

        int firstLetter = sChar[i];
        // in case, current character is not repeated in the rest of the string
        int answer = 1 + Util(i + 1, j, sChar, dp);
        for (int k = i + 1; k <= j; k++) {
            // if repeated then update the answer
            if (sChar[k] == firstLetter) {
                // splitting from i -> k - 1(remove the last character)
                // and from k + 1 -> j
                int betterAnswer = Util(i, k - 1, sChar, dp) + Util(k + 1, j, sChar, dp);
                answer = Math.min(answer, betterAnswer);
            }
        }
        return dp[i][j] = answer;
    }
}
