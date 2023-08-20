package programmers.test2304.test230426;

public class Basic123 {

	public static void main(String[] args) {
		Basic123 b = new Basic123();

		String x1 = "AbCdEFG";
		String p1 = "dE";

		String x2 = "AAAAaaaa";
		String p2 = "a";

		System.out.println(b.solution(x1, p1));
		System.out.println(b.solution(x2, p2));

	}

	public String solution(String myString, String pat) {
		String answer = "";
		int index = myString.lastIndexOf(pat);
		answer = myString.substring(0, index) + pat;
		return answer;
	}

}
