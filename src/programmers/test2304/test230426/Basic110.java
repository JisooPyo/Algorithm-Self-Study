package programmers.test2304.test230426;

public class Basic110 {

	public static void main(String[] args) {
		Basic110 b = new Basic110();

		int[] x = { 0, 0, 0, 1 };
		int[] y = { 1, 0, 0, 1, 0, 0 };
		int[] z = { 1, 1, 1, 1, 0 };

		System.out.println(b.solution(x, 1));
		System.out.println(b.solution(y, 4));
		System.out.println(b.solution(z, 3));

	}

	public int solution(int[] arr, int idx) {
		int answer = -1;
		for (int i = idx; i < arr.length; i++) {
			if (arr[i] == 1) {
				return i;
			}
		}
		return answer;
	}

}

/*

다른 사람의 풀이

import java.util.stream.IntStream;

class Solution {
    public int solution(int[] arr, int idx) {
        return IntStream.range(idx, arr.length).filter(i -> arr[i] == 1).findFirst().orElse(-1);
    }
}

*/