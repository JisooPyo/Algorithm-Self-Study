package programmers.test2304.test230420;

public class Basic031 {

	public static void main(String[] args) {

		Basic031 b = new Basic031();

		String x = "string";
		String y = "love";

		System.out.println(b.solution(x, 3));
		System.out.println(b.solution(y, 10));

	}

	public String solution(String my_string, int k) {
		String answer = "";
		for (int i = 1; i <= k; i++) {
			answer += my_string;
		}
		return answer;
	}

}
