package leetcode.al2404;

public class Leet2370_x {
    public static void main(String[] args) {
        Leet2370_x l = new Leet2370_x();

        System.out.println(l.longestIdealString("acfgbd", 2));      // 4
        System.out.println(l.longestIdealString("abcd", 3));        // 4
        System.out.println(l.longestIdealString("pvjcci", 4));      // 2
        System.out.println(l.longestIdealString("eduktdb", 15));    // 5
    }

    // 다른 사람의 풀이
    // 해당 알파벳에 대해 최대 길이를 저장하는 배열 dp를 선언한다.
    // idx - k부터 idx + k까지를 조사하면서 가장 높은 숫자에 1을 더하여 해당 인덱스에 기록한다.
    // dp를 돌면서 최댓값을 반환한다.
    public int longestIdealString(String s, int k) {

        int[] dp = new int[27];
        int n = s.length();

        for (int i = n - 1; i >= 0; i--) {
            char cc = s.charAt(i);
            int idx = cc - 'a';
            int max = Integer.MIN_VALUE;

            int left = Math.max((idx - k), 0);
            int right = Math.min((idx + k), 26);

            for (int j = left; j <= right; j++) {
                max = Math.max(max, dp[j]);
            }

            dp[idx] = max + 1;
        }

        int max = Integer.MIN_VALUE;

        for (int ele : dp) {
            max = Math.max(ele, max);
        }

        return max;
    }
}
