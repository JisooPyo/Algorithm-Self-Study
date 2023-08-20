package programmers.test2304.test230417;

public class CtrlZProblem {

	public static void main(String[] args) {

		CtrlZProblem cz = new CtrlZProblem();

		String x1 = "1 2 Z 3";
		String x2 = "10 20 30 40";
		String x3 = "10 Z 20 Z 1";
		String x4 = "10 Z 20 Z";
		String x5 = "-1 -2 -3 Z";

		System.out.println(cz.solution(x1));
		System.out.println(cz.solution(x2));
		System.out.println(cz.solution(x3));
		System.out.println(cz.solution(x4));
		System.out.println(cz.solution(x5));

	}

	public int solution(String s) {
		String[] splitS = s.split(" "); // {"1", "2", "Z", "3"}

		int answer = Integer.parseInt(splitS[0]);

		for (int i = 1; i < splitS.length; i++) {
			if (splitS[i].equals("Z")) {
				answer = answer - Integer.parseInt(splitS[i - 1]);
			} else {
				answer = answer + Integer.parseInt(splitS[i]);
			}

		}
		
		return answer;

	}
}

// String[] = string.split(" ")
// Inter.parseInt
