package programmers.test2306.test230628;

public class Lv2FibonacciNumber_try2 {
	public static void main(String[] args) {
		Lv2FibonacciNumber_try2 lv = new Lv2FibonacciNumber_try2();
		System.out.println(lv.fibonacci(20));
	}

	public int fibonacci(int n) {
		int[] memo = new int[n + 1]; // 중간 결과를 저장할 배열
		return fibonacciHelper(n, memo);
	}

	private int fibonacciHelper(int n, int[] memo) {
		// 중간 결과가 이미 계산되어 저장된 경우, 바로 반환
		if (memo[n] != 0) {
			return memo[n];
		}

		// 피보나치 수 계산
		if (n <= 1) {
			memo[n] = n;
		} else {
			memo[n] = fibonacciHelper(n - 1, memo) + fibonacciHelper(n - 2, memo);
		}

		return memo[n];
	}
}
/*
 */
