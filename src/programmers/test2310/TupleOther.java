package programmers.test2310;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TupleOther {
	public static void main(String[] args) {
		TupleOther tuple = new TupleOther();
		String s1 = "{{2},{2,1},{2,1,3},{2,1,3,4}}";    // [2, 1, 3, 4]
		String s2 = "{{1,2,3},{2,1},{1,2,4,3},{2}}";    // [2, 1, 3, 4]
		String s3 = "{{20,111},{111}}";                 // [111, 20]
		String s4 = "{{123}}";                         // [123]
		String s5 = "{{4,2,3},{3},{2,3,4,1},{2,3}}";    // [3, 2, 4, 1]

//		System.out.println(Arrays.toString(tuple.solution(s1)));
		System.out.println(Arrays.toString(tuple.solution(s2)));
//		System.out.println(Arrays.toString(tuple.solution(s3)));
//		System.out.println(Arrays.toString(tuple.solution(s4)));
//		System.out.println(Arrays.toString(tuple.solution(s5)));
	}

	public int[] solution(String s) {
		Set<String> set = new HashSet<>();
		// 특수문자를 공백으로 바꿔서 trim을 이용해 잘라주었음.
		String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");

		System.out.println(Arrays.toString(arr));

		Arrays.sort(arr, (a, b) -> {
			return a.length() - b.length();
		});


		int[] answer = new int[arr.length];
		int idx = 0;
		for (String s1 : arr) {
			for (String s2 : s1.split(",")) {
				// add 메서드를 이용해서 set에 넣으면서 넣을 수 있는지 판단할 수 있었음.
				if (set.add(s2)) answer[idx++] = Integer.parseInt(s2);
			}
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