// 부족한 금액 계산하기

package programmers.test2305.test230506;

public class Lev1_026 {

	public static void main(String[] args) {
		Lev1_026 lev = new Lev1_026();

		System.out.println(lev.solution(3, 20, 4));

	}

	public long solution(long price, long money, long count) {
		long cost = ((1 + count) * count / 2) * price;
		long answer = cost - money;
		return answer < 0 ? 0 : answer;
	}

}

// 4, 18, 19, 20, 21, 22 틀림.

// answer < 0 ? 0 : answer 코드 쓴 이후
// 18, 19, 20, 21, 22 틀림. 

// 받는 매개변수를 long으로 모두 바꾼 뒤
// 다 맞았다!