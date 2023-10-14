package programmers.test2310;

import java.util.LinkedList;
import java.util.Queue;

public class Cache {
	public static void main(String[] args) {
		Cache cache = new Cache();

		int cacheSize1 = 3;
		String[] cities1 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		// 50
		int cacheSize2 = 3;
		String[] cities2 = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
		// 21
		int cacheSize3 = 2;
		String[] cities3 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
		// 60
		int cacheSize4 = 5;
		String[] cities4 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
		// 52
		int cacheSize5 = 2;
		String[] cities5 = {"Jeju", "Pangyo", "NewYork", "newyork"};
		// 16
		int cacheSize6 = 0;
		String[] cities6 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		// 25

		System.out.println(cache.solution(cacheSize1, cities1));
		System.out.println(cache.solution(cacheSize2, cities2));
		System.out.println(cache.solution(cacheSize3, cities3));
		System.out.println(cache.solution(cacheSize4, cities4));
		System.out.println(cache.solution(cacheSize5, cities5));
		System.out.println(cache.solution(cacheSize6, cities6));
	}

	public int solution(int cacheSize, String[] cities) {
		int answer = 0;
		Queue<String> cache = new LinkedList<>();
		for (int i = 0; i < cities.length; i++) {
			String str = cities[i].toLowerCase();
			if (cache.contains(str)) {
				answer += 1;
				cache.remove(str);
			} else {
				answer += 5;
			}
			if (cache.size() >= cacheSize) {
				cache.poll();
			}
			if (cacheSize != 0) {
				cache.add(str);
			}
		}
		return answer;
	}
}

// 틀린 이유
// 1. 이전에 캐시에 있던 것을 불러올 경우 다시 최신 캐시에 올려주어야 하는데 그 부분을 신경을 못 썼다.
// 2. cacheSize가 0일 경우 cache에 아예 넣지 않아야 하는데 이 부분을 신경을 못 썼다.

/*
테스트 1 〉통과 (0.24ms, 69.7MB)
테스트 2 〉통과 (0.14ms, 87MB)
테스트 3 〉통과 (0.15ms, 75MB)
테스트 4 〉통과 (0.14ms, 75.9MB)
테스트 5 〉통과 (0.15ms, 74.3MB)
테스트 6 〉통과 (0.10ms, 67.4MB)
테스트 7 〉통과 (0.13ms, 80.4MB)
테스트 8 〉통과 (0.17ms, 75.7MB)
테스트 9 〉통과 (0.17ms, 76MB)
테스트 10 〉통과 (0.48ms, 80.3MB)
테스트 11 〉통과 (36.90ms, 123MB)
테스트 12 〉통과 (0.31ms, 72.6MB)
테스트 13 〉통과 (0.68ms, 74.4MB)
테스트 14 〉통과 (1.53ms, 82.5MB)
테스트 15 〉통과 (1.46ms, 81.2MB)
테스트 16 〉통과 (1.69ms, 70.1MB)
테스트 17 〉통과 (1.56ms, 84MB)
테스트 18 〉통과 (3.21ms, 71.8MB)
테스트 19 〉통과 (2.01ms, 80.4MB)
테스트 20 〉통과 (2.18ms, 101MB)
 */