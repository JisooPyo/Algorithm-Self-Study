// lv2. 올바른 괄호
package programmers.test2306.test230622;

public class Lv2RightParentheses_other {
	public static void main(String[] args) {
		Lv2RightParentheses_other lv = new Lv2RightParentheses_other();

		System.out.println(lv.solution("()()"));
		System.out.println(lv.solution("(())()"));
		System.out.println(lv.solution(")()("));
		System.out.println(lv.solution("(()("));
	}

	boolean solution(String s) {
		boolean answer = false;
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				count++;
			}
			if (s.charAt(i) == ')') {
				count--;
			}
			if (count < 0) {
				break;
			}
		}
		if (count == 0) {
			answer = true;
		}

		return answer;
	}

}

/*
정확성  테스트
테스트 1 〉통과 (0.01ms, 72.6MB)
테스트 2 〉통과 (0.02ms, 75.3MB)
테스트 3 〉통과 (0.02ms, 71.4MB)
테스트 4 〉통과 (0.01ms, 74.2MB)
테스트 5 〉통과 (0.02ms, 77MB)
테스트 6 〉통과 (0.04ms, 74.4MB)
테스트 7 〉통과 (0.04ms, 75.4MB)
테스트 8 〉통과 (0.02ms, 74.4MB)
테스트 9 〉통과 (0.02ms, 74.9MB)
테스트 10 〉통과 (0.03ms, 78.5MB)
테스트 11 〉통과 (0.02ms, 77MB)
테스트 12 〉통과 (0.03ms, 75.1MB)
테스트 13 〉통과 (0.03ms, 78.4MB)
테스트 14 〉통과 (0.03ms, 75.3MB)
테스트 15 〉통과 (0.02ms, 66.5MB)
테스트 16 〉통과 (0.05ms, 78MB)
테스트 17 〉통과 (0.02ms, 77MB)
테스트 18 〉통과 (0.04ms, 66.9MB)

효율성  테스트
테스트 1 〉통과 (7.31ms, 52.4MB)
테스트 2 〉통과 (7.53ms, 52.6MB)
 */