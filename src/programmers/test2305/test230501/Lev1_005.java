package programmers.test2305.test230501;

public class Lev1_005 {

	public static void main(String[] args) {
		Lev1_005 lev = new Lev1_005();
		
		System.out.println(lev.solution(10));
		System.out.println(lev.solution(12));

	}

	public int solution(int n) {
		int answer = 0;
		for (int i = 1; i < n; i++) {
			if (n % i == 1) {
				answer = i;
				break;
			}
		}
		return answer;
	}

}
