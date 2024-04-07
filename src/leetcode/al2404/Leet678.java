package leetcode.al2404;

import java.util.Stack;

public class Leet678 {
    public static void main(String[] args) {
        Leet678 l = new Leet678();
        System.out.println(l.checkValidString("()"));
        System.out.println(l.checkValidString("(*)"));
        System.out.println(l.checkValidString("(*))"));
    }

    // 내 풀이
    public boolean checkValidString(String s) {
        // 1. 유효한 괄호 찾기
        // index, char
        Stack<int[]> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != '(' && ch != ')') {
                continue;
            }
            if (!stack.isEmpty() && ch == ')' && stack.peek()[1] == '(') {
                chars[stack.peek()[0]] = 'x';
                chars[i] = 'x';
                stack.pop();
            } else {
                stack.add(new int[]{i, ch});
            }
        }

        // 2. 유효한 괄호 삭제하기
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != 'x') {
                sb.append(chars[i]);
            }
        }

        if (sb.isEmpty()) {
            return true;
        }

        // 3. * validation
        Stack<Character> stack2 = new Stack<>();
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (stack2.isEmpty()) {
                stack2.add(ch);
                continue;
            }
            char peek = stack2.peek();
            if (ch == '*') {
                if (peek == '(') {
                    stack2.pop();
                } else {
                    stack2.add(ch);
                }
            } else if (ch == '(') {
                stack2.add(ch);
            } else {
                if (peek == '(' || peek == '*') {
                    stack2.pop();
                } else {
                    stack2.add(ch);
                }
            }
        }

        if (stack2.isEmpty()) {
            return true;
        }

        StringBuilder sb2 = new StringBuilder();
        while (!stack2.isEmpty()) {
            sb2.append(stack2.pop());
        }

        return sb2.toString().matches("^\\*+$");
    }

    // 다른 사람의 풀이
    // omin: '*'를 ')'로 대체했을 때
    // omax: '*'를 '('로 대체했을 때
    public boolean checkValidStringOther(String s) {
        int omin = 0;
        int omax = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                omax++;
                omin++;
            } else if (s.charAt(i) == ')') {
                omax--;
                omin--;
            } else {
                omax++;
                omin--;
            }
            // '*'개수 + '('개수 < ')'개수 => false
            if (omax < 0) {
                return false;
            }
            // omin은 음수가 될 수 없음.
            omin = Math.max(0, omin);
        }
        return omin == 0;
    }
}
