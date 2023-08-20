package programmers.test2304.test230424;

public class Basic092 {

	public static void main(String[] args) {
		Basic092 b = new Basic092();

		String x = "abstract algebra";
		String y = "PrOgRaMmErS";

		System.out.println(b.solution(x));
		System.out.println(b.solution(y));

	}

	public String solution(String myString) {
		String answer = myString.toLowerCase();
		char[] c = answer.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (Character.compare(c[i], 'a') == 0) {
				c[i]='A';
			}
		}
		return new String(c);
	}

}
