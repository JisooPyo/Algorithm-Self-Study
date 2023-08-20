package programmers.test2304.test230420;

import java.util.Arrays;

public class Basic026 {

	public static void main(String[] args) {

		Basic026 b = new Basic026();

		int[] x = { 1, 2, 3, 100, 99, 98 };

		System.out.println(Arrays.toString(b.solution(x, 3)));
		System.out.println(Arrays.toString(b.solution(x, 2)));
	}

	public int[] solution(int[] arr, int k) {
		int[] answer = new int[arr.length];
		for (int i = 0; i < answer.length; i++) {
			if(k%2==1) {
				answer[i]=arr[i]*k;
			} else {
				answer[i]=arr[i]+k;
			}
		}
		return answer;
	}

}
