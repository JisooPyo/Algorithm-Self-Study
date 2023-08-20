package programmers.test2304.test230419;

public class FindStringProblem {

	public static void main(String[] args) {

		FindStringProblem fs = new FindStringProblem();

		String x1 = "ab6CDE443fgh22iJKlmn1o";
		String x2 = "6CD";
		String y1 = "ppprrrogrammers";
		String y2 = "pppp";
		String z1 = "AbcAbcA";
		String z2 = "AAA";

		System.out.println(fs.solution(x1, x2));
		System.out.println(fs.solution(y1, y2));
		System.out.println(fs.solution(z1, z2));

	}

	public int solution(String str1, String str2) {
		int answer = 0;
		if(str1.contains(str2)) {
			answer = 1;
		} else {
			answer = 2;
		}
		return answer;
	}

}

// String.contains(String2)
// String 안에 String2가 있나요?