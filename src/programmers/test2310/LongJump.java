package programmers.test2310;

public class LongJump {
	public static void main(String[] args) {
		LongJump lj = new LongJump();

		System.out.println(lj.solution(4));
		System.out.println(lj.solution(3));
	}

	public long solution(int n) {
		if (n == 1) return 1;
		if (n == 2) return 2;
		int[] method = new int[n];
		method[0] = 1;
		method[1] = 2;
		for (int i = 2; i < n; i++) {
			method[i] = (method[i - 1] + method[i - 2]) % 1234567;
		}
		return method[n - 1];
	}
}

// P(n) = P(n-1) + P(n-2)

/*
테스트 1 〉통과 (0.10ms, 77.4MB)
테스트 2 〉통과 (0.07ms, 71.5MB)
테스트 3 〉통과 (0.04ms, 81.9MB)
테스트 4 〉통과 (0.05ms, 71.3MB)
테스트 5 〉통과 (0.05ms, 72.5MB)
테스트 6 〉통과 (0.05ms, 78MB)
테스트 7 〉통과 (0.06ms, 75.8MB)
테스트 8 〉통과 (0.08ms, 76.4MB)
테스트 9 〉통과 (0.08ms, 75MB)
테스트 10 〉통과 (0.07ms, 74.4MB)
테스트 11 〉통과 (0.15ms, 73.3MB)
테스트 12 〉통과 (0.13ms, 76.9MB)
테스트 13 〉통과 (0.07ms, 77.8MB)
테스트 14 〉통과 (0.11ms, 75.7MB)
테스트 15 〉통과 (0.12ms, 73.3MB)
테스트 16 〉통과 (0.13ms, 72.7MB)
 */