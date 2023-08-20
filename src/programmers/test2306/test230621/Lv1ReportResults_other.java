// 신고 결과 받기
package programmers.test2306.test230621;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Lv1ReportResults_other {
	public static void main(String[] args) {

		Lv1ReportResults_other lev = new Lv1ReportResults_other();

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
		List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList());
		HashMap<String, Integer> count = new HashMap<>();
		for (String s : list) {
			String target = s.split(" ")[1];
			count.put(target, count.getOrDefault(target, 0) + 1);
		}

		return Arrays.stream(id_list).map(_user -> {
			final String user = _user;
			List<String> reportList = list.stream().filter(s -> s.startsWith(user + " ")).collect(Collectors.toList());
			return reportList.stream().filter(s -> count.getOrDefault(s.split(" ")[1], 0) >= k).count();
		}).mapToInt(Long::intValue).toArray();
	}
}

/*
짧지만 효율 엄청 떨어짐. 하지만 stream 공부하기에는 좋을 거 같다!

테스트 1 〉	통과 (8.69ms, 73.1MB)
테스트 2 〉	통과 (9.17ms, 77.7MB)
테스트 3 〉	통과 (5646.36ms, 474MB)
테스트 4 〉	통과 (10.68ms, 77.3MB)
테스트 5 〉	통과 (10.13ms, 80.3MB)
테스트 6 〉	통과 (29.19ms, 88.9MB)
테스트 7 〉	통과 (26.04ms, 87.2MB)
테스트 8 〉	통과 (35.23ms, 102MB)
테스트 9 〉	통과 (1512.88ms, 419MB)
테스트 10 〉	통과 (1459.36ms, 419MB)
테스트 11 〉	통과 (6120.36ms, 506MB)
테스트 12 〉	통과 (20.97ms, 79.5MB)
테스트 13 〉	통과 (18.19ms, 88.1MB)
테스트 14 〉	통과 (1805.74ms, 415MB)
테스트 15 〉	통과 (2804.78ms, 459MB)
테스트 16 〉	통과 (13.91ms, 68.8MB)
테스트 17 〉	통과 (16.96ms, 86.5MB)
테스트 18 〉	통과 (21.86ms, 71.8MB)
테스트 19 〉	통과 (40.04ms, 83.4MB)
테스트 20 〉	통과 (1903.17ms, 414MB)
테스트 21 〉	통과 (2439.91ms, 532MB)
테스트 22 〉	통과 (9.05ms, 72.5MB)
테스트 23 〉	통과 (8.16ms, 78.4MB)
테스트 24 〉	통과 (7.55ms, 79.6MB)
 */