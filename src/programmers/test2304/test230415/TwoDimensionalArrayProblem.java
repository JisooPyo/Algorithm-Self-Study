package programmers.test2304.test230415;

import java.util.Arrays;

public class TwoDimensionalArrayProblem {

	public static void main(String[] args) {

		TwoDimensionalArrayProblem td = new TwoDimensionalArrayProblem();

		int[] x1 = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int x2 = 2;
		int[] y1 = { 100, 95, 2, 4, 5, 6, 18, 33, 948 };
		int y2 = 3;

		int[][] z1 = { { 1, 2 }, { 3, 4 }, { 5, 6 }, { 7, 8 } };

		System.out.println(Arrays.deepToString(td.solution(x1, x2)));
		System.out.println(Arrays.deepToString(td.solution(y1, y2)));

		System.out.println(Arrays.deepToString(z1));

	}

	public int[][] solution(int[] num_list, int n) {

		int[][] answer = new int[num_list.length / n][n];

		for (int i = 0; i < num_list.length / n; i++) {

			for (int j = 0; j < n; j++) {

				answer[i][j] = num_list[n * i + j];

			}

		}

		return answer;
	}

}


// Arrays.deepToString
