package programmers.test2304.test230415;

public class FactorialProblem {

	public static void main(String[] args) {

		FactorialProblem f = new FactorialProblem();

		int x = 3628800;
		int y = 7;

		System.out.println(f.solution(x));
		System.out.println(f.solution(y));

	}

	public int solution(int n) {

		int answer = 0;
		int fac = 1;

		for (int i = 1; i <= 11; i++) {
			fac = fac * i;
			if (fac > n) {
				answer = i - 1;
				break;
			}

		}

		return answer;

	}

}
