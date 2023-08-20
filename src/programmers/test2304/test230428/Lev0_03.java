package programmers.test2304.test230428;

public class Lev0_03 {

	public static void main(String[] args) {
		Lev0_03 l = new Lev0_03();

		int[][] x = { { 1, 1 }, { 2, 1 }, { 2, 2 }, { 1, 2 } };
		int[][] y = { { -1, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 } };

		System.out.println(l.solution(x));
		System.out.println(l.solution(y));

	}

	public int solution(int[][] dots) {
		int width = 0;
		int length = 0;
		for (int i = 1; i < dots.length; i++) {
			int a = dots[0][0];
			int b = dots[0][1];

			if (a == dots[i][0]) {
				length = Math.abs(dots[i][1] - dots[0][1]);
			}
			if (b == dots[i][1]) {
				width = Math.abs(dots[i][0] - dots[0][0]);
			}
		}
		return width*length;
	}

}
