package programmers.test2304.test230421;

import java.util.Arrays;

public class Basic046 {

	public static void main(String[] args) {
		Basic046 b = new Basic046();

		System.out.println(Arrays.toString(b.solution(10, 3)));
		System.out.println(Arrays.toString(b.solution(15, 5)));

	}

	public int[] solution(int n, int k) {
		int[] answer = new int[n / k];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = k * (i + 1);
		}
		return answer;
	}

}

/*

다른 사람의 풀이

    return IntStream.rangeClosed(1, n).filter(i -> i % k == 0).toArray();

*/