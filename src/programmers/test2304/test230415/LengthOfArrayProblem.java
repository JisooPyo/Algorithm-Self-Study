package programmers.test2304.test230415;

import java.util.Arrays;

public class LengthOfArrayProblem {

	public static void main(String[] args) {

		LengthOfArrayProblem loa = new LengthOfArrayProblem();

		String[] x = { "We", "are", "the", "World!" };
		String[] y = { "I", "Love", "Programmers." };

		System.out.println(Arrays.toString(loa.solution(x)));
		System.out.println(Arrays.toString(loa.solution(y)));

	}

	public int[] solution(String[] strlist) {

		int[] answer = new int[strlist.length];

		for (int i = 0; i < strlist.length; i++) {
			answer[i] = strlist[i].length();
		}

		return answer;

	}

}
