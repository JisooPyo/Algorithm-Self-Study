package programmers.test2310;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NewsClustering {
	public static void main(String[] args) {
		NewsClustering newsClustering = new NewsClustering();

		System.out.println(newsClustering.solution("FRANCE", "french"));    // 16384
		System.out.println(newsClustering.solution("handshake", "shake hands"));    // 65536
		System.out.println(newsClustering.solution("aa1+aa2", "AAAA12")); // 43690
		System.out.println(newsClustering.solution("E=M*C^2", "e=m*c^2")); // 65536
		System.out.println(newsClustering.solution("abab", "baba"));    // 32768
	}

	public int solution(String str1, String str2) {
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();

		List<String> str1List = new ArrayList<>();
		List<String> str2List = new ArrayList<>();

		for (int i = 0; i < str1.length() - 1; i++) {
			if (isComposeOfEnglish(str1, i)) {
				str1List.add(str1.substring(i, i + 2));
			}
		}
		for (int i = 0; i < str2.length() - 1; i++) {
			if (isComposeOfEnglish(str2, i)) {
				str2List.add(str2.substring(i, i + 2));
			}
		}
		if (str1List.size() == 0 && str2List.size() == 0) {
			return 65536;
		}

		Collections.sort(str1List);
		Collections.sort(str2List);

		int index = 0;
		int check = 0;
		for (int i = 0; i < str2List.size(); i++) {
			for (int j = index; j < str1List.size(); j++) {
				if (str1List.get(j).equals(str2List.get(i))) {
					check++;
					index = j + 1;
					break;
				}
			}
		}

		double jaccard = (double) check / (str1List.size() + str2List.size() - check);

		return (int) (jaccard * 65536);
	}

	private boolean isComposeOfEnglish(String str, int i) {
		char c = str.charAt(i);
		char d = str.charAt(i + 1);

		return 'a' <= c && c <= 'z' && 'a' <= d && d <= 'z';
	}
}

/**
 * 테스트 1 〉	통과 (0.25ms, 74.3MB)
 * 테스트 2 〉	통과 (0.32ms, 77.9MB)
 * 테스트 3 〉	통과 (0.35ms, 73.8MB)
 * 테스트 4 〉	통과 (3.76ms, 66.6MB)
 * 테스트 5 〉	통과 (0.32ms, 73.9MB)
 * 테스트 6 〉	통과 (0.23ms, 68.5MB)
 * 테스트 7 〉	통과 (0.84ms, 85.2MB)
 * 테스트 8 〉	통과 (0.29ms, 77.8MB)
 * 테스트 9 〉	통과 (0.80ms, 72.4MB)
 * 테스트 10 〉	통과 (1.33ms, 73MB)
 * 테스트 11 〉	통과 (1.80ms, 82.3MB)
 * 테스트 12 〉	통과 (0.04ms, 76.1MB)
 * 테스트 13 〉	통과 (0.54ms, 77.8MB)
 */