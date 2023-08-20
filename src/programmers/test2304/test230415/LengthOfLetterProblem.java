package programmers.test2304.test230415;

public class LengthOfLetterProblem {

	public static void main(String[] args) {

		LengthOfLetterProblem lol = new LengthOfLetterProblem();

		String x = "happy birthday!";
		String y = "I love you~";

		System.out.println(lol.solution(x));
		System.out.println(lol.solution(y));

	}

	public int solution(String message) {

		return message.length() * 2;
	}

}
