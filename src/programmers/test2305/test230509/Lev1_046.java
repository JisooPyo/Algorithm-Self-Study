// 가장 가까운 같은 글자
package programmers.test2305.test230509;

import java.util.Arrays;

public class Lev1_046 {

	public static void main(String[] args) {
		Lev1_046 lev = new Lev1_046();

		String t1 = "banana";
		String t2 = "foobar";

		System.out.println(Arrays.toString(lev.solution(t1)));
		System.out.println(Arrays.toString(lev.solution(t2)));

	}

	public int[] solution(String s) {
		int[] answer = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			answer[i] = s.substring(0, i).lastIndexOf(s.charAt(i));
			if (answer[i] != -1) {
				answer[i] = i - answer[i];
			}
		}
		return answer;
	}

}
