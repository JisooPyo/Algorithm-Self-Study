package programmers.test2304.test230421;

public class Basic056 {

	public static void main(String[] args) {

		Basic056 b = new Basic056();

		String x = "123";
		String y = "78720646226947352489";

		System.out.println(b.solution(x));
		System.out.println(b.solution(y));

	}

	public int solution(String number) {
		int sum = 0;
		for (int i = 0; i < number.length(); i++) {
			sum += Character.getNumericValue(number.charAt(i));
		}

		return sum % 9;
	}

}
