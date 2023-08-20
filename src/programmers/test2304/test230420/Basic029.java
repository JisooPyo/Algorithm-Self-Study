package programmers.test2304.test230420;

import java.util.Arrays;

public class Basic029 {

	public static void main(String[] args) {

		Basic029 b = new Basic029();

		int[] x = { 4, 2, 6, 1, 7, 6 };

		System.out.println(Arrays.toString(b.solution(x, 2)));
		System.out.println(Arrays.toString(b.solution(x, 4)));

	}

	public int[] solution(int[] num_list, int n) {
		int[] answer = new int[num_list.length % n == 0 ? num_list.length / n : num_list.length / n + 1];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = num_list[i * n];
		}
		return answer;
	}

}
