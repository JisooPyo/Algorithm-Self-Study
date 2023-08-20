package programmers.test2304.test230421;

import java.util.Arrays;

public class Basic050 {

	public static void main(String[] args) {

		Basic050 b = new Basic050();

		String[] x = { "AAA", "BBB", "CCC", "DDD" };
		String[] y = { "aBc", "AbC" };

		System.out.println(Arrays.toString(b.solution(x)));
		System.out.println(Arrays.toString(b.solution(y)));

	}

	public String[] solution(String[] strArr) {
		String[] answer = new String[strArr.length];
		for (int i = 0; i < answer.length; i++) {
			if (i % 2 == 0) {
				answer[i] = strArr[i].toLowerCase();
			} else {
				answer[i] = strArr[i].toUpperCase();
			}
		}
		return answer;
	}

}
