package leetcode.al2406;

import java.util.Arrays;

/**
 * Easy
 * 1051. Height Checker
 *
 * 학교는 모든 학생들의 연간 사진을 찍으려 합니다.
 * 학생들은 키를 기준으로 내림차순이 아닌 순서로 일렬로 서야 합니다.
 * 이렇게 선 순서를 정수 배열 expected 라고 합니다. expected[i]는 줄의 i번째 학생의 키입니다.
 *
 * Given
 * heights : 정수 배열
 *           현재 서있는 학생들의 순서를 나타낸다.
 *           heights[i]는 (0-indexed)줄에서 i번째 학생의 키이다.
 *
 * Return
 * heights[i] != expected[i] 인 index의 수를 골라라.
 */
public class Leet1051 {
    public static void main(String[] args) {
        Leet1051 l = new Leet1051();

        int[] heights1 = {1, 1, 4, 2, 1, 3};
        int[] heights2 = {5, 1, 2, 3, 4};
        int[] heights3 = {1, 2, 3, 4, 5};

        System.out.println(l.heightChecker(heights1));  // 3
        System.out.println(l.heightChecker(heights2));  // 5
        System.out.println(l.heightChecker(heights3));  // 0
    }

    // 내 풀이 : 2ms
    // 쉬운 문제라 설명 pass
    public int heightChecker(int[] heights) {
        int len = heights.length;
        int[] expected = Arrays.copyOf(heights, len);
        Arrays.sort(expected);

        int count = 0;
        for (int i = 0; i < len; i++) {
            if (heights[i] != expected[i]) {
                count++;
            }
        }
        return count;
    }
}
