package programmers.test2304.test230421;

import java.util.Arrays;

public class Basic047 {

	public static void main(String[] args) {

		Basic047 b = new Basic047();

		System.out.println(Arrays.toString(b.solution(10, 3)));

	}

	public int[] solution(int start, int end) {
		int[] answer = new int[start - end + 1];
		for (int i = 0; i < answer.length; i++) {
			answer[i]=start-i;
		}
		return answer;
	}

}

/*

다른 사람의 풀이

return IntStream.rangeClosed(-start, -end).map(i -> -i).toArray();

*/