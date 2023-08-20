package programmers.test2304.test230428;

import java.util.Arrays;

public class Lev0_04 {

	public static void main(String[] args) {
		Lev0_04 l = new Lev0_04();

		String[] x1 = { "left", "right", "up", "right", "right" };
		int[] x2 = { 11, 11 };

		String[] y1 = { "down", "down", "down", "down", "down" };
		int[] y2 = { 7, 9 };

		System.out.println(Arrays.toString(l.solution(x1, x2)));
		System.out.println(Arrays.toString(l.solution(y1, y2)));

	}

	public int[] solution(String[] keyinput, int[] board) {
		int[] answer = new int[] { 0, 0 };
		int w = (board[0] - 1) / 2;
		int h = (board[1] - 1) / 2;
		for (int i = 0; i < keyinput.length; i++) {

			if (keyinput[i].equals("left") && ((w * (-1)) < answer[0])) {
				answer[0] -= 1;
			} else if (keyinput[i].equals("right") && (answer[0] < w)) {
				answer[0] += 1;
			} else if (keyinput[i].equals("up") && (answer[1] < h)) {
				answer[1] += 1;
			} else if (keyinput[i].equals("down") && ((h * (-1)) < answer[1])) {
				answer[1] -= 1;
			}

		}
		return answer;
	}

}
