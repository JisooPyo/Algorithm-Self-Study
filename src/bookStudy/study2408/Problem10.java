package bookStudy.study2408;

import java.util.Stack;

/**
 * 프로그래머스 lv.2
 * 10. 괄호 회전하기
 */
public class Problem10 {
    public static void main(String[] args) {
        Problem10 p = new Problem10();
        System.out.println(p.solution("[](){}"));   // 3
        System.out.println(p.solution("}]()[{"));   // 2
        System.out.println(p.solution("[)(]"));     // 0
        System.out.println(p.solution("}}}"));      // 0
    }

    StringBuilder sb;
    int n;

    public int solution(String s) {
        this.sb = new StringBuilder(s);
        this.n = s.length();

        for (int i = 0; i < n - 1; i++) {
            sb.append(s.charAt(i));
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (isRightString(i)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isRightString(int index) {
        Stack<Character> stack = new Stack<>();
        for (int i = index; i < index + n; i++) {
            char ch = sb.charAt(i);
            if (stack.isEmpty()) {
                stack.push(ch);
                continue;
            }
            switch (ch) {
                case '[':
                case '(':
                case '{':
                    stack.push(ch);
                    break;
                case ']':
                    if (stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case ')':
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.peek() == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
            }
        }
        return stack.isEmpty();
    }
}
/*
테스트 1 〉	통과 (11.74ms, 79.7MB)
테스트 2 〉	통과 (8.57ms, 88.5MB)
테스트 3 〉	통과 (8.38ms, 79.8MB)
테스트 4 〉	통과 (27.17ms, 88.1MB)
테스트 5 〉	통과 (29.54ms, 88.9MB)
테스트 6 〉	통과 (13.12ms, 74.4MB)
테스트 7 〉	통과 (19.30ms, 79.7MB)
테스트 8 〉	통과 (24.87ms, 88.3MB)
테스트 9 〉	통과 (51.71ms, 92MB)
테스트 10 〉	통과 (61.43ms, 91.1MB)
테스트 11 〉	통과 (59.43ms, 90MB)
테스트 12 〉	통과 (0.18ms, 76.2MB)
테스트 13 〉	통과 (0.20ms, 77.2MB)
테스트 14 〉	통과 (0.19ms, 74.6MB)
 */
