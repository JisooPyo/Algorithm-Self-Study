package programmers.test2304.test230420;

public class Basic022 {

	public static void main(String[] args) {
		Basic022 b = new Basic022();

		String x = "abcdevwxyz";
		String y = "jjnnllkkmm";

		System.out.println(b.solution(x));
		System.out.println(b.solution(y));

	}

	public String solution(String myString) {
		String answer = "";
//      "l"=108
		for (int i = 0; i < myString.length(); i++) {
			if (myString.charAt(i) < 108) {
				answer += "l";
			} else {
				answer += myString.charAt(i);
			}

		}
		return answer;
	}

}

// myString.charAt(i) < 108
// 에서 108대신 'l'을 넣어도 된다!