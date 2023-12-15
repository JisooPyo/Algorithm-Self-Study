// 뒤에 있는 큰 수 찾기
package programmers.test2312;

import java.util.Arrays;
import java.util.Stack;

public class TheLargerNumberBehind_v {
    public static void main(String[] args) {
        TheLargerNumberBehind_v t = new TheLargerNumberBehind_v();
        int[] numbers1 = {2, 3, 3, 5};
        int[] numbers2 = {9, 1, 5, 3, 6, 2};

        // [3, 5, 5, -1]
        System.out.println(Arrays.toString(t.solution(numbers1)));
        // [-1, 5, 6, 6, -1, -1]
        System.out.println(Arrays.toString(t.solution(numbers2)));
    }

    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        stack.add(numbers[numbers.length - 1]);
        answer[answer.length - 1] = -1;
        for (int i = numbers.length - 2; i >= 0; i--) {
            while (stack.size() > 0) {
                if (stack.peek() > numbers[i]) {
                    answer[i] = stack.peek();
                    break;
                }
                stack.pop();
                if (stack.size() == 0) {
                    answer[i] = -1;
                }
            }
            stack.push(numbers[i]);
        }
        return answer;
    }

    public int[] solution2(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        Stack<Integer> s = new Stack<>();
        s.push(0);
        for (int i = 1; i < numbers.length; i++) {
            while (!s.isEmpty()) {
                int idx = s.pop();
                if (numbers[i] > numbers[idx]) { // 뒤가 더 클때
                    answer[idx] = numbers[i];
                } else { // 앞이 더 크거나 같을 때
                    s.push(idx);
                    break;
                }
            }
            s.push(i);
        }

        return answer;
    }
}
