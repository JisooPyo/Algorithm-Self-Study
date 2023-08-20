// 신고 결과 받기
package programmers.test2306.test230621;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Lv1ReportResults_try1pass {
	public static void main(String[] args) {

		Lv1ReportResults_try1pass lev = new Lv1ReportResults_try1pass();

		String[] t1_1 = {"muzi", "frodo", "apeach", "neo"};
		String[] t1_2 = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
		int t1_3 = 2;

		String[] t2_1 = {"con", "ryan"};
		String[] t2_2 = {"ryan con", "ryan con", "ryan con", "ryan con"};
		int t2_3 = 3;

		System.out.println(Arrays.toString(lev.solution(t1_1, t1_2, t1_3)));
		System.out.println(Arrays.toString(lev.solution(t2_1, t2_2, t2_3)));

	}

	public int[] solution(String[] id_list, String[] report, int k) {
		Map<String, Integer> countReport = new HashMap<>();
		Set<String> reportSet = new HashSet<>();
		// map에 id값 넣기
		for (int i = 0; i < id_list.length; i++) {
			countReport.put(id_list[i], 0);
		}

		// 중복 제거
		for (int i = 0; i < report.length; i++) {
			reportSet.add(report[i]);
		}

		// 신고횟수만큼 +1해주기
		Iterator<String> itReportSet = reportSet.iterator();
		while (itReportSet.hasNext()) {
			String[] sp = itReportSet.next().split(" ");
			countReport.put(sp[1], countReport.get(sp[1]) + 1);
		}

		// k이상인 id값 찾아 정지할 id list에 추가
		List<String> suspend = new ArrayList<>();
		for (int i = 0; i < id_list.length; i++) {
			if (countReport.get(id_list[i]).intValue() >= k) {
				suspend.add(id_list[i]);
			}
		}

		// 다시 맵 초기화
		for (int i = 0; i < id_list.length; i++) {
			countReport.put(id_list[i], 0);
		}

		// suspend에 있으면 메일 보내는 횟수 ++
		Iterator<String> itReportSet2 = reportSet.iterator();
		while (itReportSet2.hasNext()) {
			String[] sp = itReportSet2.next().split(" ");
			if (suspend.contains(sp[1])) {
				countReport.put(sp[0], countReport.get(sp[0]) + 1);
			}
		}

		// answer 구하기
		int[] answer = new int[id_list.length];
		for (int i = 0; i < id_list.length; i++) {
			answer[i] = countReport.get(id_list[i]);
		}

		return answer;
	}
}

/*
테스트 1 〉통과 (0.14ms, 77.1MB)
테스트 2 〉통과 (0.55ms, 70.9MB)
테스트 3 〉통과 (542.24ms, 188MB)
테스트 4 〉통과 (0.71ms, 70.1MB)
테스트 5 〉통과 (0.65ms, 75.7MB)
테스트 6 〉통과 (4.39ms, 79.6MB)
테스트 7 〉통과 (11.22ms, 85.2MB)
테스트 8 〉통과 (8.03ms, 101MB)
테스트 9 〉통과 (183.77ms, 138MB)
테스트 10 〉통과 (127.71ms, 137MB)
테스트 11 〉통과 (333.81ms, 180MB)
테스트 12 〉통과 (3.17ms, 81.2MB)
테스트 13 〉통과 (2.19ms, 81.7MB)
테스트 14 〉통과 (233.89ms, 139MB)
테스트 15 〉통과 (124.12ms, 147MB)
테스트 16 〉통과 (1.92ms, 83.4MB)
테스트 17 〉통과 (1.37ms, 84.1MB)
테스트 18 〉통과 (2.64ms, 75.7MB)
테스트 19 〉통과 (4.63ms, 77.2MB)
테스트 20 〉통과 (205.48ms, 135MB)
테스트 21 〉통과 (294.48ms, 151MB)
테스트 22 〉통과 (0.18ms, 76.3MB)
테스트 23 〉통과 (0.14ms, 74.2MB)
테스트 24 〉통과 (0.13ms, 73.6MB)
 */