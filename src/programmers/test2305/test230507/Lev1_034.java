// 3진법 뒤집기
package programmers.test2305.test230507;

public class Lev1_034 {

	public static void main(String[] args) {
		Lev1_034 lev = new Lev1_034();

		System.out.println(lev.solution(45));
		// 45 -> 1200 -> 0021 -> 7
		System.out.println(lev.solution(125));

	}

	public int solution(int n) {
		StringBuilder sb = new StringBuilder();
		sb.append(Integer.toString(n, 3)).reverse();
		String sb_str = sb.toString();
		return Integer.parseInt(sb_str, 3);
	}

}
