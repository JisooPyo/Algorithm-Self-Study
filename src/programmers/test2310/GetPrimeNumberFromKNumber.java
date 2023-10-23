package programmers.test2310;

public class GetPrimeNumberFromKNumber {
	public static void main(String[] args) {
		GetPrimeNumberFromKNumber g = new GetPrimeNumberFromKNumber();

		System.out.println(g.solution(437674, 3));    // 3
		System.out.println(g.solution(110011, 10));    // 2

	}

	public int solution(int n, int k) {
		// 1. n을 k진법으로 변환
		String kNumber = Integer.toString(n, k);
		String[] numberArr = kNumber.split("0+");

		int count = 0;

		// 2. 변환한 String 끊기
		for (int i = 0; i < numberArr.length; i++) {
			if (!numberArr[i].equals("1")) {
				// 3. 끊은 String 소수 판단
				if (isPrimeNumber(Long.parseLong(numberArr[i]))) {
					// 소수이면 count++
					count++;
				}
			}
		}

		return count;
	}

	private boolean isPrimeNumber(long number) {
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}

/**
 * 테스트 1 〉	통과 (11.77ms, 76.2MB)
 * 테스트 2 〉	통과 (0.12ms, 75.8MB)
 * 테스트 3 〉	통과 (0.16ms, 83.7MB)
 * 테스트 4 〉	통과 (0.18ms, 72MB)
 * 테스트 5 〉	통과 (0.22ms, 73.8MB)
 * 테스트 6 〉	통과 (0.18ms, 74.3MB)
 * 테스트 7 〉	통과 (0.24ms, 73.4MB)
 * 테스트 8 〉	통과 (0.18ms, 72.4MB)
 * 테스트 9 〉	통과 (0.18ms, 67.8MB)
 * 테스트 10 〉	통과 (0.17ms, 75.6MB)
 * 테스트 11 〉	통과 (0.16ms, 78.1MB)
 * 테스트 12 〉	통과 (0.34ms, 73.9MB)
 * 테스트 13 〉	통과 (0.23ms, 77MB)
 * 테스트 14 〉	통과 (0.11ms, 72MB)
 * 테스트 15 〉	통과 (0.28ms, 75.9MB)
 * 테스트 16 〉	통과 (0.23ms, 72.7MB)
 */