// 콜라 문제

package programmers.test2305.test230509;

public class Lev1_044 {

	public static void main(String[] args) {
		Lev1_044 lev = new Lev1_044();

		System.out.println(lev.solution(2, 1, 20));
		System.out.println(lev.solution(3, 1, 20));
		System.out.println(lev.solution(5, 2, 33));

	}

	public int solution(int a, int b, int n) {
		int answer = 0;
		while (n >= a) {
			answer += n / a * b;
			n = n % a + n / a * b;

		}
		return answer;
	}

}
