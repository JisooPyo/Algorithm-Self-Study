package programmers.test2304.test230422;

public class Basic068 {

	public static void main(String[] args) {
		Basic068 b = new Basic068();

		int[] test = { 0, 1, 0, 10, 0, 1, 0, 10, 0, -1, -2, -1 };

		System.out.println(b.solution(test));

	}

	public String solution(int[] numLog) {
		String answer = "";
		for (int i = 0; i < numLog.length - 1; i++) {
			int minus = numLog[i + 1] - numLog[i];
			if (minus == 1) {
				answer += "w";
			} else if (minus == -1) {
				answer += "s";
			} else if (minus == 10) {
				answer += "d";
			} else {
				answer += "a";
			}
		}
		return answer;
	}

}
