package programmers.test2304.test230426;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Basic111 {

	public static void main(String[] args) {
		Basic111 b = new Basic111();

		int[] s = { 1, 5, 2 };
		int[] num = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		System.out.println(Arrays.toString(b.solution(3, s, num)));
		System.out.println(Arrays.toString(b.solution(4, s, num)));

	}

	public int[] solution(int n, int[] slicer, int[] num_list) {
		int a = slicer[0];
		int b = slicer[1];
		int c = slicer[2];
		List<Integer> list = new ArrayList<>();
		if (n == 1) {
			for (int i = 0; i <= b; i++) {
				list.add(num_list[i]);
			}
		} else if (n == 2) {
			for (int i = a; i < num_list.length; i++) {
				list.add(num_list[i]);
			}
		} else if (n == 3) {
			for (int i = a; i <= b; i++) {
				list.add(num_list[i]);
			}
		} else {
			for (int i = a; i <= b; i += c) {
				list.add(num_list[i]);
			}
		}
		return list.stream().mapToInt(i -> i).toArray();
	}

}
