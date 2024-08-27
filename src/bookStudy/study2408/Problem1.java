package bookStudy.study2408;

import java.util.Arrays;

/**
 * 1. 배열 정렬하기
 * 정수 배열을 정렬해서 반환하는 solution() 함수를 완성하세요.
 */
public class Problem1 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, -5, 2, 4, 3})));
        System.out.println(Arrays.toString(solution(new int[]{2, 1, 1, 3, 2, 5, 4})));
        System.out.println(Arrays.toString(solution(new int[]{6, 1, 7})));
    }

    private static int[] solution(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }
}
