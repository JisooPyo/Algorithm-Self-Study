package bookStudy.study2408;

import java.util.Arrays;

/**
 * 프로그래머스 lv.2
 * 5. 행렬의 곱셈
 */
public class Problem5 {
    public static void main(String[] args) {
        Problem5 problem5 = new Problem5();
        int[][] arr1_1 = {
            {1, 4},
            {3, 2},
            {4, 1}
        };
        int[][] arr2_1 = {
            {3, 3},
            {3, 3}
        };
        int[][] arr1_2 = {
            {2, 3, 2},
            {4, 2, 4},
            {3, 1, 4}
        };
        int[][] arr2_2 = {
            {5, 4, 3},
            {2, 4, 1},
            {3, 1, 1}
        };

        // [[15, 15], [15, 15], [15, 15]]
        System.out.println(Arrays.deepToString(problem5.solution(arr1_1, arr2_1)));
        // [[22, 22, 11], [36, 28, 18], [29, 20, 14]]
        System.out.println(Arrays.deepToString(problem5.solution(arr1_2, arr2_2)));
    }

    // 내 풀이
    // 시간 복잡도: O(N^3)
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int m = arr1.length;
        int n = arr2[0].length;
        int count = arr1[0].length;
        int[][] answer = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < count; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}
/*
테스트 1 〉	통과 (1.24ms, 91.6MB)
테스트 2 〉	통과 (11.90ms, 80.6MB)
테스트 3 〉	통과 (11.43ms, 71.9MB)
테스트 4 〉	통과 (0.51ms, 76.4MB)
테스트 5 〉	통과 (8.05ms, 90MB)
테스트 6 〉	통과 (4.16ms, 76.6MB)
테스트 7 〉	통과 (0.49ms, 71.5MB)
테스트 8 〉	통과 (0.16ms, 76.5MB)
테스트 9 〉	통과 (0.10ms, 83.8MB)
테스트 10 〉	통과 (8.91ms, 85.9MB)
테스트 11 〉	통과 (2.79ms, 88.3MB)
테스트 12 〉	통과 (0.18ms, 81.3MB)
테스트 13 〉	통과 (5.48ms, 77MB)
테스트 14 〉	통과 (11.25ms, 88MB)
테스트 15 〉	통과 (3.51ms, 81.4MB)
테스트 16 〉	통과 (1.82ms, 79.7MB)
 */
