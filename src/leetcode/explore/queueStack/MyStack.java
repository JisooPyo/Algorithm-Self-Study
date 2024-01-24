package leetcode.explore.queueStack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue1.add(x);
    }

    public int pop() {
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }
        int answer = queue1.poll();
        while (!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }
        return answer;
    }

    // push와 pop시 top이 바뀌기 때문에 top에 대해서 반환할 값을 전역변수로 설정하여
    // push와 pop시 전역변수를 그때그때 저장해놓고 top을 호출할시 반환하는 방법이 있다.
    public int top() {
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }
        int answer = queue1.peek();
        queue2.add(queue1.poll());
        while (!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }
        return answer;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
