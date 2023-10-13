package programmers.test2310;

import java.util.Arrays;

public class HIndex {
	public static void main(String[] args) {
		HIndex hi = new HIndex();

		int[] citations1 = {3, 0, 6, 1, 5};
		int[] citations2 = {0, 5, 6, 7, 8};
		int[] citations3 = {100, 100, 100};
		int[] citations4 = {0, 0, 0, 0, 0, 0};

		System.out.println(hi.solution(citations1));
		System.out.println(hi.solution(citations2));
		System.out.println(hi.solution(citations3));
		System.out.println(hi.solution(citations4));
	}

	// 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상.
	// 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index


	public int solution(int[] citations) {
		int answer = 0;
		Arrays.sort(citations);
		// [0, 1, 3, 5, 6]
		// [0, 5, 6, 7, 8]
		int index = 0;
		for (int num = 0; num <= citations[citations.length - 1]; num++) {
			if (num > citations[index]) {
				index++;
			}
			if (num <= citations.length - index) {
				answer = num;
			} else {
				break;
			}
		}
		return answer;
	}

	// 나랑 순서만 다르고 비슷한 풀이.
	public int otherSolution(int[] citations) {
		Arrays.sort(citations);
		int max = 0;
		for (int i = citations.length - 1; i > -1; i--) {
			int min = Math.min(citations[i], citations.length - i);
			if (max < min) max = min;
		}
		return max;
	}
}

/*
테스트 1 〉통과 (1.33ms, 71.3MB)
테스트 2 〉통과 (0.67ms, 78.2MB)
테스트 3 〉통과 (1.52ms, 74MB)
테스트 4 〉통과 (0.86ms, 65.3MB)
테스트 5 〉통과 (0.82ms, 66MB)
테스트 6 〉통과 (0.84ms, 74.1MB)
테스트 7 〉통과 (0.47ms, 75.8MB)
테스트 8 〉통과 (0.35ms, 76.4MB)
테스트 9 〉통과 (0.38ms, 72.3MB)
테스트 10 〉통과 (0.59ms, 81.1MB)
테스트 11 〉통과 (0.68ms, 75.7MB)
테스트 12 〉통과 (1.42ms, 77.3MB)
테스트 13 〉통과 (0.65ms, 82.5MB)
테스트 14 〉통과 (0.74ms, 76.1MB)
테스트 15 〉통과 (1.03ms, 78.5MB)
테스트 16 〉통과 (0.51ms, 77.7MB)
 */