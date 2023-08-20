package programmers.test2304.test230411;

public class SharingPizzaProblem2 {

	public static void main(String[] args) {

		SharingPizzaProblem2 sptwo = new SharingPizzaProblem2();

		System.out.println(sptwo.solution(6));
		System.out.println(sptwo.solution(10));
		System.out.println(sptwo.solution(4));
		

	}

	public int solution(int n) {
		int answer = 0;
		for(int i = 1 ; i <= n ; i++) {
			if((6*i)%n==0) {
				answer = i;
				break;
			}
		}
		return answer;
	}

}
