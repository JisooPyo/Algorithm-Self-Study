package leetcode.explore.arrayAndString;

import java.util.ArrayList;
import java.util.List;

public class ArrayAndString5 {
    public static void main(String[] args) {
        ArrayAndString5 aas5 = new ArrayAndString5();

        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] matrix3 = {{7}, {9}, {6}};
        int[][] matrix4 = {{2, 3, 4}, {5, 6, 7}, {8, 9, 10}, {11, 12, 13}, {14, 15, 16}};

//		System.out.println(aas5.spiralOrder(matrix1));
//		System.out.println(aas5.spiralOrder(matrix2));
//		System.out.println(aas5.spiralOrder(matrix3));
//		System.out.println(aas5.spiralOrder(matrix4));

        System.out.println(aas5.otherSolSpiralOrder(matrix1));
        System.out.println(aas5.otherSolSpiralOrder(matrix2));
        System.out.println(aas5.otherSolSpiralOrder(matrix3));
        System.out.println(aas5.otherSolSpiralOrder(matrix4));

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int x = 0;
        int xMin = 0;
        int xMax = matrix.length - 1;
        int y = 0;
        int yMin = 0;
        int yMax = matrix[0].length - 1;
        int changeX = 1;
        int changeY = 0;
        List<Integer> list = new ArrayList<>();
        if (yMax == 0) {
            for (int i = 0; i < matrix.length; i++) {
                list.add(matrix[i][0]);
            }
            return list;
        }
        for (int i = 0; i < matrix.length * matrix[0].length; i++) {
            list.add(matrix[x][y]);
            if (x == changeX && y == changeY) {
                if (xMax >= 3 && yMax >= 3) {
                    changeX++;
                    changeY++;
                }
                xMin++;
                xMax--;
                yMin++;
                yMax--;
            }
            if (x == xMin && y != yMax) {
                y++;
                continue;
            }
            if (y == yMax && x != xMax) {
                x++;
                continue;
            }
            if (x == xMax && y != yMin) {
                y--;
                continue;
            }
            if (y == yMin && x != xMin) {
                x--;
            }
        }
        return list;
    }

    public List<Integer> otherSolSpiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix.length == 0 || matrix[0].length == 0) return res;

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (true) {
            for (int i = left; i <= right; i++) res.add(matrix[top][i]);
            top++;
            if (left > right || top > bottom) break;

            for (int i = top; i <= bottom; i++) res.add(matrix[i][right]);
            right--;
            if (left > right || top > bottom) break;

            for (int i = right; i >= left; i--) res.add(matrix[bottom][i]);
            bottom--;
            if (left > right || top > bottom) break;

            for (int i = bottom; i >= top; i--) res.add(matrix[i][left]);
            left++;
            if (left > right || top > bottom) break;
        }

        return res;
    }
}
