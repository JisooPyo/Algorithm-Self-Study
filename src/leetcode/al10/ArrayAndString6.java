package leetcode.al10;

import java.util.ArrayList;
import java.util.List;

public class ArrayAndString6 {
	public static void main(String[] args) {
		ArrayAndString6 aas6 = new ArrayAndString6();

		System.out.println(aas6.generate(5));
		System.out.println(aas6.generate(1));
	}

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> answer = new ArrayList<>();
		List<Integer> one = new ArrayList<>();
		one.add(1);
		answer.add(one);
		if (numRows == 1) return answer;

		List<Integer> two = new ArrayList<>();
		two.add(1);
		two.add(1);
		answer.add(two);
		if (numRows == 2) return answer;

		for (int i = 3; i <= numRows; i++) {
			List<Integer> element = new ArrayList<>();
			element.add(1);
			for (int j = 0; j <= i - 3; j++) {
				element.add(answer.get(i - 2).get(j) + answer.get(i - 2).get(j + 1));
			}
			element.add(1);
			answer.add(element);
		}
		return answer;
	}
}
