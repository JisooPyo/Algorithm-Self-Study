package leetcode.al2407;

import java.util.Arrays;

/**
 * Medium
 * 1605. Find Valid Matrix Given Row and Column Sums
 *
 * 음이 아닌 정수 배열 rowSum과 colSum이 주어집니다.
 * rowSum[i]는 2d 배열에서 i번째 row 원소들의 합이고,
 * colSum[j]는 j번째 column 원소들의 합입니다.
 * 다른 말로 하면, 당신은 배열의 원소들을 모르지만, 각 행과 열의 합은 알고 있습니다.
 *
 * rowSum과 colSum을 만족하고, rowSum.length * colSum.length 크기의 음이 아닌 정수 배열을 찾으세요.
 * (만족하기만 하면 어떤 배열이든 상관 없음)
 */
public class Leet1605_x {
    public static void main(String[] args) {
        Leet1605_x l = new Leet1605_x();
        int[] rowSum1 = {3, 8}, colSum1 = {4, 7};
        int[] rowSum2 = {5, 7, 10}, colSum2 = {8, 6, 8};
        // [[3, 0],
        //  [1, 7]]
        System.out.println(Arrays.deepToString(l.restoreMatrix(rowSum1, colSum1)));
        // [[0, 5, 0],
        //  [6, 1, 0],
        //  [2, 0, 8]]
        System.out.println(Arrays.deepToString(l.restoreMatrix(rowSum2, colSum2)));
    }

    // 다른 사람의 풀이 : 1ms
    // 시간 복잡도 : O(rowSum.length + colSum.length)
    // 알고리즘 : Greedy
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int numrows = rowSum.length;    //
        int colrows = colSum.length;
        int[][] result = new int[numrows][colrows];

        int i = 0, j = 0;

        while (i < numrows && j < colrows) {
            // 현재 행과 열의 합 중 작은 값을 선택
            int val = Math.min(rowSum[i], colSum[j]);
            result[i][j] = val;     // 선택한 값을 결과 행렬의 현재 위치에 할당
            rowSum[i] -= val;       // 할당한 값을 현재 행의 합에서 뺌
            colSum[j] -= val;       // 할당한 값을 현재 열의 합에서 뺌

            if (rowSum[i] == 0) {   // 현재 행의 합이 0이 되면 다음 행으로 이동
                i++;
            }
            if (colSum[j] == 0) {   // 현재 열의 합이 0이 되면 다음 열로 이동
                j++;
            }
        }
        return result;
    }
}
