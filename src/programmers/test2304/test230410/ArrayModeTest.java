package programmers.test2304.test230410;

public class ArrayModeTest {

	public static void main(String[] args) {
		ArrayModeProblem amp = new ArrayModeProblem();
		
		int[] a = {1, 2, 3, 3, 3, 4};
		int[] b = {1, 1, 2, 2};
		int[] c = {1};
		
		System.out.println(amp.solution(a));
		System.out.println(amp.solution(b));
		System.out.println(amp.solution(c));
		

	}

}
