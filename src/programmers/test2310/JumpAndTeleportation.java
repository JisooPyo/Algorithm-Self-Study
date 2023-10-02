package programmers.test2310;

public class JumpAndTeleportation {
	public static void main(String[] args) {
		JumpAndTeleportation jat = new JumpAndTeleportation();

		System.out.println(jat.solution(5));
		System.out.println(jat.solution(6));
		System.out.println(jat.solution(5000));
	}

	public int solution(int n) {
		int ans = 0;
		while (n > 1) {
			if (n % 2 == 0) {
				n /= 2;
			} else {
				n -= 1;
				ans++;
			}
		}
		return ans + 1;
	}
}

/*
정확성  테스트
테스트 1 〉통과 (0.03ms, 76.8MB)
테스트 2 〉통과 (0.02ms, 77.4MB)
테스트 3 〉통과 (0.01ms, 81.8MB)
테스트 4 〉통과 (0.02ms, 75.5MB)
테스트 5 〉통과 (0.02ms, 74.9MB)
테스트 6 〉통과 (0.02ms, 72.2MB)
테스트 7 〉통과 (0.02ms, 76.3MB)
테스트 8 〉통과 (0.03ms, 80.6MB)
테스트 9 〉통과 (0.03ms, 81.5MB)
테스트 10 〉통과 (0.02ms, 72.1MB)
테스트 11 〉통과 (0.02ms, 75.3MB)
테스트 12 〉통과 (0.02ms, 76.1MB)
테스트 13 〉통과 (0.02ms, 72.7MB)
테스트 14 〉통과 (0.02ms, 75.6MB)
테스트 15 〉통과 (0.01ms, 74.2MB)
테스트 16 〉통과 (0.01ms, 75.5MB)
테스트 17 〉통과 (0.01ms, 75.1MB)
테스트 18 〉통과 (0.01ms, 77MB)

효율성  테스트
테스트 1 〉통과 (0.02ms, 51.6MB)
테스트 2 〉통과 (0.02ms, 52.4MB)
테스트 3 〉통과 (0.02ms, 52.4MB)
테스트 4 〉통과 (0.02ms, 52.3MB)
테스트 5 〉통과 (0.02ms, 51.5MB)
테스트 6 〉통과 (0.02ms, 51.9MB)
테스트 7 〉통과 (0.02ms, 51.8MB)
테스트 8 〉통과 (0.02ms, 52.2MB)
테스트 9 〉통과 (0.02ms, 52.1MB)
테스트 10 〉통과 (0.02ms, 52.1MB)
 */