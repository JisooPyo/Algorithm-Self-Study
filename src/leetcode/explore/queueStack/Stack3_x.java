// Daily Temperatures
package leetcode.explore.queueStack;

import java.util.Arrays;
import java.util.Stack;

public class Stack3_x {
    public static void main(String[] args) {
        Stack3_x s = new Stack3_x();

        int[] temperatures1 = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] temperatures2 = {30, 40, 50, 60};
        int[] temperatures3 = {30, 60, 90};

        System.out.println(Arrays.toString(s.dailyTemperatures(temperatures1)));
        System.out.println(Arrays.toString(s.dailyTemperatures(temperatures2)));
        System.out.println(Arrays.toString(s.dailyTemperatures(temperatures3)));
    }

    // 다른 사람 풀이 - Stack 이용
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                ret[idx] = i - idx;
            }
            stack.push(i);
        }
        return ret;
    }

    // 다른 사람 풀이 - 배열 이용
    public int[] dailyTemperatures2(int[] temperatures) {
        int[] stack = new int[temperatures.length];
        int top = -1;
        int[] ret = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (top > -1 && temperatures[i] > temperatures[stack[top]]) {
                int idx = stack[top--];
                ret[idx] = i - idx;
            }
            stack[++top] = i;
        }
        return ret;
    }

    // solution1: Time Limit Exceeded
    // 시간복잡도: O(N^2)
    public int[] dailyTemperatures1(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        for (int i = 0; i < temperatures.length - 1; i++) {
            for (int j = i; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    answer[i] = j - i;
                    break;
                }
            }
        }
        return answer;
    }
}
