package programmers.test2305.test230505;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lev1_019 {

	public static void main(String[] args) {
		long beforeTime = System.currentTimeMillis();
		Lev1_019 lev = new Lev1_019();

		int[] t1 = { 4, 3, 2, 1 };
		int[] t2 = { 10 };

		System.out.println(Arrays.toString(lev.solution(t1)));
		System.out.println(Arrays.toString(lev.solution(t2)));
		long afterTime = System.currentTimeMillis();
		long secDiffTime = afterTime - beforeTime;
		System.out.println("시간차이(ms) : " + secDiffTime);

	}

	public int[] solution(int[] arr) {
		if (arr.length - 1 == 0) {
			return new int[] { -1 };
		}

		List<Integer> list = new ArrayList<>();

		int min = Arrays.stream(arr).min().getAsInt();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != min) {
				list.add(arr[i]);
			}
		}
		return list.stream().mapToInt(i -> i).toArray();

	}

}
