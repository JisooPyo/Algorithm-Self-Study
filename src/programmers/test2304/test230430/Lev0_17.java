/*
문제 설명

프로그래머스 치킨은 치킨을 시켜먹으면 한 마리당 쿠폰을 한 장 발급합니다.
쿠폰을 열 장 모으면 치킨을 한 마리 서비스로 받을 수 있고, 서비스 치킨에도 쿠폰이 발급됩니다.
시켜먹은 치킨의 수 chicken이 매개변수로 주어질 때 받을 수 있는 최대 서비스 치킨의 수를 return하도록 solution 함수를 완성해주세요.

제한사항

chicken은 정수입니다.
0 ≤ chicken ≤ 1,000,000
 */

package programmers.test2304.test230430;

public class Lev0_17 {

	public static void main(String[] args) {
		Lev0_17 lev = new Lev0_17();

		System.out.println(lev.solution(100));
		System.out.println(lev.solution(1081));

	}

	public int solution(int chicken) {
		int answer = 0;
		int coupon = chicken;
		while (coupon >= 10) {
			answer+=coupon/10;
			coupon = coupon/10 + coupon%10;
		}
		return answer;
	}

}
