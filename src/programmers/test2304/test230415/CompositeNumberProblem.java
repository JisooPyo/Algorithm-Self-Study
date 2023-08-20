package programmers.test2304.test230415;

public class CompositeNumberProblem {

	public static void main(String[] args) {

		CompositeNumberProblem cn = new CompositeNumberProblem();

		int x = 10;
		int y = 15;

		System.out.println(cn.solution(x));
		System.out.println(cn.solution(y));

	}

	public int solution(int n) {
		int answer = 0;
		int divisorCount = 0;
		if (n == 1 || n == 2 || n == 3) {
			answer = 0;
		} else {

			for (int i = 4; i <= n; i++) {

				for (int j = 1; j <= i; j++) {

					if (i % j == 0) {
						divisorCount++;
					}
				}
				
				if (divisorCount >= 3) {
					answer++;
				}

				divisorCount = 0;
			}

		}
		return answer;
	}

}
