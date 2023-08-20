package programmers.test2304.test230417;

import java.util.LinkedHashSet;

public class PrimeFactorizationProblemRe {

	public static void main(String[] args) {

		PrimeFactorizationProblemRe pfr = new PrimeFactorizationProblemRe();

		System.out.println(pfr.solution(12));
		System.out.println(pfr.solution(17));
		System.out.println(pfr.solution(420));
		System.out.println(pfr.solution(10000));

	}

	public LinkedHashSet<Integer> solution(int n) {

		LinkedHashSet<Integer> prime = new LinkedHashSet<>();

		int tempN = n;

		while (n > 1) {
			for (int i = 2; i <= tempN; i++) {
				if (n % i == 0) {
					n = n / i;
					prime.add(i);
					break;
				}
			}
		}

		return prime;

	}

}


// linkedHashSet
// https://crazykim2.tistory.com/582