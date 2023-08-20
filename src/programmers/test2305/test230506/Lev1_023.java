// 내적
package programmers.test2305.test230506;

public class Lev1_023 {

	public static void main(String[] args) {
		Lev1_023 lev = new Lev1_023();

		int[] t1_1 = { 1, 2, 3, 4 };
		int[] t1_2 = { -3, -1, 0, 2 };

		int[] t2_1 = { -1, 0, 1 };
		int[] t2_2 = { 1, 0, -1 };

		System.out.println(lev.solution(t1_1, t1_2));
		System.out.println(lev.solution(t2_1, t2_2));

	}

	public int solution(int[] a, int[] b) {
		int answer = 0;
		for (int i = 0; i < a.length; i++) {
			answer += a[i] * b[i];
		}
		return answer;
	}

}
