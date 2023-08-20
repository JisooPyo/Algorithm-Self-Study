package programmers.test2304.test230429;
/*
선분 세 개로 삼각형을 만들기 위해서는 다음과 같은 조건을 만족해야 합니다.
가장 긴 변의 길이는 다른 두 변의 길이의 합보다 작아야 합니다.
삼각형의 두 변의 길이가 담긴 배열 sides이 매개변수로 주어집니다.
나머지 한 변이 될 수 있는 정수의 개수를 return하도록 solution 함수를 완성해주세요.

제한사항
sides의 원소는 자연수입니다.
sides의 길이는 2입니다.
1 ≤ sides의 원소 ≤ 1,000
 */
public class Lev0_07 {

	public static void main(String[] args) {
		Lev0_07 l = new Lev0_07();

		int[] t1 = { 1, 2 };
		int[] t2 = { 3, 6 };
		int[] t3 = { 11, 7 };

		System.out.println(l.solution(t1));
		System.out.println(l.solution(t2));
		System.out.println(l.solution(t3));

	}

	public int solution(int[] sides) {
		int sum = sides[0] + sides[1];
		int diff = Math.abs(sides[0] - sides[1]);

		return sum - diff - 1;
	}

}
