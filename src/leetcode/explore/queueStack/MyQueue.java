package leetcode.explore.queueStack;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> stack;

    public MyQueue() {
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.add(x);
    }

    public int pop() {
        Stack<Integer> temp = new Stack<>();
        while (!stack.empty()) {
            temp.add(stack.pop());
        }
        int answer = temp.peek();
        temp.pop();
        while (!temp.empty()) {
            stack.add(temp.pop());
        }
        return answer;
    }

    public int peek() {
        Stack<Integer> temp = new Stack<>();
        while (!stack.empty()) {
            temp.add(stack.pop());
        }
        int answer = temp.peek();
        while (!temp.empty()) {
            stack.add(temp.pop());
        }
        return answer;
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}
