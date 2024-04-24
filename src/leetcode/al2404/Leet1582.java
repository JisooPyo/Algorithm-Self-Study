package leetcode.al2404;

import java.util.Arrays;

public class Leet1582 {
    public static void main(String[] args) {
        Leet1582 l = new Leet1582();

        int[][] mat1 = {
            {1, 0, 0},
            {0, 0, 1},
            {1, 0, 0}
        };
        int[][] mat2 = {
            {1, 0, 0},
            {0, 1, 0},
            {0, 0, 1}
        };

        System.out.println(l.numSpecial(mat1));     // 1
        System.out.println(l.numSpecial(mat2));     // 3
    }

    // 내 풀이
    public int numSpecial(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[] countRow = new int[row];
        int[] countCol = new int[col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 1) {
                    countRow[i]++;
                    countCol[j]++;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 1 && countRow[i] == 1 && countCol[j] == 1) {
                    answer++;
                }
            }
        }

        return answer;
    }

    // 다른 사람의 풀이
    // 내 풀이는 2N으로 가는데 이 풀이는 N으로 가기 때문에 더 효율적이다.
    public int numSpecialOther(int[][] mat) {
        int specials = 0;

        for (int i = 0; i < mat.length; i++) {
            int index = checkRow(mat, i);
            if (index >= 0 && checkColumn(mat, i, index))
                specials++;
        }

        return specials;
    }

    // row를 check해보고 1이 두 개 이상 있으면 -1, 하나 있으면 그 자리의 index를 반환
    private int checkRow(int[][] mat, int i) {
        int index = -1;
        for (int j = 0; j < mat[0].length; j++) {
            if (mat[i][j] == 1) {
                if (index >= 0)
                    return -1;
                else
                    index = j;
            }
        }
        return index;
    }

    private boolean checkColumn(int[][] mat, int i, int index) {
        for (int j = 0; j < mat.length; j++) {
            if (mat[j][index] == 1 && j != i)
                return false;
        }
        return true;
    }
}
