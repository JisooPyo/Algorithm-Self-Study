package programmers.test2304.test230420;

public class Basic033 {

	public static void main(String[] args) {

		Basic033 b = new Basic033();

		String x = "aaaaa";
		String y = "bbbbb";

		System.out.println(b.solution(x, y));

	}

	public String solution(String str1, String str2) {
		String answer = "";
		for (int i = 0; i < str1.length(); i++) {
			answer+=str1.charAt(i);
			answer+=str2.charAt(i);
		}
		return answer;
	}

}
