package leetcode.al2407;

import java.util.ArrayList;
import java.util.List;

/**
 * Easy
 * 1380. Lucky Numbers in a Matrix
 *
 * 서로 다른 숫자들로 이루어진 m * n 배열이 주어집니다.
 * 배열에서 모든 lucky 숫자들을 어떤 순서로든 반환해주세요.
 *
 * lucky 한 숫자는 배열의 원소이고,  * row 에서는 최소, column 에서는 최대인 숫자입니다.
 */
public class Leet1380 {
    public static void main(String[] args) {
        Leet1380 l = new Leet1380();

        int[][] matrix1 = {
            {3, 7, 8},
            {9, 11, 13},
            {15, 16, 17}
        };
        int[][] matrix2 = {
            {1, 10, 4, 2},
            {9, 3, 8, 7},
            {15, 16, 17, 12}
        };
        int[][] matrix3 = {
            {7, 8},
            {1, 2}
        };

        System.out.println(l.luckyNumbers(matrix1));    // [15]
        System.out.println(l.luckyNumbers(matrix2));    // [12]
        System.out.println(l.luckyNumbers(matrix3));    // [7]
    }

    // 내 풀이 : 2ms
    public List<Integer> luckyNumbers(int[][] matrix) {
        // row minimum 구하기
        int[] rowMinimum = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    index = j;
                }
            }
            if (rowMinimum[index] < min) {
                rowMinimum[index] = min;
            }
        }

        // column maximum 확인하기
        List<Integer> res = new ArrayList<>();
        loop1:
        for (int i = 0; i < rowMinimum.length; i++) {
            if (rowMinimum[i] == 0) {
                continue;
            }
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] > rowMinimum[i]) {
                    continue loop1;
                }
            }
            res.add(rowMinimum[i]);
        }

        return res;
    }
}
