// 짝지어 제거하기
package programmers.test2309;

import java.util.Stack;

public class RemovingInPairs {
	public static void main(String[] args) {
		RemovingInPairs rip = new RemovingInPairs();
		System.out.println(rip.solution("iifedcbaabcdefgghh"));
		System.out.println(rip.solution("cdcd"));
		System.out.println(rip.solution("baabaa"));
	}

	// 문자열의 길이 최대 1,000,000
	public int solution(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if ((stack.size() > 0) && (stack.peek().equals(s.charAt(i)))) {
				stack.pop();
			} else {
				stack.add(s.charAt(i));
			}
		}
		return stack.size() > 0 ? 0 : 1;
	}
}

/*

정확성  테스트

테스트 1 〉통과 (0.28ms, 78.3MB)
테스트 2 〉통과 (20.09ms, 74.7MB)
테스트 3 〉통과 (19.80ms, 81.2MB)
테스트 4 〉통과 (13.76ms, 79.1MB)
테스트 5 〉통과 (16.16ms, 75.2MB)
테스트 6 〉통과 (20.11ms, 83.9MB)
테스트 7 〉통과 (30.35ms, 79.2MB)
테스트 8 〉통과 (17.46ms, 76.5MB)
테스트 9 〉통과 (0.27ms, 73.8MB)
테스트 10 〉통과 (0.32ms, 76.7MB)
테스트 11 〉통과 (0.17ms, 74.3MB)
테스트 12 〉통과 (0.20ms, 73.5MB)
테스트 13 〉통과 (0.33ms, 75.3MB)
테스트 14 〉통과 (0.19ms, 76.3MB)
테스트 15 〉통과 (0.19ms, 71.1MB)
테스트 16 〉통과 (0.31ms, 80.8MB)
테스트 17 〉통과 (0.27ms, 74.5MB)
테스트 18 〉통과 (0.20ms, 72.2MB)

효율성  테스트

테스트 1 〉통과 (68.67ms, 61.9MB)
테스트 2 〉통과 (40.98ms, 56MB)
테스트 3 〉통과 (49.66ms, 59MB)
테스트 4 〉통과 (52.74ms, 58.7MB)
테스트 5 〉통과 (50.33ms, 59.5MB)
테스트 6 〉통과 (49.46ms, 58.8MB)
테스트 7 〉통과 (50.93ms, 58.6MB)
테스트 8 〉통과 (49.91ms, 58.5MB)

 */