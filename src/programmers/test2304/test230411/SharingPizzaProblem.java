package programmers.test2304.test230411;

public class SharingPizzaProblem {
	
	public static void main(String[] args) {
		
		SharingPizzaProblem sp = new SharingPizzaProblem();
		
		System.out.println(sp.solution(7));
		System.out.println(sp.solution(1));
		System.out.println(sp.solution(15));
		

	}
	
	 public int solution(int n) {
	        int answer = 0;
	        if(n%7==0) {
	        	answer = n/7;
	        } else {
	        	answer = n/7+1;
	        }
	        return answer;
	    }

}
