package programmers.test2305.test230503;

public class Lev1_008 {

	public static void main(String[] args) {
		Lev1_008 lev = new Lev1_008();

		System.out.println(lev.solution(121));
		System.out.println(Math.ceil(Math.sqrt(4)));

	}

	public long solution(long n) {

		double root = Math.ceil(Math.sqrt((double) n));
		long answer = (long) ((root + 1) * (root + 1));
		return (long) (root * root) == n ? answer : -1;
	}

}

// 3, 6, 13 실패 --> Math.sqrt는 소수점 아래 8자리까지!
// Math.ceil은 소수점 첫째자리에서 올림해주는 함수.

// 제한 사항
// n은 1이상, 50,000,000,000,000 이하인 양의 정수입니다.
// 				 2,147,483,647