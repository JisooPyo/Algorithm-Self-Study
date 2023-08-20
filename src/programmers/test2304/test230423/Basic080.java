package programmers.test2304.test230423;

import java.util.Arrays;

public class Basic080 {

	public static void main(String[] args) {

		Basic080 b = new Basic080();

		String[] x = { "3 - 4 = -3", "5 + 6 = 11" };
		String[] y = { "19 - 6 = 13", "5 + 66 = 71", "5 - 15 = 63", "3 - 1 = 2" };

		System.out.println(Arrays.toString(b.solution(x)));
		System.out.println(Arrays.toString(b.solution(y)));

	}

	public String[] solution(String[] quiz) {
		String[] answer = new String[quiz.length];
		for (int i = 0; i < quiz.length; i++) {
			String[] sp = quiz[i].split(" ");
			int x = Integer.parseInt(sp[0]);
			int y = Integer.parseInt(sp[2]);
			int z = Integer.parseInt(sp[4]);
			if (sp[1].equals("-")) {
				answer[i] = (x - y == z) ? "O" : "X";
			} else {
				answer[i] = (x + y == z) ? "O" : "X";
			}

		}

		return answer;
	}

}
