// 자릿수 더하기
package programmers.test2305.test230501;

public class Lev1_004 {

	public static void main(String[] args) {
		Lev1_004 lev = new Lev1_004();
		
		System.out.println(lev.solution(123));
		System.out.println(lev.solution(987));

	}

	public int solution(int n) {
		int answer = 0;
		while (n > 0) {
			answer += n % 10;
			n = n / 10;
		}
		return answer;
	}

}
