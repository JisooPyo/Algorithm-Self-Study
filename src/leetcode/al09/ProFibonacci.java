package leetcode.al09;

public class ProFibonacci {
	public static void main(String[] args) {
		ProFibonacci pf = new ProFibonacci();
		System.out.println(pf.solution(3));
		System.out.println(pf.solution(5));
		System.out.println(pf.solution(20));
		System.out.println(pf.solution(100_000));
	}

	public int solution(int n) {
		int[] fibonacci = new int[n + 1];
		fibonacci[0] = 0;
		fibonacci[1] = 1;
		for (int i = 2; i <= n; i++) {
			fibonacci[i] = (fibonacci[i - 1] + fibonacci[i - 2]) % 1234567;
		}
		return fibonacci[n] % 1234567;
	}

}
