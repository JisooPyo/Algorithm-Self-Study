package programmers.test2304.test230422;

public class Basic071 {

	public static void main(String[] args) {
		Basic071 b = new Basic071();

		String x1 = "AbCdEfG";
		String x2 = "aBc";
		String y1 = "aaAA";
		String y2 = "aaaaa";

		System.out.println(b.solution(x1, x2));
		System.out.println(b.solution(y1, y2));

	}

	public int solution(String myString, String pat) {
		return myString.toLowerCase().contains(pat.toLowerCase()) ? 1 : 0;
	}

}
