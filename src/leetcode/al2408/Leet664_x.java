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
        int n = s.length();  // 문자열의 길이를 n에 저장합니다.
        char[] sChar = s.toCharArray();  // 문자열을 문자 배열로 변환하여 sChar에 저장합니다.

        // dp 배열을 생성하고 -1로 초기화합니다.
        // dp[i][j]는 s[i]부터 s[j]까지의 최소 출력 횟수를 저장하는 2차원 배열입니다.
        int[][] dp = new int[n][n];
        for (int[] in : dp)
            Arrays.fill(in, -1);  // dp 배열의 모든 값을 -1로 초기화합니다.

        // 0부터 n-1까지의 문자열을 출력하는 데 필요한 최소 횟수를 계산합니다.
        return Util(0, n - 1, sChar, dp);
    }

    public int Util(int i, int j, char[] sChar, int[][] dp) {
        // i가 j보다 크다면 (즉, 잘못된 범위라면) 출력할 것이 없으므로 0을 반환합니다.
        if (i > j) {
            return 0;
        }

        // 이미 계산된 값이 dp[i][j]에 있다면, 그것을 반환합니다 (중복 계산을 피하기 위해).
        if (dp[i][j] != -1)
            return dp[i][j];

        // 첫 번째 선택지: 현재 문자(i)를 단독으로 출력한 후, 나머지 부분(i+1 to j)을 출력합니다.
        int firstLetter = sChar[i];  // 첫 번째 문자를 저장합니다.
        int answer = 1 + Util(i + 1, j, sChar, dp);  // 첫 번째 문자를 출력한 뒤 나머지에 대한 최소 횟수 계산

        // 두 번째 선택지: i와 j 사이의 다른 문자들을 확인하면서, 같은 문자가 있는 곳에서 분할합니다.
        for (int k = i + 1; k <= j; k++) {
            if (sChar[k] == firstLetter) {  // 같은 문자를 찾으면
                // 중간에 나눠서 계산합니다.
                // i부터 k-1까지와 k+1부터 j까지의 최소 횟수를 더하여 계산합니다.
                int betterAnswer = Util(i, k - 1, sChar, dp) + Util(k + 1, j, sChar, dp);
                answer = Math.min(answer, betterAnswer);  // 더 작은 값으로 업데이트합니다.
            }
        }

        // 계산된 결과를 dp 배열에 저장하고 반환합니다.
        return dp[i][j] = answer;
    }
}
