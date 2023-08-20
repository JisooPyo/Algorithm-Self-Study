package programmers.test2304.test230429;

public class Lev0_11_2 {

	public static void main(String[] args) {
		Lev0_11_2 lev = new Lev0_11_2();

		int[][] t1 = { { 0, 1 }, { 2, 5 }, { 3, 9 } }; // 2
		int[][] t2 = { { -1, 1 }, { 1, 3 }, { 3, 9 } }; // 0
		int[][] t3 = { { 0, 5 }, { 3, 9 }, { 1, 10 } }; // 8
		int[][] t4 = { { 0, 2 }, { -3, -1 }, { -2, 1 } }; // 2
		int[][] t5 = { { -3, -1 }, { -2, 3 }, { 2, 3 } }; // 2
		int[][] t6 = { { 0, 3 }, { -3, -1 }, { -2, 3 } }; // 4

		System.out.println(lev.solution(t1));
		System.out.println(lev.solution(t2));
		System.out.println(lev.solution(t3));
		System.out.println(lev.solution(t4));
		System.out.println(lev.solution(t5));
		System.out.println(lev.solution(t6));

	}

	public int solution(int[][] lines) {
		// 세 선분을 총괄하는 하나의 선분 길이 구하기
		int start = Math.min(lines[0][0], Math.min(lines[1][0], lines[2][0]));
		int end = Math.max(lines[0][1], Math.max(lines[1][1], lines[2][1]));
		int[] ind = new int[end - start + 1];

		for (int i = 0; i < lines.length; i++) {
			for (int j = lines[i][0]; j < lines[i][1]; j++) {
				ind[j - start]++;
			}
		}

		int sum = 0;
		for (int i = 0; i < ind.length; i++) {
			if (1 < ind[i]) {
				sum++;
			}
		}
		return sum;
	}

}
