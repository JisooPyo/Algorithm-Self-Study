package programmers.test2304.test230422;

public class Basic067 {

	public static void main(String[] args) {
		Basic067 b = new Basic067();
		String x = "wsdawsdassw";
		System.out.println(b.solution(0, x));

	}

	public int solution(int n, String control) {
		int answer = n;
		String[] sp = control.split("");
		for (int i = 0; i < sp.length; i++) {
			if (sp[i].equals("w")) {
				answer += 1;
			} else if (sp[i].equals("s")) {
				answer -= 1;
			} else if (sp[i].equals("d")) {
				answer += 10;
			} else {
				answer -= 10;
			}
		}

		return answer;
	}

}
