package leetcode.al2404;

import java.util.Stack;

public class Leet1614 {
    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.add(ch);
            }
            if (ch == ')') {
                stack.pop();
            }
            size = Math.max(size, stack.size());
        }
        return size;
    }

    // 다른 사람의 풀이
    // 굳이 Stack을 쓰지 않더라도 int temp를 하나 정의해서
    // '(' => temp++
    // ')' => temp--
    // 를 통해서 최대 depth를 구할 수 있다.
}
