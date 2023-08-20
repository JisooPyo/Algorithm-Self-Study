package programmers.test2304.test230425;

import java.util.Arrays;

public class Basic095 {

	public static void main(String[] args) {

		Basic095 b = new Basic095();

		String[] x = { "0123456789", "9876543210", "9999999999999" };
		int k = 50000;
		int s = 5;
		int l = 5;

		System.out.println(Arrays.toString(b.solution(x, k, s, l)));

	}

	public int[] solution(String[] intStrs, int k, int s, int l) {
		String[] sub = new String[intStrs.length];
		int[] answer = new int[sub.length];
		for (int i = 0; i < sub.length; i++) {
			sub[i] = intStrs[i].substring(s, s + l);
			answer[i] = Integer.parseInt(sub[i]); // [56789, 43210, 99999]
		}
		return Arrays.stream(answer).filter(i -> i > k).toArray();
	}

}
