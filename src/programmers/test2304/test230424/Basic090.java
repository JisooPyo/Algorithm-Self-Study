package programmers.test2304.test230424;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Basic090 {

	public static void main(String[] args) {
		Basic090 b = new Basic090();

		System.out.println(b.solution(2, 2, 2, 2));
		System.out.println(b.solution(4, 1, 4, 4));
		System.out.println(b.solution(6, 3, 3, 6));
		System.out.println(b.solution(2, 5, 2, 6));
		System.out.println(b.solution(6, 4, 2, 5));

		Integer[] arr1 = { 2, 2, 2, 2 };
		Integer[] arr2 = { 4, 1, 4, 4 };
		Integer[] arr3 = { 6, 3, 3, 6 };
		Integer[] arr4 = { 2, 5, 2, 6 };
		Integer[] arr5 = { 6, 4, 2, 5 };

		Set<Integer> set1 = new TreeSet<Integer>(Arrays.asList(arr1));
		Set<Integer> set2 = new TreeSet<Integer>(Arrays.asList(arr2));
		Set<Integer> set3 = new TreeSet<Integer>(Arrays.asList(arr3));
		Set<Integer> set4 = new TreeSet<Integer>(Arrays.asList(arr4));
		Set<Integer> set5 = new TreeSet<Integer>(Arrays.asList(arr5));

		System.out.println(set1); // [2]
		System.out.println(set2); // [1, 4]
		System.out.println(set3); // [3, 6]
		System.out.println(set4); // [2, 5, 6]
		System.out.println(set5); // [2, 4, 5, 6]

	}

	public int solution(int a, int b, int c, int d) {
		int answer = 0;
		Integer[] arr = { a, b, c, d };
		Arrays.sort(arr);
		TreeSet<Integer> set = new TreeSet<Integer>(Arrays.asList(arr));
		if (set.size() == 4) {
			answer = set.first().intValue();
		} else if (set.size() == 1) {
			answer = a * 1111;
		} else if (set.size() == 3) {
			if (arr[0] == arr[1]) {
				answer = arr[2] * arr[3];
			} else if (arr[1] == arr[2]) {
				answer = arr[0] * arr[3];
			} else {
				answer = arr[0] * arr[1];
			}
		} else {
			if (arr[0] == arr[1] && arr[2] == arr[3]) {
				answer = (arr[0] + arr[2]) * Math.abs(arr[0] - arr[2]);
			} else {
				if (arr[0] == arr[1] && arr[1] == arr[2]) {
					answer = (10 * arr[0] + arr[3]) * (10 * arr[0] + arr[3]);
				} else if (arr[1] == arr[2] && arr[2] == arr[3]) {
					answer = (10 * arr[1] + arr[0]) * (10 * arr[1] + arr[0]);
				}
			}
		}

		return answer;
	}

}