package leetcode.explore.queueStack;

import java.util.Stack;

public class Stack4 {
    public static void main(String[] args) {
        Stack4 s = new Stack4();
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        String[] tokens2 = {"4", "13", "5", "/", "+"};
        String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(s.evalRPN(tokens1));
        System.out.println(s.evalRPN(tokens2));
        System.out.println(s.evalRPN(tokens3));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for (int i = 0; i < tokens.length; i++) {
            if (!isOperator(tokens[i])) {
                stack.push(Integer.parseInt(tokens[i]));
                continue;
            }
            switch (tokens[i]) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int after = stack.pop();
                    int before = stack.pop();
                    stack.push(before - after);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int after2 = stack.pop();
                    int before2 = stack.pop();
                    stack.push(before2 / after2);
                    break;
            }
        }
        return stack.peek();
    }

    private boolean isOperator(String token) {
        if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
            return true;
        }
        return false;
    }
}
