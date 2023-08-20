package programmers.test2307.test0703;

import java.util.ArrayList;
import java.util.List;

public class HaenaTernaryFlip {
	public static void main(String[] args) {
		SolutionHn sol = new SolutionHn();
		System.out.println(sol.solution(45));
		System.out.println(sol.solution(125));
	}
}

class SolutionHn {
	public int solution(int n) {
		// 뒤집어진 3진법 구하기
		List<Integer> list = new ArrayList<>();
		while (n != 0) {
			list.add(n % 3);
			n /= 3;
		}

		// 뒤집어진 3진법을 순서대로 돌면서 답을 구하기
		int answer = 0;
		for (int i = 0, j = list.size() - 1; i < list.size(); i++, j--) {
			answer += Math.pow(3, j) * list.get(i);
			// Math.pow는 double형이고, list.get(i)는 list에서 가져오기 때문에 Object로 인식히여 int 강제 형변환 필요
		}
		return answer;
	}
}
