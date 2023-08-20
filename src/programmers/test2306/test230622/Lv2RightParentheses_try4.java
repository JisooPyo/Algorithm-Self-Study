// lv2. 올바른 괄호
package programmers.test2306.test230622;

import java.util.Stack;

public class Lv2RightParentheses_try4 {
	public static void main(String[] args) {
		Lv2RightParentheses_try4 lv = new Lv2RightParentheses_try4();

		System.out.println(lv.solution("()()"));
		System.out.println(lv.solution("(())()"));
		System.out.println(lv.solution(")()("));
		System.out.println(lv.solution("(()("));

	}

	boolean solution(String s) {
		Stack<Character> strStack = new Stack<>();
		char[] chars = s.toCharArray();
		if (chars[0] != '(' || chars[chars.length - 1] != ')') {
			return false;
		}

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
테스트 1 〉통과 (0.15ms, 74MB)
테스트 2 〉통과 (0.13ms, 75.4MB)
테스트 3 〉통과 (0.18ms, 81.9MB)
테스트 4 〉통과 (0.10ms, 76MB)
테스트 5 〉통과 (0.19ms, 73.3MB)
테스트 6 〉통과 (0.12ms, 71.4MB)
테스트 7 〉통과 (0.28ms, 77.8MB)
테스트 8 〉통과 (0.19ms, 83.6MB)
테스트 9 〉통과 (0.28ms, 64.9MB)
테스트 10 〉통과 (0.26ms, 71.8MB)
테스트 11 〉통과 (0.18ms, 76.5MB)
테스트 12 〉통과 (0.37ms, 76.9MB)
테스트 13 〉통과 (0.38ms, 67.6MB)
테스트 14 〉통과 (0.30ms, 73.7MB)
테스트 15 〉통과 (0.42ms, 76.4MB)
테스트 16 〉통과 (0.25ms, 72.8MB)
테스트 17 〉통과 (0.27ms, 77.1MB)
테스트 18 〉통과 (0.11ms, 74.3MB)
효율성  테스트
테스트 1 〉통과 (25.18ms, 53.1MB)
테스트 2 〉실패 (시간 초과)
 */