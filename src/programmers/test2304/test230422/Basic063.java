package programmers.test2304.test230422;

public class Basic063 {

	public static void main(String[] args) {

		Basic063 b = new Basic063();

		System.out.println(b.solution(2, 6, 1));
		System.out.println(b.solution(5, 3, 3));
		System.out.println(b.solution(4, 4, 4));

	}

	public int solution(int a, int b, int c) {
		int answer = 0;
		if (a != b && a != c && b != c) {
			answer = a + b + c;
		} else if (a == b && b == c) {
			answer = (a + b + c) * (a * a + b * b + c * c) * (a * a * a + b * b * b + c * c * c);
		} else {
			answer = (a + b + c) * (a * a + b * b + c * c);
		}
		return answer;
	}

}
