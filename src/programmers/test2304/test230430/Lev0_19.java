/*

문제 설명

문자열 "hello"에서 각 문자를 오른쪽으로 한 칸씩 밀고 마지막 문자는 맨 앞으로 이동시키면 "ohell"이 됩니다.
이것을 문자열을 민다고 정의한다면 문자열 A와 B가 매개변수로 주어질 때,
A를 밀어서 B가 될 수 있다면 밀어야 하는 최소 횟수를 return하고 밀어서 B가 될 수 없으면 -1을 return 하도록 solution 함수를 완성해보세요.

제한사항

0 < A의 길이 = B의 길이 < 100
A, B는 알파벳 소문자로 이루어져 있습니다.

*/

package programmers.test2304.test230430;

public class Lev0_19 {

	public static void main(String[] args) {
		Lev0_19 lev = new Lev0_19();

		String t1 = "hello";
		String t2 = "ohell";
		String t3 = "apple";
		String t4 = "elppa";
		String t5 = "atat";
		String t6 = "tata";
		String t7 = "abc";
		String t8 = "abc";

		System.out.println(lev.solution(t1, t2));
		System.out.println(lev.solution(t3, t4));
		System.out.println(lev.solution(t5, t6));
		System.out.println(lev.solution(t7, t8));

	}

	public int solution(String A, String B) {
		int answer = -1;
		for (int i = A.length(); i >= 1; i--) {
			if ((A + A).substring(i, i + A.length()).equals(B)) {
				answer = A.length()-i;
				break;
			}
		}
		return answer;
	}

}
