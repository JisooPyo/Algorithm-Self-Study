package programmers.test2304.test230420;

public class Basic034 {

	public static void main(String[] args) {

		Basic034 b = new Basic034();

		System.out.println(b.solution(-4, 7, true));
		System.out.println(b.solution(-4, 7, false));

	}

	public int solution(int a, int b, boolean flag) {
		int answer = 0;
		if (flag) {
			answer = a + b;
		} else {
			answer = a - b;
		}
		return answer;
	}

}
