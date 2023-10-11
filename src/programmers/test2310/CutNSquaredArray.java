package programmers.test2310;

import java.util.Arrays;

public class CutNSquaredArray {
	public static void main(String[] args) {
		CutNSquaredArray cnsa = new CutNSquaredArray();

		System.out.println(Arrays.toString(cnsa.solution(3, 2, 5)));
		System.out.println(Arrays.toString(cnsa.solution(4, 7, 14)));
	}

	public int[] solution(int n, long left, long right) {
		int[] answer = new int[(int) (right - left + 1)];
		int index = 0;
		for (long l = left; l <= right; l++) {
			answer[index++] = Math.max((int) (l / n), (int) (l % n)) + 1;
		}
		return answer;
	}
}

/*
테스트 1 〉통과 (7.18ms, 91.6MB)
테스트 2 〉통과 (4.83ms, 102MB)
테스트 3 〉통과 (5.51ms, 109MB)
테스트 4 〉통과 (0.04ms, 73.6MB)
테스트 5 〉통과 (0.05ms, 75.8MB)
테스트 6 〉통과 (4.89ms, 105MB)
테스트 7 〉통과 (6.01ms, 92.1MB)
테스트 8 〉통과 (6.37ms, 104MB)
테스트 9 〉통과 (4.72ms, 110MB)
테스트 10 〉통과 (6.54ms, 105MB)
테스트 11 〉통과 (5.08ms, 91.3MB)
테스트 12 〉통과 (4.57ms, 108MB)
테스트 13 〉통과 (4.49ms, 90.5MB)
테스트 14 〉통과 (4.33ms, 91.7MB)
테스트 15 〉통과 (4.30ms, 102MB)
테스트 16 〉통과 (4.80ms, 104MB)
테스트 17 〉통과 (7.16ms, 95.5MB)
테스트 18 〉통과 (7.62ms, 96.8MB)
테스트 19 〉통과 (4.88ms, 92.9MB)
테스트 20 〉통과 (4.51ms, 109MB)
 */