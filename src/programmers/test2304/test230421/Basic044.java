package programmers.test2304.test230421;

import java.util.Arrays;

public class Basic044 {

	public static void main(String[] args) {
		Basic044 b = new Basic044();

		int[] x = { 2, 1, 6 };
		int[] y = { 5, 2, 1, 7, 5 };
		
		System.out.println(Arrays.toString(b.solution(x, 1)));
		System.out.println(Arrays.toString(b.solution(y, 3)));

	}

	public int[] solution(int[] num_list, int n) {
		int[] answer = new int[n];
		for (int i = 0; i < n; i++) {
			answer[i] = num_list[i];
		}

		return answer;
	}

}

/*

다른 사람의 풀이 Arrays.copyOfRange 사용

    public int[] solution(int[] num_list, int n) {
        int[] answer = {};

        answer = Arrays.copyOfRange(num_list,0,n);

        return answer;
    }

*/