package programmers.test2304.test230417;

import java.util.Arrays;

public class PrimeFactorizationProblem {

	public static void main(String[] args) {

		PrimeFactorizationProblem pf = new PrimeFactorizationProblem();

		System.out.println(Arrays.toString(pf.solution(12)));
		System.out.println(Arrays.toString(pf.solution(17)));
		System.out.println(Arrays.toString(pf.solution(420)));
		System.out.println(Arrays.toString(pf.solution(210)));
		System.out.println(Arrays.toString(pf.solution(10000)));

	}

	public int[] solution(int n) {

		int tempN = n; // n 값을 빌려 쓸 임시 n
		int count = 0;
		while (tempN > 1) {
			for (int i = 2; i <= tempN; i++) {
				if (tempN % i == 0) {
					tempN = tempN / i;
					count++;
					break;
				}
			}
		}
//		ex.
//		12 -> {2,2,3} -> 3
//		17 -> {17} -> 1
//		420 -> {2,2,3,5,7} -> 5

		int[] answer = new int[count]; // ex. 12 -> { , , }

		while (n > 1) {
			for (int j = 0; j < count; j++) {
				for (int i = 2; i <= n; i++) {
					if (n % i == 0) {
						n = n / i;
						answer[j] = i;
						break;
					}
				}
			}
		}
//		ex. 12 -> {2,2,3}

		answer = Arrays.stream(answer).distinct().toArray();
		Arrays.sort(answer);
//		answer 배열에서 중복값 제거

		return answer;
	}
}

//test 1,7,16
