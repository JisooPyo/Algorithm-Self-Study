package programmers.test2304.test230412;

public class RepeatWordProblem {

	public static void main(String[] args) {

		RepeatWordProblem rw = new RepeatWordProblem();

		System.out.println(rw.solution("hello", 3));

	}

	public StringBuffer solution(String my_string, int n) {

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < my_string.length(); i++) {
			for (int j = 1; j <= n; j++) {
				sb.append(my_string.charAt(i));
			}
		}

		return sb;
	}
}