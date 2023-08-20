// 두 개 뽑아서 더하기
package programmers.test2305.test230509;

import java.util.Arrays;
import java.util.HashSet;

public class Lev1_043 {

	public static void main(String[] args) {
		Lev1_043 lev = new Lev1_043();

		int[] t1 = { 2, 1, 3, 4, 1 };
		int[] t2 = { 5, 0, 2, 7 };

		System.out.println(Arrays.toString(lev.solution(t1)));
		System.out.println(Arrays.toString(lev.solution(t2)));

	}

	public int[] solution(int[] numbers) {
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				set.add(numbers[i] + numbers[j]);
			}
		}
		Integer[] temp = set.toArray(new Integer[0]);
		int[] answer = new int[temp.length];
		for (int i = 0; i < temp.length; i++) {
			answer[i] = temp[i].intValue();
		}
		Arrays.sort(answer);
		return answer;
	}

}

/*

다른 사람의 풀이

TreeSet을 이용하면 add하면서 정렬도 같이 된다..!
-------------------------------------
set.stream().sorted().mapToInt(Integer::intValue).toArray();
로 하면 한번에 가능! 다만 느리다.


*/