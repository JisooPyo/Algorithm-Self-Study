package programmers.test2304.test230420;

public class Basic028 {

	public static void main(String[] args) {
		
		Basic028 b = new Basic028();
		
		System.out.println(b.solution(98, 2));
		System.out.println(b.solution(34, 3));

	}
	
    public int solution(int num, int n) {
        if(num%n==0) {
        	return 1;
        } else {
        	return 0;
        }
    }

}
