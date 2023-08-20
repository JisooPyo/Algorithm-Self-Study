package programmers.test2304.test230420;

import java.util.Arrays;

public class Basic021 {

	public static void main(String[] args) {
		Basic021 b = new Basic021();

		int[] x = { 12, 4, 15, 46, 38, 1, 14, 56, 32, 10 };

		System.out.println(Arrays.toString(b.solution(x)));

	}

	public int[] solution(int[] num_list) {
		Arrays.sort(num_list);
		return Arrays.copyOfRange(num_list, 5, num_list.length);
	}

}

/*

Arrays.copyOfRange(arr,int a,int b);
arr 배열을 a부터 b번까지 인덱스를 잘라서 주세요.


*/
