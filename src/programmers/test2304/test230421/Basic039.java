package programmers.test2304.test230421;

public class Basic039 {

	public static void main(String[] args) {

		Basic039 b = new Basic039();

		System.out.println(b.solution(60, 2, 3));
		System.out.println(b.solution(55, 10, 5));

	}

	public int solution(int number, int n, int m) {
		return number % n == 0 && number % m == 0 ? 1 : 0;
	}

}
