package programmers.test2304.test230420;

public class Basic027 {

	public static void main(String[] args) {
		Basic027 b = new Basic027();

		System.out.println(b.solution(7));
		System.out.println(b.solution(10));

	}

	public int solution(int n) {
		int answer = 0;
		if (n % 2 == 1) {
			for (int i = 1; i <= n; i = i + 2) {
				answer += i;
			}
		} else {
			for (int i = 2; i <= n; i = i + 2) {
				answer += i * i;
			}
		}
		return answer;
	}

}
