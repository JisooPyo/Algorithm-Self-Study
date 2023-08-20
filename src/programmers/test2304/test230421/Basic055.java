package programmers.test2304.test230421;

public class Basic055 {

	public static void main(String[] args) {

		Basic055 b = new Basic055();

		String x = "123456789";
		String y = "1000000";

		System.out.println(b.solution(x));
		System.out.println(b.solution(y));

	}

	public int solution(String num_str) {
		int sum = 0;
		for (int i = 0; i < num_str.length(); i++) {
			sum+= Character.getNumericValue(num_str.charAt(i));
		}
		return sum;
	}

}
