package programmers.test2304.test230427;

public class Basic131 {

	public static void main(String[] args) {
		Basic131 b = new Basic131();

		int[][] board = { { 0, 1, 2 }, { 1, 2, 3 }, { 2, 3, 4 }, { 3, 4, 5 } };
		int k = 2;

		System.out.println(b.solution(board, k));

	}

	public int solution(int[][] board, int k) {
		int sum = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if ((i + j) <= k) {
					sum += board[i][j];
				}
			}
		}
		return sum;
	}

}
