/*
소수점 아래 숫자가 계속되지 않고 유한개인 소수를 유한소수라고 합니다.
분수를 소수로 고칠 때 유한소수로 나타낼 수 있는 분수인지 판별하려고 합니다.
유한소수가 되기 위한 분수의 조건은 다음과 같습니다.

기약분수로 나타내었을 때, 분모의 소인수가 2와 5만 존재해야 합니다.

두 정수 a와 b가 매개변수로 주어질 때,
a/b가 유한소수이면 1을, 무한소수라면 2를 return하도록 solution 함수를 완성해주세요.

제한사항

a, b는 정수
0 < a ≤ 1,000
0 < b ≤ 1,000
*/
package programmers.test2304.test230429;

public class Lev0_12 {

	public static void main(String[] args) {
		Lev0_12 lev = new Lev0_12();

		System.out.println(lev.solution(7, 20));
		System.out.println(lev.solution(11, 22));
		System.out.println(lev.solution(12, 21));

	}

	public int solution(int a, int b) {
		// 최대공약수 구하기
		int gcd = 1;

		for (int i = Math.max(a, b); i >= 1; i--) {
			if (a % i == 0 && b % i == 0) {
				gcd = i;
				break;
			}
		}

		b = b / gcd;

		while (b > 1) {
			if (b % 2 == 0) {
				b = b / 2;
			} else if (b % 5 == 0) {
				b = b / 5;
			} else {
				break;
			}
		}
		return b == 1 ? 1 : 2;
	}

}
