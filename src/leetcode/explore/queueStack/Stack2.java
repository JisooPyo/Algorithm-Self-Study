package leetcode.explore.queueStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Stack2 {
    public static void main(String[] args) {
        Stack2 s = new Stack2();
        System.out.println(s.isValid("()"));
        System.out.println(s.isValid("()[]{}"));
        System.out.println(s.isValid("(]"));
    }

    public boolean isValid(String s) {
        Map<Character, Character> pair = new HashMap<>();
        pair.put(')', '(');
        pair.put(']', '[');
        pair.put('}', '{');

        Stack<Character> check = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (check.size() == 0) {
                check.push(ch);
                continue;
            }
            if (pair.containsKey(ch) && check.peek() == pair.get(ch)) {
                check.pop();
                continue;
            }
            check.push(ch);
        }
        return check.size() == 0;
    }
}

// 'check.size() == 0' --> 'check.isEmpty()' 메서드 활용을 좀 더 넓게 해보자.