package programmers.test2304.test230415;

import java.util.Arrays;

public class TurnArrayProblem {

	public static void main(String[] args) {

		TurnArrayProblem ta = new TurnArrayProblem();

		int[] x1 = { 1, 2, 3 };
		String x2 = "right";

		int[] y1 = { 4, 455, 6, 4, -1, 45, 6 };
		String y2 = "left";

		System.out.println(Arrays.toString(ta.solution(x1, x2)));
		System.out.println(Arrays.toString(ta.solution(y1, y2)));

	}

	public int[] solution(int[] numbers, String direction) {

		int[] answer = new int[numbers.length];

		if (direction.equals("right")) {
			
			for (int i = 0; i < numbers.length - 1; i++) {
				answer[i + 1] = numbers[i];
			}
			
			answer[0] = numbers[numbers.length - 1];
			
		} else {
			
			for (int i = 0; i < numbers.length - 1; i++) {
				answer[i] = numbers[i + 1];
			}
			
			answer[numbers.length - 1] = numbers[0];
			
		}
		return answer;

	}

}
