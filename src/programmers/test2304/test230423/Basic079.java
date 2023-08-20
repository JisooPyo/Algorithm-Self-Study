package programmers.test2304.test230423;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Basic079 {

	public static void main(String[] args) {

		Basic079 b = new Basic079();

		int x[] = { 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		int y[] = { 1, 9, 3, 10, 13, 5 };
		int z[] = { 2, 100, 120, 600, 12, 12 };

		System.out.println(Arrays.toString(b.solution(3, x)));
		System.out.println(Arrays.toString(b.solution(5, y)));
		System.out.println(Arrays.toString(b.solution(12, z)));

	}

	public int[] solution(int n, int[] numlist) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < numlist.length; i++) {
			if (numlist[i] % n == 0) {
				list.add(numlist[i]);
			}
		}
		return list.stream().mapToInt(i -> i).toArray();
	}

}

/*

다른 사람의 풀이

    public int[] solution(int n, int[] numList) {
        return Arrays.stream(numList).filter(value -> value % n == 0).toArray();
    }

*/
