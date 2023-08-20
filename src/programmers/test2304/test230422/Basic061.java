package programmers.test2304.test230422;

public class Basic061 {

	public static void main(String[] args) {
		Basic061 b = new Basic061();

		String x = "43 + 12";
		String y = "0 - 7777";
		String z = "40000 * 40000";

		System.out.println(b.solution(x));
		System.out.println(b.solution(y));
		System.out.println(b.solution(z));

	}

	public int solution(String binomial) {
		int answer = 0;

		if (binomial.contains("+")) {
			String[] s = binomial.split(" \\+ ");
			answer = Integer.parseInt(s[0]) + Integer.parseInt(s[1]);
		} else if (binomial.contains("-")) {
			String[] s = binomial.split(" \\- ");
			answer = Integer.parseInt(s[0]) - Integer.parseInt(s[1]);
		} else {
			String[] s = binomial.split(" \\* ");
			answer = Integer.parseInt(s[0]) * Integer.parseInt(s[1]);
		}

		return answer;
	}

}
