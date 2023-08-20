package programmers.test2304.test230411;

import java.util.Arrays;

public class IHateEvenNumberProblem {

	public static void main(String[] args) {
		IHateEvenNumberProblem en = new IHateEvenNumberProblem();

		int a = 10;
		int b = 15;
		int[] c = en.solution(a);
		int[] d = en.solution(b);

		System.out.println(Arrays.toString(c));
		System.out.println(Arrays.toString(d));

	}

	public int[] solution(int n) {

		int[] answer = new int[(n + 1) / 2];

		for (int i = 0; i <= (n - 1) / 2; i++) {
			answer[i] = i * 2 + 1;
		}

		return answer;
	}

}

// 배열 출력을 우리가 보고싶어하는 방식으로 하려면 toString()을 붙여줘야 한다.