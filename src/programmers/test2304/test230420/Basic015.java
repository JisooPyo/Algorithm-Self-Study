package programmers.test2304.test230420;

public class Basic015 {

	public static void main(String[] args) {

		Basic015 b = new Basic015();

		System.out.println(b.solution("<", "=", 20, 50));
		System.out.println(b.solution(">", "!", 41, 78));

	}

	public int solution(String ineq, String eq, int n, int m) {
		int answer = 0;
		if (ineq.equals(">")) {
			if (eq.equals("=")) {
				answer = (n >= m) ? 1 : 0;
			} else {
				answer = (n > m) ? 1 : 0;
			}
		} else {
			if (eq.equals("=")) {
				answer = (n <= m) ? 1 : 0;
			} else {
				answer = (n < m) ? 1 : 0;
			}
		}
		return answer;
	}

}
