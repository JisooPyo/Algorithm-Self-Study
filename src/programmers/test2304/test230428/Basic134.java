package programmers.test2304.test230428;

import java.util.Arrays;

public class Basic134 {

	public static void main(String[] args) {
		Basic134 b = new Basic134();

		for (int i = 0; i < 6; i++) {
			System.out.println(Arrays.toString(b.solution(6)[i]));
		}

	}

	public int[][] solution(int n) {
		int[][] answer = new int[n][n];
		int num = 1;

		for (int i = 0; i <= n / 2 - 1; i++) {
			int go = (n - 1) - 2 * i;
			int end = n - 1 - i;
			for (int j = i; j < i + go; j++) {
				answer[i][j] = num;
				num++;
			}
			for (int j = i; j < i + go; j++) {
				answer[j][end] = num;
				num++;
			}
			for (int j = end; j > end - go; j--) {
				answer[end][j] = num;
				num++;
			}
			for (int j = end; j > end - go; j--) {
				answer[j][i] = num;
				num++;
			}
		}

		if (n % 2 == 1) {
			int mid = (n + 1) / 2 - 1;
			answer[mid][mid] = num;
		}

		return answer;
	}

}
