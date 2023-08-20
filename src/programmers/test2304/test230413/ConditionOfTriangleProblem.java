package programmers.test2304.test230413;

import java.util.Arrays;

public class ConditionOfTriangleProblem {

	public static void main(String[] args) {

		ConditionOfTriangleProblem cot = new ConditionOfTriangleProblem();

		int[] a = { 1, 2, 3 };
		int[] b = { 3, 6, 2 };
		int[] c = { 199, 72, 222 };

		System.out.println(cot.solution(a));
		System.out.println(cot.solution(b));
		System.out.println(cot.solution(c));

	}

	public int solution(int[] sides) {

		Arrays.sort(sides);

		return sides[2] < sides[0] + sides[1] ? 1 : 2;
	}

}
