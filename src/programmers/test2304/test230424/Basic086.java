package programmers.test2304.test230424;

import java.util.Arrays;

public class Basic086 {

	public static void main(String[] args) {

		Basic086 b = new Basic086();

		int[] x = { 0, 1, 2, 4, 3 };
		int[][] y = { { 0, 4, 1 }, { 0, 3, 2 }, { 0, 3, 3 } };

		System.out.println(Arrays.toString(b.solution(x, y)));

	}

	public int[] solution(int[] arr, int[][] queries) {
		int[] answer = Arrays.copyOf(arr, arr.length);
		for (int i = 0; i < queries.length; i++) {
			int s = queries[i][0];
			int e = queries[i][1];
			int k = queries[i][2];
			for (int j = s; j <= e; j++) {
				if (j % k == 0) {
					answer[j] += 1;
				}
			}
		}
		return answer;
	}

}
