package programmers.test2310;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class Clothes {
	public static void main(String[] args) {
		Clothes clothes = new Clothes();

		String[][] clothes1 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		// 5
		String[][] clothes2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
		// 3

		System.out.println(clothes.solution(clothes1));
		System.out.println(clothes.solution(clothes2));
	}

	// (의상의 종류 + 1) * (의상의 종류 + 1) * ... * (의상의 종류 + 1) - 1
	public int solution(String[][] clothes) {
		int answer = 1;
		Map<String, Integer> kindCount = new HashMap<>();
		for (int i = 0; i < clothes.length; i++) {
			kindCount.put(clothes[i][1], kindCount.getOrDefault(clothes[i][1], 0) + 1);
		}
		for (String key : kindCount.keySet()) {
			answer *= kindCount.get(key) + 1;
		}
		return answer - 1;
	}

	// 다른 사람의 풀이
	public int solution2(String[][] clothes) {
		return Arrays.stream(clothes)
				.collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
				.values()
				.stream()
				.collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;
	}
}



/*
테스트 1 〉통과 (0.11ms, 72.2MB)
테스트 2 〉통과 (0.08ms, 77.4MB)
테스트 3 〉통과 (0.07ms, 82.2MB)
테스트 4 〉통과 (0.11ms, 76.5MB)
테스트 5 〉통과 (0.04ms, 77.6MB)
테스트 6 〉통과 (0.06ms, 72.8MB)
테스트 7 〉통과 (0.09ms, 76.8MB)
테스트 8 〉통과 (0.10ms, 74.8MB)
테스트 9 〉통과 (0.05ms, 75.3MB)
테스트 10 〉통과 (0.06ms, 81.7MB)
테스트 11 〉통과 (0.05ms, 67.3MB)
테스트 12 〉통과 (0.07ms, 71.8MB)
테스트 13 〉통과 (0.06ms, 74.3MB)
테스트 14 〉통과 (0.06ms, 74MB)
테스트 15 〉통과 (0.05ms, 81.2MB)
테스트 16 〉통과 (0.03ms, 75.8MB)
테스트 17 〉통과 (0.04ms, 76.2MB)
테스트 18 〉통과 (0.04ms, 78MB)
테스트 19 〉통과 (0.05ms, 80MB)
테스트 20 〉통과 (0.04ms, 73.1MB)
테스트 21 〉통과 (0.06ms, 73.6MB)
테스트 22 〉통과 (0.04ms, 72.3MB)
테스트 23 〉통과 (0.05ms, 77.9MB)
테스트 24 〉통과 (0.05ms, 75MB)
테스트 25 〉통과 (0.05ms, 76.4MB)
테스트 26 〉통과 (0.09ms, 81.2MB)
테스트 27 〉통과 (0.04ms, 66.4MB)
테스트 28 〉통과 (0.07ms, 73.1MB)
 */