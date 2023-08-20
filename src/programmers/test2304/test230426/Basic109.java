package programmers.test2304.test230426;

public class Basic109 {

	public static void main(String[] args) {
		Basic109 b = new Basic109();

		int[][] x = { { 5, 192, 33 }, { 192, 72, 95 }, { 33, 95, 999 } };
		int[][] y = { { 19, 498, 258, 587 }, { 63, 93, 7, 754 }, { 258, 7, 1000, 723 }, { 587, 754, 723, 81 } };

		System.out.println(b.solution(x));
		System.out.println(b.solution(y));

	}

	public int solution(int[][] arr) {
		int answer = 0;
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (arr[i][j] == arr[j][i]) {
					answer += 1;
				}
			}
		}
		return (answer == len * len) ? 1 : 0;
	}

}
