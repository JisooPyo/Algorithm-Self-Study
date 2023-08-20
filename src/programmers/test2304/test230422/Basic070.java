package programmers.test2304.test230422;

import java.util.Arrays;

public class Basic070 {

	public static void main(String[] args) {
		Basic070 b = new Basic070();

		int[] x = { 0, 1, 2, 4, 3 };
		int[][] y = { { 0, 2, 2 }, { 0, 4, 2 }, { 0, 3, 2 }, { 0, 2, 2 } };

		System.out.println(Arrays.toString(b.solution(x, y)));

	}

	public int[] solution(int[] arr, int[][] queries) {
		int[] answer = new int[queries.length];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = -1;
		}

		for (int i = 0; i < queries.length; i++) {
			int s = queries[i][0];
			int e = queries[i][1];
			int k = queries[i][2];

			for (int j = s; j <= e; j++) {
				if (arr[j] > k) {
					if (answer[i] == -1) {
						answer[i] = arr[j];
					} else if (answer[i] > arr[j]) {
						answer[i] = arr[j];
					}
				}
			}

		}

		return answer;
	}
}
