package programmers.test2304.test230429;

/*
지뢰가 있는 지역과 지뢰에 인접한 위, 아래, 좌, 우 대각선 칸을 모두 위험지역으로 분류합니다.
지뢰는 2차원 배열 board에 1로 표시되어 있고 board에는 지뢰가 매설 된 지역 1과, 지뢰가 없는 지역 0만 존재합니다.
지뢰가 매설된 지역의 지도 board가 매개변수로 주어질 때, 안전한 지역의 칸 수를 return하도록 solution 함수를 완성해주세요.
 */
public class Lev0_06 {

	public static void main(String[] args) {
		Lev0_06 l = new Lev0_06();

		int[][] t1 = { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 } };

		int[][] t2 = { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 1, 1, 0 }, { 0, 0, 0, 0, 0 } };

		int[][] t3 = { { 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1 } };

		System.out.println(l.solution(t1));
		System.out.println(l.solution(t2));
		System.out.println(l.solution(t3));

	}

	public int solution(int[][] board) {
		int answer = 0;
		int n = board.length;
		if (n == 1) {
			return board[0][0] == 0 ? 1 : 0;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 0) {
					if (i == 0 || i == n - 1 || j == 0 || j == n - 1) {
						if (i == 0 && j == 0) {
							if (board[0][1] == 0 && board[1][1] == 0 && board[1][0] == 0) {
								answer++;
							}
						} else if (i == 0 && j == n - 1) {
							if (board[0][n - 2] == 0 && board[1][n - 2] == 0 && board[1][n - 1] == 0) {
								answer++;
							}
						} else if (i == n - 1 && j == 0) {
							if (board[n - 2][0] == 0 && board[n - 2][1] == 0 && board[n - 1][1] == 0) {
								answer++;
							}
						} else if (i == n - 1 && j == n - 1) {
							if (board[n - 1][n - 2] == 0 && board[n - 2][n - 2] == 0 && board[n - 2][n - 1] == 0) {
								answer++;
							}
						} else if (i == 0) {
							if (board[0][j - 1] == 0 && board[1][j - 1] == 0 && board[1][j] == 0 && board[1][j + 1] == 0
									&& board[0][j + 1] == 0) {
								answer++;
							}
						} else if (i == n - 1) {
							if (board[n - 1][j - 1] == 0 && board[n - 2][j - 1] == 0 && board[n - 2][j] == 0
									&& board[n - 2][j + 1] == 0 && board[n - 1][j + 1] == 0) {
								answer++;
							}
						} else if (j == 0) {
							if (board[i - 1][0] == 0 && board[i - 1][1] == 0 && board[i][1] == 0 && board[i + 1][1] == 0
									&& board[i + 1][0] == 0) {
								answer++;
							}
						} else if (j == n - 1) {
							if (board[i - 1][n - 1] == 0 && board[i - 1][n - 2] == 0 && board[i][n - 2] == 0
									&& board[i + 1][n - 2] == 0 && board[i + 1][n - 1] == 0) {
								answer++;
							}
						}
					} else {
						if (board[i - 1][j - 1] == 0 && board[i - 1][j] == 0 && board[i - 1][j + 1] == 0
								&& board[i][j - 1] == 0 && board[i][j + 1] == 0 && board[i + 1][j - 1] == 0
								&& board[i + 1][j] == 0 && board[i + 1][j + 1] == 0) {
							answer++;
						}
					}
				}
			}
		}
		return answer;
	}

}

/*
바깥에 하나를 더 두르면 좀 더 짧게 해결되었을 걸!!!
*/