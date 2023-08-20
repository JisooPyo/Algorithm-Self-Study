package programmers.test2305.test230502;

import java.util.Arrays;

public class Lev1_006 {

	public static void main(String[] args) {
		Lev1_006 lev = new Lev1_006();

		System.out.println(Arrays.toString(lev.solution(2, 5)));
		System.out.println(Arrays.toString(lev.solution(4, 3)));
		System.out.println(Arrays.toString(lev.solution(-4, 2)));

	}

	public long[] solution(long x, int n) {
		long[] answer = new long[n];
		long cons = x;
		for (int i = 0; i < n; i++) {
			answer[i] = x;
			x = x + cons;

		}
		return answer;
	}

}
