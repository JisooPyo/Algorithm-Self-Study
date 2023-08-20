package programmers.test2307.test0703;

import java.util.Stack;

public class Budget {
	// 배열이 정해져 있을 때, 배열의 원소들로 구할 수 있는 값의 경우의 수(가장 많은 종류로 구성) 구하기
	// ex. {1, 2, 3, 4, 5}, 6 -> 6 = 1 + 2 + 3
	public static void main(String[] args) {
		Budget budget = new Budget();
		int[] t1 = {1, 2, 3, 4, 5};

		System.out.println(budget.solution(t1, 1)); // 1
		System.out.println(budget.solution(t1, 2)); // 2
		System.out.println(budget.solution(t1, 3)); // 12
		System.out.println(budget.solution(t1, 4)); // 13
		System.out.println(budget.solution(t1, 5)); // 14
		System.out.println(budget.solution(t1, 6)); // 123
		System.out.println(budget.solution(t1, 7)); // 124
		System.out.println(budget.solution(t1, 8)); // 125
		System.out.println(budget.solution(t1, 9)); // 135
		System.out.println(budget.solution(t1, 10)); // 1234
		System.out.println(budget.solution(t1, 11)); // 1235
		System.out.println(budget.solution(t1, 12)); // 1245
		System.out.println(budget.solution(t1, 13)); // 1345
		System.out.println(budget.solution(t1, 14)); // 2345
		System.out.println(budget.solution(t1, 15)); // 12345
	}

	public Stack<Integer> solution(int[] d, int budget) {
		Stack<Integer> stack = new Stack<>();
		int sum = 0;
		int index = 0;
		while (sum != budget) {
			if (sum > budget || index == d.length) {
				sum -= d[stack.peek()];
				stack.pop();
				index = stack.peek() + 1;
				sum -= d[stack.peek()];
				stack.pop();
			}
			stack.push(index);
			sum += d[index];
			index++;
		}
		return stack;
	}
}
