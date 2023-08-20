package programmers.test2304.test230421;

public class Basic036 {

	public static void main(String[] args) {

		Basic036 b = new Basic036();

		String x1 = "banana";
		String x2 = "ana";
		String y1 = "banana";
		String y2 = "wxyz";

		System.out.println(b.solution(x1, x2));
		System.out.println(b.solution(y1, y2));

	}

	public int solution(String my_string, String target) {
		return my_string.contains(target) ? 1 : 0;
	}

}
