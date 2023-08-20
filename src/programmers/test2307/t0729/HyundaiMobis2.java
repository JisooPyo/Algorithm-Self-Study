package programmers.test2307.t0729;

public class HyundaiMobis2 {
	public static void main(String[] args) {
		HyundaiMobis2 hm = new HyundaiMobis2();
		int k1 = 3;
		int n1 = 5;
		int[][] reqs1 = {{10, 60, 1}, {15, 100, 3}, {20, 30, 1}, {30, 50, 3},
				{50, 40, 1}, {60, 30, 2}, {65, 30, 1}, {70, 100, 2}};
		// 25

		int k2 = 2;
		int n2 = 3;
		int[][] reqs2 = {{5, 55, 2}, {10, 90, 2}, {20, 40, 2}, {50, 45, 2}, {100, 50, 2}};
		// 90

		System.out.println(hm.solution(3, 5, reqs1));
		System.out.println(hm.solution(2, 3, reqs2));
	}

	// 상담유형 : k 1개 ~ 5개
	// 멘토의 수 : n 상담유형개수보다 크거나 같다. 최대 20명
	// reqs : 시각, 상담 시간, 상담 유형
	public int solution(int k, int n, int[][] reqs) {
		int[][] mentos = new int[n][2]; // 유형, 상담끝나는 시간
		for (int i = 1; i <= k; i++) {
			mentos[i - 1][0] = i;
		}

		int time = 0;
		Loop1:
		for (int i = 0; i < reqs.length; i++) {
			for (int j = 0; j < mentos.length; j++) {
				if (mentos[j][0] == reqs[i][2] && mentos[j][1] <= reqs[i][0]) {
					mentos[j][1] += mentos[j][1] == 0 ? reqs[i][0] + reqs[i][1] : reqs[i][1];
					continue Loop1;
				}
			}
			for (int j = 0; j < mentos.length; j++) {
				if (mentos[j][0] == 0) {
					mentos[j][0] = reqs[i][2];
					mentos[j][1] = reqs[i][0] + reqs[i][1];
					continue Loop1;
				}
			}
			int min = minIndex(mentos, reqs[i][2]);
			time += mentos[min][1] - reqs[i][0];
			mentos[min][1] += reqs[i][1];
		}
		return time;
	}

	private int minIndex(int[][] mentos, int type) {
		int index = Integer.MAX_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < mentos.length; i++) {
			if (mentos[i][0] == type && min > mentos[i][1]) {
				min = mentos[i][1];
				index = i;
			}
		}
		return index;
	}
}

