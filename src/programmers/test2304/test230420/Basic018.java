package programmers.test2304.test230420;

import java.util.Arrays;

public class Basic018 {

	public static void main(String[] args) {
		Basic018 b = new Basic018();
		String[] x1 = { "nami", "ahri", "jayce", "garen", "ivern", "vex", "jinx" };
		String[] x2 = { "nami", "ahri", "jayce", "garen", "ivern", "vex" };
		String[] x3 = { "nami", "ahri", "jayce", "garen", "ivern" };
		String[] x4 = { "nami", "ahri", "jayce", "garen" };
		String[] x5 = { "nami", "ahri", "jayce" };
		System.out.println(Arrays.toString(b.solution(x1)));
		System.out.println(Arrays.toString(b.solution(x2)));
		System.out.println(Arrays.toString(b.solution(x3)));
		System.out.println(Arrays.toString(b.solution(x4)));
		System.out.println(Arrays.toString(b.solution(x5)));
	}

	public String[] solution(String[] names) {
		String[] answer = new String[(names.length - 1) / 5 + 1];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = names[5 * i];
		}
		return answer;
	}

}
