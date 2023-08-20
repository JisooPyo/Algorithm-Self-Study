package programmers.test2305.test230504;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lev1_016 {

	public static void main(String[] args) {
		Lev1_016 lev = new Lev1_016();

		int[] t1 = { 5, 9, 7, 10 };
		int[] t2 = { 2, 36, 1, 3 };
		int[] t3 = { 3, 2, 6 };

		System.out.println(Arrays.toString(lev.solution(t1, 5)));
		System.out.println(Arrays.toString(lev.solution(t2, 1)));
		System.out.println(Arrays.toString(lev.solution(t3, 10)));

	}

	public int[] solution(int[] arr, int divisor) {
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % divisor == 0) {
				list.add(arr[i]);
			}
		}

		Collections.sort(list);
		return list.size() == 0 ? new int[] { -1 } : list.stream().mapToInt(i -> i).toArray();
	}

}
/*

import java.util.Arrays;

class Solution {
  public int[] solution(int[] arr, int divisor) {
          int[] answer = Arrays.stream(arr).filter(factor -> factor % divisor == 0).toArray();
          if(answer.length == 0) answer = new int[] {-1};
          java.util.Arrays.sort(answer);
          return answer;
  }
}

*/