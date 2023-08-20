package programmers.test2304.test230411;

public class DivisorPlusProblem {

	public static void main(String[] args) {
		
		DivisorPlusProblem dp = new DivisorPlusProblem();
				
		System.out.println(dp.solution(12));
		System.out.println(dp.solution(5));
		

	}
	

	public int solution(int n) {
		int answer = 0;
		
		for(int i = 1 ; i<=n ; i++) {
			if(n%i==0) {
				answer = answer + i;
			}
		}
		return answer;
	}


}
