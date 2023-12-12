package algorithm.dynamic_programming;

public class Fibonacci {
    // DP 를 사용 시 작은 문제의 결과값을 저장하는 배열
    // Top-down, Bottom-up 별개로 생성하였음(큰 의미는 없음)
    static int[] topDown_memo;
    static int[] bottomup_table;

    public static void main(String[] args) {
        int n = 30;
        topDown_memo = new int[n + 1];
        bottomup_table = new int[n + 1];

        long startTime = System.currentTimeMillis();
        System.out.println(naiveRecursion(n));
        long endTime = System.currentTimeMillis();
        System.out.println("일반 재귀 소요 시간 : " + (endTime - startTime));

        System.out.println();

        startTime = System.currentTimeMillis();
        System.out.println(topDown(n));
        endTime = System.currentTimeMillis();
        System.out.println("Top-Down DP 소요 시간 : " + (endTime - startTime));

        System.out.println();

        startTime = System.currentTimeMillis();
        System.out.println(bottomUp(n));
        endTime = System.currentTimeMillis();
        System.out.println("Bottom-Up DP 소요 시간 : " + (endTime - startTime));
    }

    // 단순 재귀를 통해 Fibonacci를 구하는 경우
    // 동일한 계산을 반복하여 비효율적으로 처리가 수행됨
    public static int naiveRecursion(int n) {
        if (n <= 1) {
            return n;
        }
        return naiveRecursion(n - 1) + naiveRecursion(n - 2);
    }

    // DP Top-Down을 사용해 Fibonacci를 구하는 경우
    public static int topDown(int n) {
        // 기저 상태 도달 시, 0, 1로 초기화
        if (n < 2) return topDown_memo[n] = n;

        // 메모에 계산된 값이 있으면 바로 반환!
        if (topDown_memo[n] > 0) return topDown_memo[n];

        // 재귀를 사용하고 있음!
        topDown_memo[n] = topDown(n - 1) + topDown(n - 2);

        return topDown_memo[n];
    }

    // DP Bottom-Up을 사용해 Fibonacci를 구하는 경우
    public static int bottomUp(int n) {
        // 기저 상태의 경우 사전에 미리 저장
        bottomup_table[0] = 0;
        bottomup_table[1] = 1;

        // 반복문을 사용하고 있음!
        for (int i = 2; i <= n; i++) {
            // Table을 채워나감!
            bottomup_table[i] = bottomup_table[i - 1] + bottomup_table[i - 2];
        }
        return bottomup_table[n];
    }
}
