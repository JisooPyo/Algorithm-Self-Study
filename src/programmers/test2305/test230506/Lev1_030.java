// 최대공약수와 최소공배수

package programmers.test2305.test230506;

import java.util.Arrays;

public class Lev1_030 {

	public static void main(String[] args) {

		Lev1_030 lev = new Lev1_030();

		System.out.println(Arrays.toString(lev.solution(3, 12)));
		System.out.println(Arrays.toString(lev.solution(2, 5)));

	}

	public int[] solution(int n, int m) {
		int[] answer = new int[2];
		// 최대공약수 구하기
		for (int i = 1; i <= Math.min(n, m); i++) {
			if (n % i == 0 && m % i == 0) {
				answer[0] = i;
			}
		}
		// 최소공배수 구하기
		answer[1] = answer[0] * (n / answer[0]) * (m / answer[0]);
		return answer;
	}

}

/*

다른 사람의 풀이

재귀함수를 이용하여 최대공약수를 구하고 두 수의 곱에서 최대공약수를 나눠 최소공배수를 구함!

	public int[] gcdlcm(int a, int b) {
		int[] answer = new int[2];

		answer[0] = gcd(a, b);
		answer[1] = (a * b) / answer[0];
		return answer;
	}

	public static int gcd(int p, int q) {
		if (q == 0)
			return p;
		return gcd(q, p % q);
	}


*/