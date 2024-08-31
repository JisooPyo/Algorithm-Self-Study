package bookStudy.study2408;

import java.util.Stack;

/**
 * 프로그래머스 lv.2
 * 8. 올바른 괄호
 */
public class Problem8 {
    public static void main(String[] args) {
        Problem8 p = new Problem8();
        System.out.println(p.solution("()()"));     // true
        System.out.println(p.solution("(())()"));   // true
        System.out.println(p.solution(")()("));     // false
        System.out.println(p.solution("(()("));     // false
    }

    // 시간복잡도
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(stack.isEmpty() || ch == '('){
                stack.push(ch);
                continue;
            }
            if(ch==')'){
                if(stack.peek()=='('){
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }

        return stack.isEmpty();
    }
}
/*
정확성  테스트
테스트 1 〉	통과 (0.19ms, 73.1MB)
테스트 2 〉	통과 (0.23ms, 77.1MB)
테스트 3 〉	통과 (0.24ms, 78.7MB)
테스트 4 〉	통과 (0.19ms, 76.7MB)
테스트 5 〉	통과 (0.28ms, 74.1MB)
테스트 6 〉	통과 (0.18ms, 74MB)
테스트 7 〉	통과 (0.17ms, 73.9MB)
테스트 8 〉	통과 (0.20ms, 84.7MB)
테스트 9 〉	통과 (0.26ms, 88.2MB)
테스트 10 〉	통과 (0.27ms, 75.3MB)
테스트 11 〉	통과 (0.18ms, 78.8MB)
테스트 12 〉	통과 (0.24ms, 75.8MB)
테스트 13 〉	통과 (0.35ms, 73.2MB)
테스트 14 〉	통과 (0.26ms, 72.8MB)
테스트 15 〉	통과 (0.25ms, 76.7MB)
테스트 16 〉	통과 (0.38ms, 75.4MB)
테스트 17 〉	통과 (0.24ms, 77.9MB)
테스트 18 〉	통과 (0.24ms, 71.8MB)
효율성  테스트
테스트 1 〉	통과 (22.78ms, 53MB)
테스트 2 〉	통과 (23.33ms, 53.6MB)
 */
