// 콜라츠 추측
package programmers.test2305.test230504;

public class Lev1_014 {

	public static void main(String[] args) {
		Lev1_014 lev = new Lev1_014();

		System.out.println(lev.solution(6));
		System.out.println(lev.solution(16));
		System.out.println(lev.solution(626331));

	}

	public int solution(int num) {
		int answer = 0;
		while (num > 1) {
			if (num % 2 == 0) {
				num = num / 2;
			} else {
				num = num * 3 + 1;
			}
			answer++;
			if (answer > 500) {
				answer = -1;
				break;
			}
		}
		return num == 1 ? answer : -1;
	}
}
