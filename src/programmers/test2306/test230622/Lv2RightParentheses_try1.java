// lv2. 올바른 괄호
package programmers.test2306.test230622;

import java.util.Stack;

public class Lv2RightParentheses_try1 {
	public static void main(String[] args) {
		Lv2RightParentheses_try1 lv = new Lv2RightParentheses_try1();

		System.out.println(lv.solution("()()"));
		System.out.println(lv.solution("(())()"));
		System.out.println(lv.solution(")()("));
		System.out.println(lv.solution("(()("));

	}

	boolean solution(String s) {
		Stack<String> strStack = new Stack<>();
		String[] sp = s.split("");

		for (int i = 0; i < sp.length; i++) {
			if (strStack.size() > 0 && strStack.peek().equals("(") && sp[i].equals(")")) {
				strStack.pop();
			} else {
				strStack.push(sp[i]);
			}
		}

		return strStack.size() == 0 ? true : false;
	}

}

/*
정확성  테스트
테스트 1 〉통과 (0.17ms, 78MB)
테스트 2 〉통과 (0.18ms, 73.9MB)
테스트 3 〉통과 (0.26ms, 74.2MB)
테스트 4 〉통과 (0.19ms, 69.2MB)
테스트 5 〉통과 (0.30ms, 79.9MB)
테스트 6 〉통과 (0.18ms, 77.3MB)
테스트 7 〉통과 (0.22ms, 74.1MB)
테스트 8 〉통과 (0.20ms, 72.5MB)
테스트 9 〉통과 (0.24ms, 74.5MB)
테스트 10 〉통과 (0.20ms, 71.7MB)
테스트 11 〉통과 (0.22ms, 77.3MB)
테스트 12 〉통과 (0.50ms, 82.2MB)
테스트 13 〉통과 (0.43ms, 74.9MB)
테스트 14 〉통과 (0.45ms, 83.5MB)
테스트 15 〉통과 (0.44ms, 81.3MB)
테스트 16 〉통과 (0.44ms, 75.5MB)
테스트 17 〉통과 (0.43ms, 77MB)
테스트 18 〉통과 (0.42ms, 74.7MB)

효율성  테스트
테스트 1 〉	실패 (시간 초과)
테스트 2 〉	실패 (시간 초과)
 */