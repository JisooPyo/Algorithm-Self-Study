package programmers.test2304.test230423;

public class Basic077 {

	public static void main(String[] args) {
		Basic077 b = new Basic077();

		String x = "3 + 4 - 5 - 2 + 7 + 10";

		System.out.println(b.solution(x));

		String[] xs = x.split(" ");
		System.out.println(xs[1].equals("+"));

	}

	public int solution(String my_string) {
		int answer = 0;
		String[] ans = my_string.split(" ");
		answer += Integer.parseInt(ans[0]);
		for (int i = 0; i < ans.length; i++) {
			if (ans[i].equals("+")) {
				answer += Integer.parseInt(ans[i + 1]);
			} else if (ans[i].equals("-")) {
				answer -= Integer.parseInt(ans[i + 1]);
			}

		}
		return answer;
	}

}
