package programmers.test2305.test230507;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lev1_033 {

	public static void main(String[] args) {
		Lev1_033 lev = new Lev1_033();

		int[] t1 = { 1, 1, 3, 3, 0, 1, 1 };
		int[] t2 = { 4, 4, 4, 3, 3 };

		System.out.println(Arrays.toString(lev.solution(t1)));
		System.out.println(Arrays.toString(lev.solution(t2)));

	}

	public int[] solution(int[] arr) {
		List<Integer> list = new ArrayList<Integer>();

		list.add(arr[0]);

		for (int i = 1; i < arr.length; i++) {
			if (list.get(list.size() - 1).intValue() == arr[i]) {
				continue;
			} else {
				list.add(arr[i]);
			}
		}

		int[] answer = new int[list.size()];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i).intValue();
		}

		return answer;
	}

}
