package programmers.test2306.test230621;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SkillTest1Problem2 {
	public static void main(String[] args) {
		SkillTest1Problem2 s = new SkillTest1Problem2();

		int[] t1 = {1, 2, 3, 4, 5};
		int[] t2 = {1, 3, 2, 4, 2};

		System.out.println(Arrays.toString(s.solution(t1)));
		System.out.println(Arrays.toString(s.solution(t2)));
	}

	public int[] solution(int[] answers) {
		int[] count = new int[3];
		// 1번 수포자가 맞춘 문제의 수 구하기
		for (int i = 0; i < answers.length; i++) {
			switch (i % 5) {
				case 0:
					count[0] += answers[i] == 1 ? 1 : 0;
					break;
				case 1:
					count[0] += answers[i] == 2 ? 1 : 0;
					break;
				case 2:
					count[0] += answers[i] == 3 ? 1 : 0;
					break;
				case 3:
					count[0] += answers[i] == 4 ? 1 : 0;
					break;
				case 4:
					count[0] += answers[i] == 5 ? 1 : 0;
					break;
			}
		}

		// 2번 수포자가 맞춘 문제의 수 구하기
		for (int i = 0; i < answers.length; i++) {
			switch (i % 8) {
				case 0:
				case 2:
				case 4:
				case 6:
					count[1] += answers[i] == 2 ? 1 : 0;
					break;
				case 1:
					count[1] += answers[i] == 1 ? 1 : 0;
					break;
				case 3:
					count[1] += answers[i] == 3 ? 1 : 0;
					break;
				case 5:
					count[1] += answers[i] == 4 ? 1 : 0;
					break;
				case 7:
					count[1] += answers[i] == 5 ? 1 : 0;
					break;
			}

		}

		// 3번 수포자가 맞춘 문제의 수 구하기
		for (int i = 0; i < answers.length; i++) {
			switch (i % 10) {
				case 0:
				case 1:
					count[2] += answers[i] == 3 ? 1 : 0;
					break;
				case 2:
				case 3:
					count[2] += answers[i] == 1 ? 1 : 0;
					break;
				case 4:
				case 5:
					count[2] += answers[i] == 2 ? 1 : 0;
					break;
				case 6:
				case 7:
					count[2] += answers[i] == 4 ? 1 : 0;
					break;
				case 8:
				case 9:
					count[2] += answers[i] == 5 ? 1 : 0;
					break;
			}

		}
		int max = count[0];
		for (int i = 1; i <= 2; i++) {
			if (max < count[i]) {
				max = count[i];
			}
		}

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < count.length; i++) {
			if (max == count[i]) {
				list.add(i + 1);
			}
		}

		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		Arrays.sort(answer);
		return answer;
	}
}
