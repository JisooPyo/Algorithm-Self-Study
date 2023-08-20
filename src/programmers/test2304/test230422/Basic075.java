package programmers.test2304.test230422;

public class Basic075 {

	public static void main(String[] args) {
		Basic075 b = new Basic075();

		String[] x = { "progressive", "hamburger", "hammer", "ahocorasick" };
		int[][] y = { { 0, 4 }, { 1, 2 }, { 3, 5 }, { 7, 7 } };

		System.out.println(b.solution(x, y));

	}

	public String solution(String[] my_strings, int[][] parts) {
		String answer = "";
		for (int i = 0; i < parts.length; i++) {
			int s = parts[i][0];
			int e = parts[i][1];
			answer += my_strings[i].substring(s, e + 1);
		}
		return answer;
	}

}
