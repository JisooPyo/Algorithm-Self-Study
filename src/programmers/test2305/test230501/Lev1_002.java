package programmers.test2305.test230501;

public class Lev1_002 {

	public static void main(String[] args) {
		Lev1_002 lev = new Lev1_002();
		
		int[] t1 = {1,2,3,4};
		int[] t2 = {5,5};
		
		System.out.println(lev.solution(t1));
		System.out.println(lev.solution(t2));

	}

	public double solution(int[] arr) {
		double answer = 0;
		for (int n : arr) {
			answer += n;
		}
		
		return answer / arr.length;
	}

}
