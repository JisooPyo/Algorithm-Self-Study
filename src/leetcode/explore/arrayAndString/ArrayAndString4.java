package leetcode.explore.arrayAndString;

import java.util.Arrays;

public class ArrayAndString4 {
    public static void main(String[] args) {
        ArrayAndString4 aas4 = new ArrayAndString4();

        int[][] mat1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] mat2 = {{1, 2}, {3, 4}};

        System.out.println(Arrays.toString(aas4.findDiagonalOrder(mat1)));
        System.out.println(Arrays.toString(aas4.findDiagonalOrder(mat2)));
    }

    // mat가 정사각형일 때.(문제에서는 정사각형이 아니었다.)
    public int[] findDiagonalOrder(int[][] mat) {
        int len = mat.length;

        int[] answer = new int[len * len];
        int index = 0;
        int x, y;

        for (int sum = 0; sum <= len - 1; sum++) {
            if (sum % 2 == 0) {
                x = sum;
                y = 0;
                for (int i = 1; i <= sum + 1; i++) {
                    answer[index] = mat[x][y];
                    index++;
                    x--;
                    y++;
                }
            } else {
                x = 0;
                y = sum;
                for (int i = 1; i <= sum + 1; i++) {
                    answer[index] = mat[x][y];
                    index++;
                    x++;
                    y--;
                }
            }
        }

        for (int sum = len; sum <= len * 2 - 2; sum++) {
            if (sum % 2 == 0) {
                x = len - 1;
                y = sum - x;
                for (int i = 1; i <= 2 * len - 1 - sum; i++) {
                    answer[index] = mat[x][y];
                    index++;
                    x--;
                    y++;
                }
            } else {
                y = len - 1;
                x = len - y;
                for (int i = 1; i <= 2 * len - 1 - sum; i++) {
                    answer[index] = mat[x][y];
                    index++;
                    x++;
                    y--;
                }
            }
        }

        return answer;
    }
}
