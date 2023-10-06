package programmers.test2310;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class PickMandarin {
	public static void main(String[] args) {
		PickMandarin pm = new PickMandarin();

		int[] tangerine1 = {1, 3, 2, 5, 4, 5, 2, 3};
		int[] tangerine2 = {1, 3, 2, 5, 4, 5, 2, 3};
		int[] tangerine3 = {1, 1, 1, 1, 2, 2, 2, 3};

		System.out.println(pm.solution(6, tangerine1));
		System.out.println(pm.solution(4, tangerine2));
		System.out.println(pm.solution(2, tangerine3));
	}

	public int solution(int k, int[] tangerine) {
		int answer = 0;
		Map<Integer, Integer> count = new HashMap<>();
		for (int i = 0; i < tangerine.length; i++) {
			count.put(tangerine[i], count.getOrDefault(tangerine[i], 0) + 1);
		}

		PriorityQueue<Integer> numOfKind = new PriorityQueue<>(Comparator.reverseOrder());
		for (Integer i : count.values()) {
			numOfKind.offer(i);
		}
		while (k > 0) {
			k -= numOfKind.peek();
			numOfKind.poll();
			answer++;
		}
		return answer;
	}
}

/*
테스트 1 〉통과 (41.65ms, 80.8MB)
테스트 2 〉통과 (28.53ms, 97.5MB)
테스트 3 〉통과 (19.40ms, 94.5MB)
테스트 4 〉통과 (19.52ms, 95.6MB)
테스트 5 〉통과 (32.22ms, 91.1MB)
테스트 6 〉통과 (21.95ms, 86.5MB)
테스트 7 〉통과 (18.40ms, 97.9MB)
테스트 8 〉통과 (28.72ms, 92.9MB)
테스트 9 〉통과 (29.28ms, 92.8MB)
테스트 10 〉통과 (24.31ms, 86.6MB)
테스트 11 〉통과 (0.49ms, 72.3MB)
테스트 12 〉통과 (0.36ms, 74.4MB)
테스트 13 〉통과 (0.61ms, 78.9MB)
테스트 14 〉통과 (0.59ms, 71.6MB)
테스트 15 〉통과 (0.61ms, 71.9MB)
테스트 16 〉통과 (0.48ms, 76.7MB)
테스트 17 〉통과 (0.44ms, 76MB)
테스트 18 〉통과 (0.47ms, 77.1MB)
테스트 19 〉통과 (0.57ms, 76MB)
테스트 20 〉통과 (0.41ms, 76.5MB)
테스트 21 〉통과 (1.16ms, 70.3MB)
테스트 22 〉통과 (1.74ms, 72.2MB)
테스트 23 〉통과 (2.51ms, 77.7MB)
테스트 24 〉통과 (1.57ms, 76.2MB)
테스트 25 〉통과 (11.84ms, 84.8MB)
테스트 26 〉통과 (12.29ms, 78.4MB)
테스트 27 〉통과 (60.49ms, 94.1MB)
테스트 28 〉통과 (57.03ms, 104MB)
테스트 29 〉통과 (73.56ms, 102MB)
테스트 30 〉통과 (53.43ms, 104MB)
테스트 31 〉통과 (20.53ms, 90.2MB)
테스트 32 〉통과 (25.87ms, 102MB)
테스트 33 〉통과 (73.28ms, 100MB)
테스트 34 〉통과 (42.93ms, 89.8MB)
 */