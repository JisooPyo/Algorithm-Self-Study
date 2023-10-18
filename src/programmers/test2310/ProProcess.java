package programmers.test2310;

import java.util.LinkedList;
import java.util.Queue;

public class ProProcess {
	public static void main(String[] args) {
		ProProcess pp = new ProProcess();

		int[] priorities1 = {2, 1, 3, 2};
		int[] priorities2 = {1, 1, 9, 1, 1, 1};

		System.out.println(pp.solution(priorities1, 2));        // 1
		System.out.println(pp.solution(priorities2, 0));        // 5

	}

	public int solution(int[] priorities, int location) {
		Queue<TestProcess> system = new LinkedList<>();
		for (int i = 0; i < priorities.length; i++) {
			TestProcess tp = new TestProcess(priorities[i], i);
			system.add(tp);
		}

		int answer = 0;

		loop1:
		while (system.size() > 0) {
			int peekPriority = system.peek().priority;
			int peekNumber = system.peek().number;

			if (existHigherPriorityProcess(system, peekPriority)) {
				system.poll();
				system.add(new TestProcess(peekPriority, peekNumber));
				continue loop1;
			}

			if (peekNumber == location) {
				break;
			}

			answer++;
			system.poll();
		}

		return answer + 1;
	}

	public boolean existHigherPriorityProcess(Queue<TestProcess> system, int priority) {
		for (TestProcess t : system) {
			if (t.priority > priority) {
				return true;
			}
		}
		return false;
	}

	class TestProcess {
		int priority;
		int number;

		public TestProcess(int priority, int number) {
			this.priority = priority;
			this.number = number;
		}
	}
}

/*
정확성  테스트
테스트 1 〉통과 (1.33ms, 81.8MB)
테스트 2 〉통과 (2.25ms, 78.8MB)
테스트 3 〉통과 (0.63ms, 70.7MB)
테스트 4 〉통과 (0.62ms, 75.3MB)
테스트 5 〉통과 (0.50ms, 72.4MB)
테스트 6 〉통과 (1.00ms, 73MB)
테스트 7 〉통과 (0.91ms, 90.2MB)
테스트 8 〉통과 (2.14ms, 78.5MB)
테스트 9 〉통과 (0.66ms, 73.7MB)
테스트 10 〉통과 (0.82ms, 72.7MB)
테스트 11 〉통과 (1.80ms, 73.3MB)
테스트 12 〉통과 (0.53ms, 88.8MB)
테스트 13 〉통과 (1.87ms, 78.5MB)
테스트 14 〉통과 (0.36ms, 79.4MB)
테스트 15 〉통과 (0.45ms, 77.7MB)
테스트 16 〉통과 (0.67ms, 70.2MB)
테스트 17 〉통과 (3.59ms, 81.9MB)
테스트 18 〉통과 (0.53ms, 77.3MB)
테스트 19 〉통과 (2.34ms, 74MB)
테스트 20 〉통과 (0.76ms, 72MB)
 */
