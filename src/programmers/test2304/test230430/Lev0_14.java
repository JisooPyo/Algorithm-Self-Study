package programmers.test2304.test230430;

import java.util.Arrays;
import java.util.Collections;

public class Lev0_14 {

	public static void main(String[] args) {
		Lev0_14 lev = new Lev0_14();

		int[][] t1 = { { 80, 70 }, { 90, 50 }, { 40, 70 }, { 50, 80 } };
		int[][] t2 = { { 80, 70 }, { 70, 80 }, { 30, 50 }, { 90, 100 }, { 100, 90 }, { 100, 100 }, { 10, 30 } };
		int[][] t3 = { { 1, 3 }, { 3, 1 }, { 2, 3 }, { 3, 2 }, { 1, 2 }, { 0, 0 } };

		System.out.println(Arrays.toString(lev.solution(t1)));
		System.out.println(Arrays.toString(lev.solution(t2)));
		System.out.println(Arrays.toString(lev.solution(t3)));

	}

	public int[] solution(int[][] score) {
		double[] avr = new double[score.length];

		for (int i = 0; i < avr.length; i++) {
			avr[i] = (double) (score[i][0] + score[i][1]) / 2;
		}

		Double[] sortAvr = Arrays.stream(avr).boxed().toArray(Double[]::new);
		Arrays.sort(sortAvr, Collections.reverseOrder());

		int[] rank = new int[avr.length];
		for (int i = 0; i < avr.length; i++) {
			for (int j = 0; j < sortAvr.length; j++) {
				if (avr[i] == sortAvr[j]) {
					rank[i] = j + 1;
					break;
				}
			}
		}

		return rank;
	}

}

//3,6 실패 --> 평균을 int로 한 실수