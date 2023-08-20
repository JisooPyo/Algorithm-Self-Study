package programmers.test2304.test230426;

import java.util.Arrays;

public class Basic118 {

	public static void main(String[] args) {
		Basic118 b = new Basic118();

		int[] arr = { 0, 1, 2, 3, 4 };
		int[][] q = { { 0, 1 }, { 1, 2 }, { 2, 3 } };

		System.out.println(Arrays.toString(b.solution(arr, q)));

	}

	public int[] solution(int[] arr, int[][] queries) {
		int[] answer = arr;
		for (int i = 0; i < queries.length; i++) {
			int s = queries[i][0];
			int e = queries[i][1];
			for (int j = s; j <= e; j++) {
				answer[j]++;

			}
		}
		return answer;
	}

}
