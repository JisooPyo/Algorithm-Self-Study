package programmers.test2305.test230507;

import java.util.Arrays;

public class Lev1_035 {

	public static void main(String[] args) {
		Lev1_035 lev = new Lev1_035();

		int[] t1 = { 1, 3, 2, 5, 4 };
		int[] t2 = { 2, 2, 3, 3 };

		System.out.println(lev.solution(t1, 9)); // 3
		System.out.println(lev.solution(t1, 10)); // 4
		System.out.println(lev.solution(t1, 14)); // 4
		System.out.println(lev.solution(t2, 10)); // 4

	}

	public int solution(int[] d, int budget) {
		int answer = 0;
		int sum = 0;
		Arrays.sort(d);
		for (int i = 0; i < d.length; i++) {
			sum += d[i];
		}
		if (sum <= budget) {
			return d.length;
		} else {
			sum = 0;
			for (int i = 0; i < d.length; i++) {
				sum += d[i];
				answer = i;
				if (sum > budget) {
					break;
				}
			}
			return answer;

		}
	}

}

/*

다른 사람의 풀이
budget에서 뺄걸..!!

public int solution(int[] d, int budget) {
	int answer = 0;
	Arrays.sort(d);
	for (int i = 0; i < d.length; i++) {
		budget -= d[i];
        if (budget < 0) break;
        	answer++;
        }
	return answer;
}

*/