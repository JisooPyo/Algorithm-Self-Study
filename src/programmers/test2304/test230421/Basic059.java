package programmers.test2304.test230421;

public class Basic059 {

	public static void main(String[] args) {
		Basic059 b = new Basic059();

		String x1 = "banana";
		String x2 = "ana";
		String y1 = "aaaa";
		String y2 = "aa";

		System.out.println(b.solution(x1, x2));
		System.out.println(b.solution(y1, y2));

	}

	public int solution(String myString, String pat) {
		int answer = 0;
		while (myString.indexOf(pat) != -1) {
			myString = myString.substring(myString.indexOf(pat)+1);
			answer++;
		}
		return answer;
	}

}
