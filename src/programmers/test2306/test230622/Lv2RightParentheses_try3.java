// lv2. 올바른 괄호
package programmers.test2306.test230622;

import java.util.Stack;

public class Lv2RightParentheses_try3 {
	public static void main(String[] args) {
		Lv2RightParentheses_try3 lv = new Lv2RightParentheses_try3();

		System.out.println(lv.solution("()()"));
		System.out.println(lv.solution("(())()"));
		System.out.println(lv.solution(")()("));
		System.out.println(lv.solution("(()("));

	}

	boolean solution(String s) {
		Stack<Character> strStack = new Stack<>();
		char[] chars = s.toCharArray();

		for (int i = 0; i < chars.length; i++) {
			if (strStack.size() == 0) {
				strStack.push(chars[i]);
				continue;
			}
			if (strStack.peek().equals('(') && chars[i] == ')') {
				strStack.pop();
			} else {
				strStack.push(chars[i]);
			}
		}

		return strStack.size() == 0 ? true : false;
	}

}

/*
정확성 테스트
테스트 1 〉통과 (0.23ms, 74.6MB)
테스트 2 〉통과 (0.21ms, 77.3MB)
테스트 3 〉통과 (0.19ms, 79.9MB)
테스트 4 〉통과 (0.17ms, 73.4MB)
테스트 5 〉통과 (0.26ms, 72.9MB)
테스트 6 〉통과 (0.28ms, 78.8MB)
테스트 7 〉통과 (0.19ms, 76.8MB)
테스트 8 〉통과 (0.19ms, 72.5MB)
테스트 9 〉통과 (0.25ms, 72.3MB)
테스트 10 〉통과 (0.26ms, 73.2MB)
테스트 11 〉통과 (0.28ms, 78MB)
테스트 12 〉통과 (0.36ms, 71.8MB)
테스트 13 〉통과 (0.27ms, 72.5MB)
테스트 14 〉통과 (0.31ms, 75.7MB)
테스트 15 〉통과 (0.30ms, 70.2MB)
테스트 16 〉통과 (0.24ms, 72MB)
테스트 17 〉통과 (0.31ms, 74.4MB)
테스트 18 〉통과 (0.50ms, 74.3MB)

효율성  테스트
테스트 1 〉통과 (28.94ms, 52.7MB)
테스트 2 〉실패 (시간 초과)
 */