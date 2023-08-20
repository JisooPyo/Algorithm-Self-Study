package programmers.test2304.test230426;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Basic112 {

	public static void main(String[] args) {
		Basic112 b = new Basic112();

		int[] x = { 1, 2, 3, 4, 5 };
		int[][] y = { { 1, 3 }, { 0, 4 } };

		System.out.println(Arrays.toString(b.solution(x, y)));

	}

	public int[] solution(int[] arr, int[][] intervals) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < intervals.length; i++) {
			for (int j = intervals[i][0]; j <= intervals[i][1]; j++) {
				list.add(arr[j]);
			}
		}
		return list.stream().mapToInt(i -> i).toArray();
	}

}
