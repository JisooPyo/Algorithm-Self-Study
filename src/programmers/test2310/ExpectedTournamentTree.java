package programmers.test2310;

public class ExpectedTournamentTree {
	public static void main(String[] args) {
		ExpectedTournamentTree ett = new ExpectedTournamentTree();

		System.out.println(ett.solution(8, 4, 7));
	}

	public int solution(int n, int a, int b) {
		int answer = 0;
		while (a != b) {
			a = (a + 1) / 2;
			b = (b + 1) / 2;
			answer++;
		}
		return answer;
	}
}

/*
정확성  테스트
테스트 1 〉통과 (0.02ms, 72.4MB)
테스트 2 〉통과 (0.04ms, 78.5MB)
테스트 3 〉통과 (0.01ms, 86.6MB)
테스트 4 〉통과 (0.03ms, 69.5MB)
테스트 5 〉통과 (0.02ms, 81.2MB)
테스트 6 〉통과 (0.03ms, 78.8MB)
테스트 7 〉통과 (0.02ms, 68MB)
테스트 8 〉통과 (0.01ms, 77.9MB)
테스트 9 〉통과 (0.03ms, 77.5MB)
테스트 10 〉통과 (0.02ms, 72.2MB)
테스트 11 〉통과 (0.01ms, 79.1MB)
테스트 12 〉통과 (0.02ms, 78MB)
테스트 13 〉통과 (0.02ms, 75.3MB)
테스트 14 〉통과 (0.02ms, 72.9MB)
테스트 15 〉통과 (0.03ms, 73.2MB)
테스트 16 〉통과 (0.02ms, 74.1MB)
테스트 17 〉통과 (0.02ms, 75.2MB)
테스트 18 〉통과 (0.02ms, 73.9MB)
테스트 19 〉통과 (0.02ms, 74MB)
테스트 20 〉통과 (0.02ms, 74.8MB)
테스트 21 〉통과 (0.02ms, 79.5MB)
테스트 22 〉통과 (0.03ms, 77.2MB)
테스트 23 〉통과 (0.01ms, 81.3MB)
테스트 24 〉통과 (0.03ms, 73.4MB)
테스트 25 〉통과 (0.02ms, 77.5MB)
테스트 26 〉통과 (0.02ms, 80.3MB)
테스트 27 〉통과 (0.03ms, 75.9MB)
테스트 28 〉통과 (0.01ms, 78.5MB)
테스트 29 〉통과 (0.02ms, 77.8MB)
테스트 30 〉통과 (0.01ms, 76.8MB)
테스트 31 〉통과 (0.02ms, 73.4MB)
테스트 32 〉통과 (0.03ms, 83.2MB)
테스트 33 〉통과 (0.01ms, 76.7MB)
테스트 34 〉통과 (0.02ms, 65.9MB)
 */