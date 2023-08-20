package programmers.test2307.t0729;

import java.util.Arrays;

public class HyundaiMobis4 {
	public static void main(String[] args) {
		HyundaiMobis4 hm = new HyundaiMobis4();
		int k1 = 3;
		int n1 = 5;
		int[][] reqs1 = {{10, 60, 1}, {15, 100, 3}, {20, 30, 1}, {30, 50, 3}, {50, 40, 1}, {60, 30, 2}, {65, 30, 1}, {70, 100, 2}};
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
		int[][] waitingTime = new int[n - k + 1][k];
		for (int i = 0; i < n - k + 1; i++) {

			int[][] mentos = new int[k][i + 1];
			int[] timeRecord = new int[k];

			for (int j = 0; j < reqs.length; j++) {
				System.out.println(Arrays.deepToString(reqs));
				boolean hasFreeMento = false;
				boolean hasEmptyMento = false;
				int freeMentoIndex = 0;
				int emptyMentoIndex = 0;
				int minTime = Integer.MAX_VALUE;
				int minTimeIndex = 0;
				int type = reqs[j][2];
				for (int m = 0; m < i + 1; m++) {
					if (mentos[type - 1][m] <= reqs[j][0]) {
						hasFreeMento = true;
						freeMentoIndex = m;
						break;
					} else if (mentos[type - 1][m] == 0) {
						hasEmptyMento = true;
						emptyMentoIndex = m;
						break;
					} else if (minTime > mentos[type - 1][m]) {
						minTime = mentos[type - 1][m];
						minTimeIndex = m;
					}
				}
				if (hasFreeMento) {
					mentos[type - 1][freeMentoIndex] = reqs[j][0] + reqs[j][1];
				} else if (hasEmptyMento) {
					mentos[type - 1][emptyMentoIndex] += reqs[j][0] + reqs[j][1];
				} else {
					mentos[type - 1][minTimeIndex] += reqs[j][1];
					timeRecord[type - 1] += minTime - reqs[j][0];
				}
				System.out.println("mentos : " + Arrays.deepToString(mentos));
				System.out.println("timeRecord : " + Arrays.toString(timeRecord));
			}
			for (int j = 0; j < k; j++) {
				waitingTime[i][j] = timeRecord[j] < 0 ? 0 : timeRecord[j];
			}
			System.out.println("waitingTime" + Arrays.deepToString(waitingTime));
		}

		int[] compareIndex = new int[k];
		int[] answerArr = waitingTime[0].clone();

		for (int i = 1; i <= n - k; i++) {
			int diffTimeMin = Integer.MIN_VALUE;
			int minIndex = 0;
			for (int j = 0; j < k; j++) {
				if (waitingTime[compareIndex[j]][j] - waitingTime[compareIndex[j] + 1][j] > diffTimeMin) {
					diffTimeMin = waitingTime[compareIndex[j]][j] - waitingTime[compareIndex[j] + 1][j];
					minIndex = j;
				}
			}
			compareIndex[minIndex]++;
			answerArr[minIndex] = waitingTime[compareIndex[minIndex]][minIndex];
		}

		int answer = 0;
		for (int i = 0; i < answerArr.length; i++) {
			answer += answerArr[i];
		}

		return answer;
	}

	// 피드백 : 메서드로 나눠보자.

}

