package bookStudy.study2408;

import java.util.Stack;

/**
 * 프로그래머스 lv.2
 * 11. 짝지어 제거하기
 */
public class Problem11 {
    public static void main(String[] args) {
        Problem11 p = new Problem11();
        System.out.println(p.solution("baabaa"));   // 1
        System.out.println(p.solution("cdcd"));     // 0
    }

    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(ch);
                continue;
            }
            if (stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
/*
정확성  테스트
테스트 1 〉	통과 (0.19ms, 83.7MB)
테스트 2 〉	통과 (12.74ms, 80.4MB)
테스트 3 〉	통과 (22.09ms, 79.1MB)
테스트 4 〉	통과 (20.17ms, 82.6MB)
테스트 5 〉	통과 (17.34ms, 80.4MB)
테스트 6 〉	통과 (15.46ms, 95.4MB)
테스트 7 〉	통과 (15.33ms, 80.7MB)
테스트 8 〉	통과 (17.91ms, 85.6MB)
테스트 9 〉	통과 (0.26ms, 76.5MB)
테스트 10 〉	통과 (0.27ms, 72.9MB)
테스트 11 〉	통과 (0.17ms, 74.7MB)
테스트 12 〉	통과 (0.18ms, 74.8MB)
테스트 13 〉	통과 (0.28ms, 77.8MB)
테스트 14 〉	통과 (0.18ms, 73MB)
테스트 15 〉	통과 (0.25ms, 71.3MB)
테스트 16 〉	통과 (0.18ms, 73.6MB)
테스트 17 〉	통과 (0.22ms, 77.9MB)
테스트 18 〉	통과 (0.17ms, 72.6MB)

효율성  테스트
테스트 1 〉	통과 (58.76ms, 61.3MB)
테스트 2 〉	통과 (74.45ms, 74MB)
테스트 3 〉	통과 (46.23ms, 58.9MB)
테스트 4 〉	통과 (45.44ms, 58.9MB)
테스트 5 〉	통과 (47.34ms, 59MB)
테스트 6 〉	통과 (46.77ms, 58.8MB)
테스트 7 〉	통과 (45.55ms, 58.5MB)
테스트 8 〉	통과 (46.14ms, 58.4MB)
 */
