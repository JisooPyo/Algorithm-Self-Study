// 신고 결과 받기
package programmers.test2306.test230621;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lv1ReportResults_other2 {
	public int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];
		Map<String, Integer> idIndex = new HashMap<>();
		Map<String, List<String>> reportMap = new HashMap<>();

		for (int i = 0; i < id_list.length; i++) {
			idIndex.put(id_list[i], i);
			reportMap.put(id_list[i], new ArrayList<>());
		}

		for (String reported : report) {
			String[] temp = reported.split(" ");
			if (!reportMap.get(temp[1]).contains(temp[0])) {
				reportMap.get(temp[1]).add(temp[0]);
			}
		}

		for (String id : reportMap.keySet()) {
			if (k <= reportMap.get(id).size()) {
				for (String reporter : reportMap.get(id)) {
					answer[idIndex.get(reporter)]++;
				}
			}
		}

		return answer;
	}
}

/*
테스트 1 〉통과 (0.14ms, 79MB)
테스트 2 〉통과 (0.25ms, 70.5MB)
테스트 3 〉통과 (312.04ms, 150MB)
테스트 4 〉통과 (0.38ms, 72.7MB)
테스트 5 〉통과 (0.44ms, 79.6MB)
테스트 6 〉통과 (3.45ms, 79.2MB)
테스트 7 〉통과 (10.30ms, 88.1MB)
테스트 8 〉통과 (10.39ms, 88.8MB)
테스트 9 〉통과 (112.28ms, 126MB)
테스트 10 〉통과 (119.35ms, 132MB)
테스트 11 〉통과 (266.67ms, 153MB)
테스트 12 〉통과 (1.26ms, 75.2MB)
테스트 13 〉통과 (1.19ms, 75.7MB)
테스트 14 〉통과 (82.91ms, 141MB)
테스트 15 〉통과 (170.99ms, 144MB)
테스트 16 〉통과 (1.31ms, 76.9MB)
테스트 17 〉통과 (1.34ms, 73.5MB)
테스트 18 〉통과 (1.88ms, 72.3MB)
테스트 19 〉통과 (3.96ms, 79.3MB)
테스트 20 〉통과 (87.50ms, 134MB)
테스트 21 〉통과 (198.82ms, 143MB)
테스트 22 〉통과 (0.19ms, 73.6MB)
테스트 23 〉통과 (0.11ms, 72.8MB)
테스트 24 〉통과 (0.11ms, 76.8MB)
 */