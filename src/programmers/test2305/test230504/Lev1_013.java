// 두 정수 사이의 합

package programmers.test2305.test230504;

public class Lev1_013 {

	public static void main(String[] args) {
		Lev1_013 lev = new Lev1_013();

		System.out.println(lev.solution(3, 5));
		System.out.println(lev.solution(3, 3));
		System.out.println(lev.solution(5, 3));

	}

	public long solution(int a, int b) {
		long answer = 0;
		int min = Math.min(a, b);
		int max = Math.max(a, b);
		for (int i = min; i <= max; i++) {
			answer += i;
		}
		return answer;
	}

}
