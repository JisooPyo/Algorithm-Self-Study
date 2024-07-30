package leetcode.al2407;

import java.util.Stack;

/**
 * Easy
 * 1021. Remove Outermost Parentheses
 * 유효한 괄호 문자열은 빈 문자열 "", "(" + A + ")", 또는 A + B 입니다.
 * 여기서 A와 B는 유효한 괄호 문자열이고, +는 문자열 연결을 나타냅니다.
 *
 * 예를 들어, "", "()", "(())()", "(()(()))"는 모두 유효한 괄호 문자열입니다.
 *
 * 유효한 괄호 문자열 s가 원시적(primitive)이라면, 그것은 비어 있지 않으며,
 * s = A + B로 A와 B가 비어 있지 않은 유효한 괄호 문자열로 나눌 수 있는 방법이 존재하지 않습니다.
 * * 유효한 괄호 문자열 s가 주어지면, 그 원시적 분해를 고려합니다:
 * s = P1 + P2 + ... + Pk, 여기서 Pi는 원시적 유효한 괄호 문자열입니다.
 *
 * s의 원시적 분해의 각 원시 문자열의 가장 바깥쪽 괄호를 제거한 후 s를 반환하세요.
 */
public class Leet1021 {
    public static void main(String[] args) {
        Leet1021 l = new Leet1021();
        System.out.println(l.removeOuterParentheses("(()())(())"));          // "()()()"
        System.out.println(l.removeOuterParentheses("(()())(())(()(()))")); // "()()()()(())"
    }

    // 내 풀이: 14ms
    // 자료구조 Stack 이용한 풀이
    public String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(ch);
                temp.append(ch);
                continue;
            }
            if (stack.peek() == '(' && ch == ')') {
                temp.append(ch);
                stack.pop();
            } else {
                temp.append(ch);
                stack.push(ch);
            }
            if (stack.isEmpty()) {
                temp.deleteCharAt(temp.length() - 1);
                temp.deleteCharAt(0);
                sb.append(temp);
                temp = new StringBuilder();
            }
        }
        return sb.toString();
    }
}
