package leetcode.explore.queueStack;

import java.util.Stack;

public class Conclusion1 {
    public static void main(String[] args) {
        Conclusion1 c = new Conclusion1();
        // "aaabcbc"
        System.out.println(c.decodeString("3[a]2[bc]"));
        // "accaccacc"
        System.out.println(c.decodeString("3[a2[c]]"));
        // "abcabccdcdcdef"
        System.out.println(c.decodeString("2[abc]3[cd]ef"));
    }

    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch != ']') {
                stack.add(ch);
                continue;
            }
            decodeStack(stack);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }

    private void decodeStack(Stack<Character> stack) {
        StringBuilder sb = new StringBuilder();
        StringBuilder count = new StringBuilder();
        while (stack.peek() != '[') {
            sb.insert(0, stack.pop());
        }
        // 여는 대괄호 날리기
        stack.pop();
        // 숫자 카운트
        while (!stack.isEmpty() && '0' <= stack.peek() && stack.peek() <= '9') {
            count.insert(0, stack.pop());
        }
        // 디코딩해서 다시 스택에 넣기
        String decoded = sb.toString().repeat(Integer.parseInt(count.toString()));
        for (char ch : decoded.toCharArray()) {
            stack.push(ch);
        }
    }
}
