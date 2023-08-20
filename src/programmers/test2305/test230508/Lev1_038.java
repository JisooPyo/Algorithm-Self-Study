// 비밀지도

package programmers.test2305.test230508;

import java.util.Arrays;

public class Lev1_038 {

	public static void main(String[] args) {

		Lev1_038 lev = new Lev1_038();

		int[] t1_1 = { 9, 20, 28, 18, 11 };
		int[] t1_2 = { 30, 1, 21, 17, 28 };

		int[] t2_1 = { 46, 33, 33, 22, 31, 50 };
		int[] t2_2 = { 27, 56, 19, 14, 14, 10 };

		System.out.println(Arrays.toString(lev.solution(5, t1_1, t1_2)));
		System.out.println(Arrays.toString(lev.solution(6, t2_1, t2_2)));

	}

	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] bin1 = new String[n];
		String[] bin2 = new String[n];

		for (int i = 0; i < arr1.length; i++) {
			String s1 = Integer.toBinaryString(arr1[i]);
			String s2 = Integer.toBinaryString(arr2[i]);
			if (s1.length() < n) {
				s1 = "0".repeat(n - s1.length()) + s1;
			}
			if (s2.length() < n) {
				s2 = "0".repeat(n - s2.length()) + s2;
			}

			bin1[i] = s1;
			bin2[i] = s2;
		}

		String[] answer = new String[n];
		for (int i = 0; i < n; i++) {
			answer[i] = "";
			for (int j = 0; j < n; j++) {
				if (bin1[i].charAt(j) == '0' && bin2[i].charAt(j) == '0') {
					answer[i] += " ";
				} else {
					answer[i] += "#";
				}
			}
		}

		return answer;
	}

}

/*
 * 다른 사람의 풀이 Integer.toBinaryString(n1 | n2) >> n1과 n2를 이진법으로 바꾼뒤, or시켜 보여준다.
 * 
 * String[] result = new String[5]; for (int i = 0; i < 5; i++) { result[i] =
 * Integer.toBinaryString(t1_1[i] | t1_2[i]); }
 * System.out.println("result = "+Arrays.toString(result));
 * 
 */