package programmers.test2304.test230411;

public class SharingPizzaProblem3 {

	public static void main(String[] args) {
		SharingPizzaProblem3 sp = new SharingPizzaProblem3();
		
		System.out.println(sp.solution(7, 10));
		System.out.println(sp.solution(4, 12));

	}
	
    public int solution(int slice, int n) {
        int answer = 0;
        
        for(int i=1 ; i<=n ; i++ ) {
        	if(slice*i>=n) {
        		answer = i;
        		break;
        	}
        }
        	
        return answer;
    }

}
