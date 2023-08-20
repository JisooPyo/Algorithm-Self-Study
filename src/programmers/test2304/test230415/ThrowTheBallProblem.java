package programmers.test2304.test230415;

public class ThrowTheBallProblem {

	public static void main(String[] args) {

		ThrowTheBallProblem ttb = new ThrowTheBallProblem();

		int[] x1 = { 1, 2, 3, 4 };
		int x2 = 2;

		int[] y1 = { 1, 2, 3, 4, 5, 6 };
		int y2 = 5;

		int[] z1 = { 1, 2, 3 };
		int z2 = 3;

		System.out.println(ttb.solution(x1, x2));
		System.out.println(ttb.solution(y1, y2));
		System.out.println(ttb.solution(z1, z2));

	}

	public int solution(int[] numbers, int k) {

		int answer = 1;

		for (int i = 1; i < k; i++) {
			answer = answer + 2;
			if (answer > numbers.length) {
				answer = answer - numbers.length;
			}
		}

		return answer;

	}

}
