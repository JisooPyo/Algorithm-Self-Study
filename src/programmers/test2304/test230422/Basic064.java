package programmers.test2304.test230422;

public class Basic064 {

	public static void main(String[] args) {
		Basic064 b = new Basic064();

		System.out.println(b.solution(3, 5));
		System.out.println(b.solution(6, 1));
		System.out.println(b.solution(2, 4));

	}

	public int solution(int a, int b) {
		int answer = 0;
		if (a % 2 == 1 && b % 2 == 1) {
			answer = a * a + b * b;
		} else if (a % 2 == 0 && b % 2 == 0) {
			answer = Math.abs(a - b);
		} else {
			answer = 2 * (a + b);
		}
		return answer;
	}

}
