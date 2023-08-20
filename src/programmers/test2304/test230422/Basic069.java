package programmers.test2304.test230422;

import java.util.Arrays;

public class Basic069 {

	public static void main(String[] args) {
		Basic069 b = new Basic069();

		int[] x = { 0, 1, 2, 3, 4 };
		int[][] y = { { 0, 3 }, { 1, 2 }, { 1, 4 } };

		System.out.println(Arrays.toString(b.solution(x, y)));

	}

	public int[] solution(int[] arr, int[][] queries) {
		int[] answer = Arrays.copyOf(arr, arr.length);

		for (int i = 0; i < queries.length; i++) {
			answer[queries[i][0]] = arr[queries[i][1]];
			answer[queries[i][1]] = arr[queries[i][0]];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = answer[j];
			}
		}

		return answer;
	}

}
