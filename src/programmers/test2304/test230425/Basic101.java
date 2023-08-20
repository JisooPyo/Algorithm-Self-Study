package programmers.test2304.test230425;

public class Basic101 {

	public static void main(String[] args) {
		Basic101 b = new Basic101();

		String x1 = "ABBAA";
		String x2 = "AABB";

		String y1 = "ABAB";
		String y2 = "ABAB";

		System.out.println(b.solution(x1, x2));
		System.out.println(b.solution(y1, y2));

	}

	public int solution(String myString, String pat) {
		char[] ch = myString.toCharArray();
		String a = "";
		for (int i = 0; i < ch.length; i++) {
			if (Character.compare(ch[i], 'A') == 0) {
				a += "B";
			} else {
				a += "A";
			}
		}
		return a.contains(pat) ? 1 : 0;
	}

}

/*

다른 사람의 풀이

import java.util.stream.Stream;
import java.util.stream.Collectors;

class Solution {
public int solution(String myString, String pat) {
	return myString.contains(
			Stream.of(pat.split(""))
			.map(str -> "A".equals(str) ? "B" : "A")
			.collect(Collectors.joining()))
			? 1 : 0;
}
}

*/