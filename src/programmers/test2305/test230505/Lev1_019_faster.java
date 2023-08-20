package programmers.test2305.test230505;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lev1_019_faster {

	public static void main(String[] args) {
		long beforeTime = System.currentTimeMillis();
		Lev1_019_faster lev = new Lev1_019_faster();

		int[] t1 = { 4, 3, 2, 1 };
		int[] t2 = { 10 };
		int[] t3 = { 1, 2, 3, 4, 5, 6, 7 };

		System.out.println(Arrays.toString(lev.solution(t1)));
		System.out.println(Arrays.toString(lev.solution(t2)));
		System.out.println(Arrays.toString(lev.solution(t3)));
		long afterTime = System.currentTimeMillis();
		long secDiffTime = afterTime - beforeTime;
		System.out.println("시간차이(ms) : " + secDiffTime);

	}

	public int[] solution(int[] arr) {
		if (arr.length - 1 == 0) {
			return new int[] { -1 };
		}

		List<Integer> list = new ArrayList<>();
		int min = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (min > arr[i]) {
				min = arr[i];
			}
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != min) {
				list.add(arr[i]);
			}
		}

		int[] answer = new int[arr.length - 1];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}

		return answer;

	}

}
