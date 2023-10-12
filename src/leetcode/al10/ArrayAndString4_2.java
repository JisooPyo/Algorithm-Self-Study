package leetcode.al10;

import java.util.Arrays;

public class ArrayAndString4_2 {
	public static void main(String[] args) {
		ArrayAndString4_2 aas = new ArrayAndString4_2();

		int[][] mat1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int[][] mat2 = {{1, 2}, {3, 4}};
		int[][] mat3 = {{2, 3}};

		System.out.println(Arrays.toString(aas.findDiagonalOrder(mat1)));
		System.out.println(Arrays.toString(aas.findDiagonalOrder(mat2)));
		System.out.println(Arrays.toString(aas.findDiagonalOrder(mat3)));
	}

	public int[] findDiagonalOrder(int[][] matrix) {
		if (matrix.length == 0) return new int[0];
		int r = 0, c = 0, m = matrix.length, n = matrix[0].length, arr[] = new int[m * n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = matrix[r][c];
			if ((r + c) % 2 == 0) { // moving up
				if (c == n - 1) {
					r++;
				} else if (r == 0) {
					c++;
				} else {
					r--;
					c++;
				}
			} else {                // moving down
				if (r == m - 1) {
					c++;
				} else if (c == 0) {
					r++;
				} else {
					r++;
					c--;
				}
			}
		}
		return arr;
	}

}
