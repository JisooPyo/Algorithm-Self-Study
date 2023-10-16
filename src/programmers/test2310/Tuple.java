package programmers.test2310;

import java.util.*;

public class Tuple {
	public static void main(String[] args) {
		Tuple tuple = new Tuple();
		String s1 = "{{2},{2,1},{2,1,3},{2,1,3,4}}";    // [2, 1, 3, 4]
		String s2 = "{{1,2,3},{2,1},{1,2,4,3},{2}}";    // [2, 1, 3, 4]
		String s3 = "{{20,111},{111}}";                  // [111, 20]
		String s4 = "{{123}}";                           // [123]
		String s5 = "{{4,2,3},{3},{2,3,4,1},{2,3}}";    // [3, 2, 4, 1]

		System.out.println(Arrays.toString(tuple.solution(s1)));
		System.out.println(Arrays.toString(tuple.solution(s2)));
		System.out.println(Arrays.toString(tuple.solution(s3)));
		System.out.println(Arrays.toString(tuple.solution(s4)));
		System.out.println(Arrays.toString(tuple.solution(s5)));
	}

	public int[] solution(String s) {
		s = s.substring(1, s.length() - 1);
		// 집합을 리스트의 형태로 저장
		List<Set<String>> tupleList = new ArrayList<>();

		String[] split = s.split("\\{");
		for (int i = 0; i < split.length; i++) {
			StringBuilder sb = new StringBuilder(split[i]);
			Set<String> set = new HashSet<>();
			if (sb.length() != 0) {
				if (sb.charAt(sb.length() - 1) == ',') {
					sb.deleteCharAt(sb.length() - 1);
				}
				if (sb.charAt(sb.length() - 1) == '}') {
					sb.deleteCharAt(sb.length() - 1);
				}
				String[] split2 = sb.toString().split(",");
				for (int j = 0; j < split2.length; j++) {
					set.add(split2[j]);
				}
				tupleList.add(set);
			}
		}

		// 리스트 set size대로 정렬
		Collections.sort(tupleList, (a, b) -> a.size() - b.size());

		// arr에 넣을 string을 그 다음 set들에서 지워놓는다.
		int[] answer = new int[tupleList.size()];
		for (int i = 0; i < tupleList.size(); i++) {
			String string = "";
			for (String str : tupleList.get(i)) {
				string = str;
			}
			for (int j = i + 1; j < tupleList.size(); j++) {
				tupleList.get(j).remove(string);
			}
			answer[i] = Integer.parseInt(string);
		}

		return answer;
	}

}

/*
테스트 1 〉통과 (0.93ms, 77.4MB)
테스트 2 〉통과 (0.60ms, 81.1MB)
테스트 3 〉통과 (0.55ms, 74MB)
테스트 4 〉통과 (0.82ms, 75.3MB)
테스트 5 〉통과 (1.55ms, 85.8MB)
테스트 6 〉통과 (2.54ms, 74.7MB)
테스트 7 〉통과 (15.99ms, 92.5MB)
테스트 8 〉통과 (34.12ms, 93MB)
테스트 9 〉통과 (19.40ms, 76.1MB)
테스트 10 〉통과 (39.85ms, 86.6MB)
테스트 11 〉통과 (51.99ms, 94.3MB)
테스트 12 〉통과 (76.68ms, 106MB)
테스트 13 〉통과 (78.67ms, 117MB)
테스트 14 〉통과 (76.72ms, 121MB)
테스트 15 〉통과 (0.55ms, 71.4MB)
 */