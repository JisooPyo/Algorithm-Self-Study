// lv2. 올바른 괄호
package programmers.test2306.test230622;

import java.util.Stack;

public class Lv2RightParentheses_try5_pass {
	public static void main(String[] args) {
		Lv2RightParentheses_try5_pass lv = new Lv2RightParentheses_try5_pass();

		System.out.println(lv.solution("()()"));
		System.out.println(lv.solution("(())()"));
		System.out.println(lv.solution(")()("));
		System.out.println(lv.solution("(()("));

	}

	boolean solution(String s) {
		Stack<Character> strStack = new Stack<>();
		char[] chars = s.toCharArray();
		if (chars[chars.length - 1] != ')') {
			return false;
		}

		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '(') {
				strStack.push(chars[i]);
			} else {
				if (strStack.size() == 0) {
					return false;
				}
				if (strStack.peek() == '(') {
					strStack.pop();
				}
			}
		}

		return strStack.size() == 0 ? true : false;
	}

}

/*
정확성  테스트
테스트 1 〉통과 (0.10ms, 65.7MB)
테스트 2 〉통과 (0.14ms, 73.9MB)
테스트 3 〉통과 (0.10ms, 70.6MB)
테스트 4 〉통과 (0.11ms, 74.6MB)
테스트 5 〉통과 (0.17ms, 75.6MB)
테스트 6 〉통과 (0.17ms, 75.5MB)
테스트 7 〉통과 (0.21ms, 78.4MB)
테스트 8 〉통과 (0.21ms, 78.1MB)
테스트 9 〉통과 (0.25ms, 88.8MB)
테스트 10 〉통과 (0.26ms, 79.6MB)
테스트 11 〉통과 (0.19ms, 75.2MB)
테스트 12 〉통과 (0.23ms, 72.9MB)
테스트 13 〉통과 (0.23ms, 77MB)
테스트 14 〉통과 (0.29ms, 76.7MB)
테스트 15 〉통과 (0.27ms, 83.1MB)
테스트 16 〉통과 (0.25ms, 68MB)
테스트 17 〉통과 (0.25ms, 76.7MB)
테스트 18 〉통과 (0.10ms, 76.4MB)

효율성  테스트
테스트 1 〉통과 (22.70ms, 70.5MB)
테스트 2 〉통과 (21.19ms, 52.5MB)
 */