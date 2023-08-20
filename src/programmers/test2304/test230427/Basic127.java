package programmers.test2304.test230427;

import java.util.Arrays;

public class Basic127 {

	public static void main(String[] args) {
		Basic127 b = new Basic127();

		int[][] x = { { 572, 22, 37 }, { 287, 726, 384 }, { 85, 137, 292 }, { 487, 13, 876 } };
		int[][] y = { { 57, 192, 534, 2 }, { 9, 345, 192, 999 } };
		int[][] z = { { 1, 2 }, { 3, 4 } };

		System.out.println(Arrays.deepToString(b.solution(x)));
		System.out.println(Arrays.deepToString(b.solution(y)));
		System.out.println(Arrays.deepToString(b.solution(z)));

	}

	public int[][] solution(int[][] arr) {
		int row = arr.length;
		int column = arr[0].length;
		int max = Math.max(row, column);
		int[][] answer = new int[max][max];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				answer[i][j] = arr[i][j];
			}
		}
		return answer;
	}

}
