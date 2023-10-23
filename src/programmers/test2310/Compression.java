package programmers.test2310;

import java.util.*;

public class Compression {
	public static void main(String[] args) {
		Compression compression = new Compression();

		System.out.println(Arrays.toString(compression.solution("KAKAO")));
		// [11, 1, 27, 15]
		System.out.println(Arrays.toString(compression.solution("TOBEORNOTTOBEORTOBEORNOT")));
		// [20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34]
		System.out.println(Arrays.toString(compression.solution("ABABABABABABABAB")));
		// [1, 2, 27, 29, 28, 31, 30]
	}

	public int[] solution(String msg) {
		Map<String, Integer> dictionary = new HashMap<>();
		for (int i = 0; i < 26; i++) {
			dictionary.put(Character.toString((char) ('A' + i)), i + 1);
		}

		int index = 27;
		StringBuilder sb = new StringBuilder(msg);
		List<Integer> answerList = new ArrayList<>();

		loop1:
		while (sb.length() != 0) {
			int i = 1;
			while (dictionary.containsKey(sb.substring(0, i))) {
				i++;
				if (i > sb.length()) {
					answerList.add(dictionary.get(sb.toString()));
					break loop1;
				}
			}
			answerList.add(dictionary.get(sb.substring(0, i - 1)));
			dictionary.put(sb.substring(0, i), index);
			index++;
			sb.delete(0, i - 1);
		}

		int[] answer = new int[answerList.size()];
		for (int i = 0; i < answerList.size(); i++) {
			answer[i] = answerList.get(i);
		}

		return answer;
	}
}
