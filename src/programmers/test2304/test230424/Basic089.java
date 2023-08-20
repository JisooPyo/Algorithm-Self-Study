package programmers.test2304.test230424;

public class Basic089 {

	public static void main(String[] args) {

		Basic089 b = new Basic089();
		
		System.out.println(b.solution(false, true, true, true));
		System.out.println(b.solution(true, false, false, false));

	}

	public boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {
		boolean answer = (x1 || x2) && (x3 || x4);
		return answer;
	}

}
