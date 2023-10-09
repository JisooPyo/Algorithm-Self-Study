package programmers.test2310;

public class RotateTheParentheses {
	public static void main(String[] args) {
		RotateTheParentheses rtp = new RotateTheParentheses();

		System.out.println(rtp.solution("[](){}"));
		System.out.println(rtp.solution("}]()[{"));
		System.out.println(rtp.solution("[)(]"));
		System.out.println(rtp.solution("}}}"));
	}

	public int solution(String s) {
		int answer = 0;
		StringBuilder sb = new StringBuilder();
		sb.append(s);
		sb.append(s);
		int startIndex = 0;
		int endIndex = s.length();
		for (int i = 0; i < s.length(); i++) {
			if (rightString(sb.substring(startIndex++, endIndex++))) {
				answer++;
			}
		}
		return answer;
	}

	// 올바른 괄호 문자열인지 확인하는 메서드
	public boolean rightString(String str) {
		String first = str;
		while (str.length() != 0) {
			str = str.replaceAll("\\[]", "");
			str = str.replaceAll("\\(\\)", "");
			str = str.replaceAll("\\{}", "");
			if (first.equals(str)) {
				break;
			}
			first = str;
		}
		return str.length() == 0;
	}
}

// 다른 사람의 풀이에서 stack으로 올바른 괄호 문자열인지 확인하는 풀이가 있었음.
// 가장 높은 시간 25ms.
// 괄호문제는 스택으로 풀 수 있는지 먼저 확인할 것.

/*
테스트 1 〉통과 (758.69ms, 386MB)
테스트 2 〉통과 (267.65ms, 148MB)
테스트 3 〉통과 (163.23ms, 126MB)
테스트 4 〉통과 (151.59ms, 125MB)
테스트 5 〉통과 (119.99ms, 110MB)
테스트 6 〉통과 (146.32ms, 151MB)
테스트 7 〉통과 (171.74ms, 137MB)
테스트 8 〉통과 (120.39ms, 130MB)
테스트 9 〉통과 (143.19ms, 111MB)
테스트 10 〉통과 (114.79ms, 118MB)
테스트 11 〉통과 (88.24ms, 108MB)
테스트 12 〉통과 (0.27ms, 76MB)
테스트 13 〉통과 (0.37ms, 72MB)
테스트 14 〉통과 (0.31ms, 72.5MB)
 */