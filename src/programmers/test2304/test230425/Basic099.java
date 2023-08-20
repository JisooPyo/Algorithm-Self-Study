package programmers.test2304.test230425;

public class Basic099 {

	public static void main(String[] args) {
		Basic099 b = new Basic099();

		String x = "qjnwezgrpirldywt";
		String y = "programmers";

		System.out.println(b.solution(3, 1, x));
		System.out.println(b.solution(1, 0, y));

	}

	public String solution(int q, int r, String code) {
		String answer = "";
		for (int i = r; i < code.length(); i += q) {
			answer += code.charAt(i);
		}
		return answer;
	}

}
