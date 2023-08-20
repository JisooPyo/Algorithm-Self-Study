package programmers.test2307.t0729;

import java.util.Arrays;

public class HyundaiMobis1 {
	public static void main(String[] args) {
		HyundaiMobis1 hm = new HyundaiMobis1();
		int k1 = 3;
		int n1 = 5;
		int[][] reqs1 = {{10, 60, 1}, {15, 100, 3}, {20, 30, 1}, {30, 50, 3}, {50, 40, 1}, {60, 30, 2}, {65, 30, 1}, {70, 100, 2}};
		// 25

		int k2 = 2;
		int n2 = 3;
		int[][] reqs2 = {{5, 55, 2}, {10, 90, 2}, {20, 40, 2}, {50, 45, 2}, {100, 50, 2}};
		// 90

		int k3 = 5;
		int n3 = 20;
		int[][] reqs3 = {{5, 55, 2}, {10, 90, 2}, {20, 40, 2}, {50, 45, 2}, {100, 50, 2}};

//		System.out.println(hm.solution(k1, n1, reqs1));
//		System.out.println(hm.solution(k2, n2, reqs2));
		System.out.println(hm.solution(k3, n3, reqs3));
	}

	// 상담유형 : k 1개 ~ 5개
	// 멘토의 수 : n 상담유형개수보다 크거나 같다. 최대 20명
	// reqs : 시각, 상담 시간, 상담 유형
	public int solution(int k, int n, int[][] reqs) {
		int[][] mentos = new int[n][2];
		System.out.println(Arrays.deepToString(mentos));

//		n-kPk
		return 0;
	}


}
