package programmers.test2304.test230425;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Basic105 {

	public static void main(String[] args) {
		Basic105 b = new Basic105();

		int[] x = { 49, 12, 100, 276, 33 };
		int[] y = { 444, 555, 666, 777 };

		System.out.println(Arrays.toString(b.solution(x, 27)));
		System.out.println(Arrays.toString(b.solution(y, 100)));

	}

	public int[] solution(int[] arr, int n) {
		List<Integer> list = new ArrayList<>();
		if (arr.length % 2 == 0) {
			for (int i = 0; i < arr.length; i++) {
				if (i % 2 == 1) {
					list.add(arr[i] + n);
				} else {
					list.add(arr[i]);
				}
			}
		} else {
			for (int i = 0; i < arr.length; i++) {
				if (i % 2 == 0) {
					list.add(arr[i] + n);
				} else {
					list.add(arr[i]);
				}
			}
		}
		return list.stream().mapToInt(i -> i).toArray();
	}

}

/*

import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] arr, int n) {
        return IntStream.range(0, arr.length)
        	.map(i -> arr[i] + (i % 2 == (arr.length % 2 == 0 ? 1 : 0) ? n : 0))
        	.toArray();
    }
}

*/