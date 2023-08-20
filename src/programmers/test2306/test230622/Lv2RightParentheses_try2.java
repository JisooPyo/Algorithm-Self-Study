// lv2. 올바른 괄호
package programmers.test2306.test230622;

import java.util.Stack;

public class Lv2RightParentheses_try2 {
	public static void main(String[] args) {
		Lv2RightParentheses_try2 lv = new Lv2RightParentheses_try2();

		System.out.println(lv.solution("()()"));
		System.out.println(lv.solution("(())()"));
		System.out.println(lv.solution(")()("));
		System.out.println(lv.solution("(()("));

	}

	boolean solution(String s) {
		Stack<Character> strStack = new Stack<>();
		char[] chars = s.toCharArray();

		for (int i = 0; i < chars.length; i++) {
			if (strStack.size() > 0 && strStack.peek().equals('(') && chars[i] == ')') {
				strStack.pop();
			} else {
				strStack.push(chars[i]);
			}
		}

		return strStack.size() == 0 ? true : false;
	}

}

/*
정확성  테스트
테스트 1 〉통과 (0.26ms, 73MB)
테스트 2 〉통과 (0.23ms, 87.9MB)
테스트 3 〉통과 (0.26ms, 76.8MB)
테스트 4 〉통과 (0.25ms, 82.6MB)
테스트 5 〉통과 (0.29ms, 78.7MB)
테스트 6 〉통과 (0.18ms, 78.7MB)
테스트 7 〉통과 (0.18ms, 78.1MB)
테스트 8 〉통과 (0.19ms, 75MB)
테스트 9 〉통과 (0.28ms, 74.1MB)
테스트 10 〉통과 (0.24ms, 77.5MB)
테스트 11 〉통과 (0.23ms, 71MB)
테스트 12 〉통과 (0.28ms, 77MB)
테스트 13 〉통과 (0.31ms, 71.8MB)
테스트 14 〉통과 (0.39ms, 76.4MB)
테스트 15 〉통과 (0.39ms, 72.6MB)
테스트 16 〉통과 (0.38ms, 73.7MB)
테스트 17 〉통과 (0.39ms, 69.7MB)
테스트 18 〉통과 (0.39ms, 75.8MB)

효율성  테스트
테스트 1 〉	통과 (25.74ms, 53.3MB)
테스트 2 〉	실패 (시간 초과)
 */