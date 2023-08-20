// 최소 직사각형

package programmers.test2305.test230508;

import java.util.Arrays;

public class Lev1_037 {

	public static void main(String[] args) {
		Lev1_037 lev = new Lev1_037();

		int[][] t1 = { { 60, 50 }, { 30, 70 }, { 60, 30 }, { 80, 40 } };
		int[][] t2 = { { 10, 7 }, { 12, 3 }, { 8, 15 }, { 14, 7 }, { 5, 15 } };
		int[][] t3 = { { 14, 4 }, { 19, 6 }, { 6, 16 }, { 18, 7 }, { 7, 11 } };

		System.out.println(lev.solution(t1));
		System.out.println(lev.solution(t2));
		System.out.println(lev.solution(t3));
	}

	public int solution(int[][] sizes) {
		for (int i = 0; i < sizes.length; i++) {
			Arrays.sort(sizes[i]);
		}
		int w_max = sizes[0][0];
		int h_max = sizes[0][1];
		for (int i = 1; i < sizes.length; i++) {
			if (sizes[i][0] > w_max) {
				w_max = sizes[i][0];
			}
			if (sizes[i][1] > h_max) {
				h_max = sizes[i][1];
			}
		}
		return w_max * h_max;
	}

}
