package programmers.test2304.test230422;

import java.util.Arrays;

public class Basic072 {

	public static void main(String[] args) {
		Basic072 b = new Basic072();

		int[] x = { 12, 4, 15, 46, 38, 1, 14 };

		System.out.println(Arrays.toString(b.solution(x)));

	}

	public int[] solution(int[] num_list) {
		int[] answer = new int[5];
		Arrays.sort(num_list);
		for (int i = 0; i < 5; i++) {
			answer[i] = num_list[i];
		}
		return answer;
	}

}
