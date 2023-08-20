package programmers.test2304.test230413;

public class OrderedPairProblem {

	public static void main(String[] args) {

		OrderedPairProblem op = new OrderedPairProblem();
		
		System.out.println(op.solution(20));
		System.out.println(op.solution(100));

	}

	public int solution(int n) {

		int answer = 0;
		for (int i = 1; i <= n; i++) {

			if (n % i == 0) {
				answer++;
			}

		}
		return answer;

	}

}
